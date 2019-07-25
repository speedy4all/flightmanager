import {
  FETCH_RESERVATIONS_SUCCESS,
  FETCH_RESERVATIONS_ERROR,
  updateReservations,
  GET_RESERVATIONS
} from "../Actions/reservations";
import {
  showSpinner,
  hideSpinner,
  hideReservationWindow,
} from "../Actions/ui";
import { apiRequest } from "../Actions/api";

// this middleware only care about the getProducts action
export const getReservationsFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === GET_RESERVATIONS) {
    dispatch(
      apiRequest(
        "GET",
        `/flight/${action.payload}/my-flights`,
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
    dispatch(updateReservations(action.payload.list));
    dispatch(hideReservationWindow());
    dispatch(hideSpinner());
  }
};

export const processReservationsCollectionError = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_RESERVATIONS_ERROR) {
    dispatch(hideReservationWindow());
    dispatch(hideSpinner());
  }
};

export const reservationsMdl = [
  getReservationsFlow,
  processReservationsCollection,
  processReservationsCollectionError,
];
