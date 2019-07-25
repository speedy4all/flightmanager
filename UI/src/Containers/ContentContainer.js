import React from "react";
import {
  FLIGHTS_ROUTE,
  RESERVATIONS_ROUTE,
  OFFERS_ROUTE
} from "./../Menu/Menu";
import ProductsList from "./../Products/ProductsList";
import { Spinner } from "react-mdl";

const getContent = props => {
  if (props.loading) {
    return <Spinner />;
  }
  if (props.selectedMenu && props.selectedMenu.route === FLIGHTS_ROUTE) {
    return (
      <ProductsList
        products={props.products}
        onAddToCart={props.onAddToCart}
        onAddPassenger={props.onAddPassenger}
      />
    );
  }
  if (props.selectedMenu && props.selectedMenu.route === RESERVATIONS_ROUTE) {
    return (
      <ProductsList
        editMode
        handleShowReservationInfo={props.handleShowReservationInfo}
        reservations
        products={props.reservations}
        onAddToCart={props.onAddToCart}
        onDeleteProduct={props.deleteInProgress}
        onAddPassenger={props.onAddPassenger}
      />
    );
  }
  if (props.selectedMenu && props.selectedMenu.route === OFFERS_ROUTE) {
    return (
      <ProductsList
        offersRoute
        products={props.offers}
      />
    );
  }
  return null;
};

const ContentContainer = props => {
  return <div>{getContent(props)}</div>;
};

export default ContentContainer;
