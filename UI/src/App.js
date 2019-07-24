import React, { Component } from "react";
import "./App.css";
import Header from "./Header/Header";
import {
  getProducts,
  searchFlights,
  addPassenger
} from "./Redux/Actions/products";
import { getAirports } from "./Redux/Actions/airports";
import { connect } from "react-redux";
import ContentContainer from "./Containers/ContentContainer";
import {
  menuClicked,
  createSearchAction,
  hideNotification
} from "./Redux/Actions/ui";
import { Layout, Content, Cell, Button } from "react-mdl";
import NavigationComponent from "./Navigation/NavigationComponent";
import SimpleSelect from "./SimpleSelect/simple-select";
import DatePicker from "./DatePicker/date-picker";
import AddPassenger from "./AddPassenger/add-passenger";
import Notification from "./SnackBar/notification";
import { FLIGHTS_ROUTE } from "./Menu/Menu";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      departureId: "",
      destinationId: "",
      departureDate: new Date()
    };

    this.onSearchFieldChange = this.onSearchFieldChange.bind(this);
    this.onSearch = this.onSearch.bind(this);
    this.onAddPassenger = this.onAddPassenger.bind(this);
    this.handleCloseNotification = this.handleCloseNotification.bind(this);
    this.showReservationInfo = this.showReservationInfo.bind(this);
    this.onSearchByName = this.onSearchByName.bind(this);
  }

  showReservationInfo() {

  }

  handleCloseNotification() {
    this.props._hideNotification();
  }

  onAddPassenger(data) {
    this.props._onAddPassenger(data);
  }

  onSearchFieldChange(field, value) {
    this.setState({
      [field]: value
    });
  }

  onSearchByName(val) {
    this.props._getProducts(val);
  }

  onSearch() {
    this.props._serachFlights(this.state);
  }

  componentWillMount = () => {
    this.props._getAirports();
  };

  render() {
    const selectedMenuList = this.props.ui.menu.filter(
      menuItem => menuItem.selected
    );
    const selectedMenu = selectedMenuList[0];

    return (
      <div className="App">
        <Layout>
          <Header
            title={selectedMenu.name}
            isLoggedIn={this.props.ui.isLoggedIn}
            orderCount={this.props.ui.shoppingCart.length}
            handleSearch={this.onSearchByName}
          />
          <NavigationComponent
            menu={this.props.ui.menu}
            menuClickHandler={this.props._menuClickHandler}
          />

          <Content>
            {selectedMenu.route === FLIGHTS_ROUTE ? (
              <Cell
                md={12}
                style={{ display: "flex", justifyItems: "flex-start" }}
              >
                <SimpleSelect
                  fieldName="departureId"
                  onChange={this.onSearchFieldChange}
                  name="Departure"
                  airports={this.props.airports}
                />
                <SimpleSelect
                  fieldName="destinationId"
                  onChange={this.onSearchFieldChange}
                  name="Destination"
                  airports={this.props.airports}
                />
                <DatePicker onChange={this.onSearchFieldChange} />
                <Button raised colored size="sm" onClick={this.onSearch}>
                  Search flight
                </Button>
              </Cell>
            ) : null}

            <ContentContainer
              onAddPassenger={this.onAddPassenger}
              loading={this.props.ui.pending}
              selectedMenu={selectedMenu}
              products={this.props.products}
              reservations={this.props.reservations}
              showReservationInfo={this.showReservationInfo}
            />
          </Content>
          <Notification
            open={this.props.ui.showNotification}
            message={this.props.message}
            handleCloseNotification={this.handleCloseNotification}
            type={this.props.ui.notificationType}
          />
        </Layout>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    ui: state.ui,
    products: state.products,
    id: state.id,
    airports: state.airports,
    reservations: state.reservations
  };
};

const mapDispatchToProps = dispatch => ({
  _handleSearch: val => dispatch(createSearchAction(val)),
  _getProducts: (val) => dispatch(getProducts(val)),
  _menuClickHandler: route => dispatch(menuClicked(route)),
  _getAirports: () => dispatch(getAirports()),
  _serachFlights: data => dispatch(searchFlights(data)),
  _onAddPassenger: data => dispatch(addPassenger(data)),
  _hideNotification: () => dispatch(hideNotification())
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(App);
