import React from "react";
import { FLIGHTS_ROUTE, RESERVATIONS_ROUTE } from "./../Menu/Menu";
import ProductsList from "./../Products/ProductsList";
import { Spinner } from "react-mdl";

const ContentContainer = props => {
  return (
    <div>
      
      {props.loading ? (
        <Spinner />
      ) : props.selectedMenu && props.selectedMenu.route === FLIGHTS_ROUTE ? (
        <ProductsList
          products={props.products}
          onAddToCart={props.onAddToCart}
          onAddPassenger={props.onAddPassenger}
        />
      ) : props.selectedMenu &&
        props.selectedMenu.route === RESERVATIONS_ROUTE ? (
        <ProductsList
          editMode
          showReservationInfo={props.showReservationInfo}
          reservations
          products={props.reservations}
          onAddToCart={props.onAddToCart}
          onDeleteProduct={props.deleteInProgress}
        />
      ) : null}
    </div>
  );
};

export default ContentContainer;
