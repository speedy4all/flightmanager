import React, { Component } from "react";
import "./App.css";
import Header from "./Header/Header";
import {
  getProducts,
  searchFlights,
  addPassenger,
  removePassenger
} from "./Redux/Actions/products";
import { getAirports } from "./Redux/Actions/airports";
import { connect } from "react-redux";
import ContentContainer from "./Containers/ContentContainer";
import {
  menuClicked,
  createSearchAction,
  hideNotification,
  showReservationWindow,
  hideReservationWindow
} from "./Redux/Actions/ui";
import { Layout, Content, Cell, Button } from "react-mdl";
import NavigationComponent from "./Navigation/NavigationComponent";
import SimpleSelect from "./SimpleSelect/simple-select";
import DatePicker from "./DatePicker/date-picker";
import AddPassenger from "./AddPassenger/add-passenger";
import Notification from "./SnackBar/notification";
import { FLIGHTS_ROUTE, OFFERS_ROUTE, RESERVATIONS_ROUTE } from "./Menu/Menu";
import { getReservations } from "./Redux/Actions/reservations";

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
    this.onComplete = this.onComplete.bind(this);
  }

  onComplete(data) {
    this.props._getReservations(data.uniqueIdentifier);
  }

  showReservationInfo() {
    this.props._showReservationInfo();
  }

  handleCloseNotification() {
    this.props._hideNotification();
  }

  onAddPassenger(data) {
    const selectedMenuList = this.props.ui.menu.filter(
      menuItem => menuItem.selected
    );
    const selectedMenu = selectedMenuList[0];
    if (selectedMenu.route === RESERVATIONS_ROUTE) {
      this.props._removePassenger(data);
    } else {
      this.props._onAddPassenger(data);
    }
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
              offers={this.props.offers}
              reservations={this.props.reservations}
              handleShowReservationInfo={this.showReservationInfo}
            />
          </Content>
          <AddPassenger
            onComplete={this.onComplete}
            open={this.props.ui.showReservationWindow}
            name=""
            identifier=""
            flightId=""
            handleClose={this.props._hideReservationInfo}
            reservations={this.props.reservations}
          />
          <Notification
            open={this.props.ui.showNotification}
            message={this.props.ui.message}
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
    reservations: state.reservations,
    offers: state.offers
  };
};

const mapDispatchToProps = dispatch => ({
  _handleSearch: val => dispatch(createSearchAction(val)),
  _getProducts: val => dispatch(getProducts(val)),
  _menuClickHandler: route => dispatch(menuClicked(route)),
  _getAirports: () => dispatch(getAirports()),
  _serachFlights: data => dispatch(searchFlights(data)),
  _onAddPassenger: data => dispatch(addPassenger(data)),
  _hideNotification: () => dispatch(hideNotification()),
  _showReservationInfo: () => dispatch(showReservationWindow()),
  _hideReservationInfo: () => dispatch(hideReservationWindow()),
  _getReservations: identifier => dispatch(getReservations(identifier)),
  _removePassenger: data => dispatch(removePassenger(data))
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(App);
