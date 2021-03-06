import {
  FETCH_PRODUCTS_SUCCESS,
  FETCH_PRODUCTS_ERROR,
  GET_PRODUCTS,
  SELECT_PRODUCT,
  updateProducts,
  DELETE_PRODUCT,
  SEARCH_FLIGHTS,
  ADD_PASSENGER,
  ADD_PASSENGER_ERROR,
  ADD_PASSENGER_SUCCESS,
  REMOVE_PASSENGER,
  REMOVE_PASSENGER_SUCCESS,
  REMOVE_PASSENGER_ERROR
} from "../Actions/products";
import {
  showSpinner,
  hideSpinner,
  updateCart,
  hideDeleteDialog,
  showNotification
} from "./../Actions/ui";
import { apiRequest } from "./../Actions/api";
import { getOffers } from "../Actions/offers";
import { getReservations } from "../Actions/reservations";

export const searchFlightsFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === SEARCH_FLIGHTS) {
    const { destinationId, departureId, departureDate } = action.payload;

    dispatch(
      apiRequest(
        "GET",
        `/flight?departureId=${departureId}&destinationId=${destinationId}&departureDate=${departureDate}`,
        null,
        FETCH_PRODUCTS_SUCCESS,
        FETCH_PRODUCTS_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

// this middleware only care about the getProducts action
export const getProductsFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === GET_PRODUCTS) {
    dispatch(
      apiRequest(
        "GET",
        `/flight/search?name=${action.payload}`,
        null,
        FETCH_PRODUCTS_SUCCESS,
        FETCH_PRODUCTS_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

export const addPassengerFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === ADD_PASSENGER) {
    dispatch(
      apiRequest(
        "PUT",
        `/flight`,
        JSON.stringify({
          flightId: action.payload.flightId,
          identifier: action.payload.uniqueIdentifier
        }),
        ADD_PASSENGER_SUCCESS,
        ADD_PASSENGER_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

export const removePassengerFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === REMOVE_PASSENGER) {
    dispatch(
      apiRequest(
        "PUT",
        `/flight/cancel-reservation`,
        JSON.stringify({
          flightId: action.payload.flightId,
          identifier: action.payload.uniqueIdentifier
        }),
        REMOVE_PASSENGER_SUCCESS,
        REMOVE_PASSENGER_ERROR
      )
    );
    dispatch(showSpinner());
  }
};

export const processRemovePassengerSuccess = ({
  dispatch
}) => next => action => {
  next(action);

  if (action.type === REMOVE_PASSENGER_SUCCESS) {
    dispatch(hideSpinner());
    if(action.payload.message){
      dispatch(showNotification(`Error: ${action.payload.message}`, "error"));
    } else {
      dispatch(showNotification(`Passenger removed from flight !`, "success"));
    }
    
    dispatch(getReservations(action.payload.identifier));
  }
};

export const processRemovePassengerError = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === REMOVE_PASSENGER_ERROR) {
    dispatch(hideSpinner());
    dispatch(
      showNotification("Passenger removed from flight failed !", "error")
    );
  }
};

export const processAddPassengerSuccess = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === ADD_PASSENGER_SUCCESS) {
    dispatch(hideSpinner());
    dispatch(showNotification("Passenger added to flight !", "success"));
  }
};

export const processAddPassengerError = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === ADD_PASSENGER_ERROR) {
    dispatch(hideSpinner());
    dispatch(showNotification(action.payload.message, "error"));
  }
};

// on successful fetch, process the products data
export const processProductsCollection = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === FETCH_PRODUCTS_SUCCESS) {
    dispatch(updateProducts(action.payload.list));
    dispatch(hideSpinner());
  }
};

// notify about an order in progress, dispatch an order event
export const selectProductFlow = ({ dispatch }) => next => action => {
  next(action);

  if (action.type === SELECT_PRODUCT) {
    //   dispatch(orderInProgress());
    //   dispatch(createOrder(action.payload))
  }
};

export const deleteShoppingCartProductFlow = ({
  dispatch,
  getState
}) => next => action => {
  next(action);
  if (action.type === DELETE_PRODUCT) {
    const state = getState();
    const newShoppingCart = [...state.ui.shoppingCart];
    const productToDelete = newShoppingCart.find(p => p.id === action.payload);
    if (productToDelete) {
      newShoppingCart.splice(newShoppingCart.indexOf(productToDelete), 1);
    }
    dispatch(updateCart(newShoppingCart));
    dispatch(hideDeleteDialog());
  }
};

export const productsMdl = [
  getProductsFlow,
  processProductsCollection,
  selectProductFlow,
  deleteShoppingCartProductFlow,
  searchFlightsFlow,
  addPassengerFlow,
  processAddPassengerSuccess,
  processAddPassengerError,
  removePassengerFlow,
  processRemovePassengerSuccess,
  processRemovePassengerError
];
