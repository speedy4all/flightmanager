import React, { Component } from "react";
import "./App.css";
import Header from "./Header/Header";
import { getProducts } from "./Redux/Actions/products";
import { getAirports } from "./Redux/Actions/airports";
import { connect } from "react-redux";
import ContentContainer from "./Containers/ContentContainer";
import { menuClicked, createSearchAction } from "./Redux/Actions/ui";
import { Layout, Content } from "react-mdl";
import NavigationComponent from "./Navigation/NavigationComponent";
import SimpleSelect from "./SimpleSelect/simple-select";

class App extends Component {
  componentWillMount = () => {
    this.props._getProducts();
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
          />
          <NavigationComponent
            menu={this.props.ui.menu}
            menuClickHandler={this.props._menuClickHandler}
          />

          <Content>
            <SimpleSelect airports={this.props.airports}/>
            <ContentContainer
              loading={this.props.ui.pending}
              selectedMenu={selectedMenu}
              products={this.props.products}
            />
          </Content>
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
    airports: state.airports
  };
};

const mapDispatchToProps = dispatch => ({
  _handleSearch: val => dispatch(createSearchAction(val)),
  _getProducts: () => dispatch(getProducts()),
  _menuClickHandler: route => dispatch(menuClicked(route)),
  _getAirports: () => dispatch(getAirports()),
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(App);
