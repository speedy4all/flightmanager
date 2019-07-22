import React from "react";
import PropTypes from "prop-types";
import {
  Card,
  CardTitle,
  CardText,
  CardActions,
  Button,
  List,
  ListItem,
  ListItemContent,
  ListItemAction,
} from "react-mdl";

const Product = props => {
  const { id, name, departureDate } = props;
  return (
    <List>
      <ListItem twoLine>
        <ListItemContent avatar="flight" subtitle={new Date(departureDate).toDateString()}>{name}</ListItemContent>
          <Button raised colored  size="sm">Select flight</Button>
      </ListItem>
    </List>
  );
};

Product.propTypes = {
  id: PropTypes.number.isRequired,
  name: PropTypes.string,
  fullFlightDescription: PropTypes.string,
  departureDate: PropTypes.string,
  destinationDate: PropTypes.string
};

export default Product;
