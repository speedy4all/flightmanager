import {
  FETCH_RESERVATIONS_SUCCESS,
  FETCH_RESERVATIONS_ERROR,
  updateReservations,
  GET_RESERVATIONS
} from "../Actions/reservations";
import {
  showSpinner,
  hideSpinner,
  hideDeleteDialog
} from "../Actions/ui";
import { apiRequest } from "../Actions/api";
import { RESERVATIONS_ROUTE } from "../../Menu/Menu";

// this middleware only care about the getProducts action
export const getReservationsFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === GET_RESERVATIONS) {
    dispatch(
      apiRequest(
        "GET",
        `/flight/reservations?passengerIdentifier=${action.payload}`,
        null,
        FETCH_RESERVATIONS_SUCCESS,
        FETCH_RESERVATIONS_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

// on successful fetch, process the products data
export const processReservationsCollection = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_RESERVATIONS_SUCCESS) {
    dispatch(updateReservations(action.payload));
    dispatch(hideSpinner());
  }
};

export const reservationsMdl = [
  getReservationsFlow,
  processReservationsCollection,
];
