import {
  GET_AIRPORTS,
  FETCH_AIRPORTS_SUCCESS,
  FETCH_AIRPORTS_ERROR,
  updateAirports
} from "../Actions/airports";
import {
  showSpinner,
  hideSpinner,
  hideDeleteDialog
} from "../Actions/ui";
import { apiRequest } from "../Actions/api";

// this middleware only care about the getProducts action
export const getAirportsFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === GET_AIRPORTS) {
    dispatch(
      apiRequest(
        "GET",
        `/airport/simple-list`,
        null,
        FETCH_AIRPORTS_SUCCESS,
        FETCH_AIRPORTS_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

// on successful fetch, process the products data
export const processAirportsCollection = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_AIRPORTS_SUCCESS) {
    dispatch(updateAirports(action.payload));
    dispatch(hideSpinner());
  }
};

export const airportsMdl = [
  getAirportsFlow,
  processAirportsCollection,
];
