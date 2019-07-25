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
  ListItemAction
} from "react-mdl";
import AddPassenger from "../AddPassenger/add-passenger";

class Product extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {
      isOpen: false,
    };

    this.onComplete = this.onComplete.bind(this);
    this.handleClose = this.handleClose.bind(this);
  }
  
  handleClose() {
    this.setState({isOpen: false});
  }

  onComplete(data) {
    this.setState({isOpen: false});
    this.props.onAddPassenger(data);
  }

  render() {
    const { id, name, departureDate } = this.props;
    return (
      <List>
        <AddPassenger 
        onComplete={this.onComplete} 
        open={this.state.isOpen} 
        name="" 
        identifier="" 
        flightId={id} 
        handleClose={this.handleClose}
        />
        <ListItem twoLine>
          <ListItemContent
            avatar="flight"
            subtitle={new Date(departureDate).toDateString()}
          >
            {name}
          </ListItemContent>
          <Button raised colored size="sm" onClick={() => this.setState({isOpen: true})} >
            Select flight
          </Button>
        </ListItem>
      </List>
    );
  }
}

Product.propTypes = {
  id: PropTypes.string.isRequired,
  name: PropTypes.string,
  fullFlightDescription: PropTypes.string,
  departureDate: PropTypes.string,
  destinationDate: PropTypes.string
};

export default Product;
