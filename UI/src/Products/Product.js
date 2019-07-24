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
      isOpen: false
    };

    this.onComplete = this.onComplete.bind(this);
    this.handleClose = this.handleClose.bind(this);
  }

  handleClose() {
    this.setState({ isOpen: false });
  }

  onComplete(data) {
    this.setState({ isOpen: false });
    this.props.onAddPassenger(data);
  }

  render() {
    const {
      flightId,
      availableSeats,
      departureDate,
      destinationAirportName,
      planeType,
      flightDuration,
      destinationDate,
      departureAirportName
    } = this.props;
    return (
      <List>
        <AddPassenger
          onComplete={this.onComplete}
          open={this.state.isOpen}
          name=""
          identifier=""
          flightId={flightId}
          handleClose={this.handleClose}
        />
        <ListItem twoLine style={{ height: 150 }}>
          <ListItemContent
            avatar="flight"
            subtitle={
              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  flexDirection: "column"
                }}
              >
                <div>
                  <span>Flight duration: {flightDuration}</span>
                </div>
                <div>
                  <span>Plane type: {planeType}</span>
                </div>
                <div>
                  <span>Available seats: {availableSeats}</span>
                </div>
              </div>
            }
          >
            <div style={{ float: "right", marginRight: 10 }}>
              <div style={{ float: "left" }}>
                <b>Destination: {destinationAirportName}</b>
              </div>
              <div>
                <span style={{ float: "left" }}>
                  Destination date: {new Date(destinationDate).toDateString()}
                </span>
              </div>
            </div>

            <div style={{ float: "left" }}>
              <div>
                <span style={{ float: "left" }}>
                  Flight name: {departureAirportName} - {destinationAirportName}
                </span>
              </div>
              <div>
                <span style={{ width: "100%", display: "flex" }}>
                  <span style={{ float: "left" }}>
                    Departure date: {new Date(departureDate).toDateString()}
                  </span>
                </span>
              </div>
              <div>
                <span style={{ float: "left" }}>
                  Departure : {departureAirportName}
                </span>
              </div>
            </div>
          </ListItemContent>
          <Button
            raised
            colored
            size="sm"
            onClick={() => this.setState({ isOpen: true })}
          >
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
