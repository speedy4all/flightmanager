import { FETCH_OFFERS_SUCCESS, FETCH_OFFERS_ERROR, updateOffers, GET_OFFERS } from "../Actions/offers";
import {
  showSpinner,
  hideSpinner,
} from "../Actions/ui";
import { apiRequest } from "../Actions/api";
import { OFFERS_ROUTE } from "../../Menu/Menu";

// this middleware only care about the getProducts action
export const getOffersFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === OFFERS_ROUTE || action.type === GET_OFFERS) {
    dispatch(
      apiRequest(
        "GET",
        `/flight/offers`,
        null,
        FETCH_OFFERS_SUCCESS,
        FETCH_OFFERS_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

// on successful fetch, process the products data
export const processOffersCollection = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_OFFERS_SUCCESS) {
    dispatch(updateOffers(action.payload.list));
    dispatch(hideSpinner());
  }
};

export const processOffersCollectionError = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_OFFERS_ERROR) {
    dispatch(hideSpinner());
  }
};

export const offersMdl = [
  getOffersFlow,
  processOffersCollection,
  processOffersCollectionError,
];
