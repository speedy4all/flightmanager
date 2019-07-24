import React from "react";
import { PropTypes } from "prop-types";
import Product from "./Product";
import { Grid, Cell, Button } from "react-mdl";

const ProductsList = props => {
  const products = props.products.map(product => (
    <Cell col={11} key={product.id}>
      <Product
        {...product}
        editMode={props.editMode}
        onAddPassenger={props.onAddPassenger}
      />
    </Cell>
  ));
  return (
    <React.Fragment>
      {props.reservations ? (
        <Button raised colored size="sm" onClick={props.showReservationInfo}>
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
      id: PropTypes.string.isRequired,
      name: PropTypes.string,
      fullFlightDescription: PropTypes.string,
      departureDate: PropTypes.string,
      destinationDate: PropTypes.string
    })
  )
};

export default ProductsList;
