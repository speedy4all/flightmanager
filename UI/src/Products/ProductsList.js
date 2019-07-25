import React from "react";
import { PropTypes } from "prop-types";
import Product from "./Product";
import { Grid, Cell, Button } from "react-mdl";

const ProductsList = props => {
  const products = props.products.map(product => (
    <Cell col={11} key={product.flightId}>
      <Product
        {...product}
        offers={props.offersRoute}
        reservations={props.reservations}
        editMode={props.editMode}
        onAddPassenger={props.onAddPassenger}
      />
    </Cell>
  ));
  return (
    <React.Fragment>
      {props.reservations ? (
        <Button raised colored size="sm" onClick={props.handleShowReservationInfo}>
          Passenger info
        </Button>
      ) : null}
      <div style={{ width: "100%", margin: "auto" }}>
        <Grid>{products}</Grid>
      </div>
    </React.Fragment>
  );
};

ProductsList.propTypes = {
  products: PropTypes.arrayOf(
    PropTypes.shape({
      flightId: PropTypes.string.isRequired,
      name: PropTypes.string,
      fullFlightDescription: PropTypes.string,
      departureDate: PropTypes.string,
      destinationDate: PropTypes.string
    })
  )
};

export default ProductsList;
