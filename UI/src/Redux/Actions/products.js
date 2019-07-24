export const GET_PRODUCTS = "[products] GET";
export const FETCH_PRODUCTS_SUCCESS = "[products] Fetch success";
export const FETCH_PRODUCTS_ERROR = "[products] Fetch Error";
export const UPDATE_PRODUCTS = "[products] Update";
export const SELECT_PRODUCT = "[products] Select";
export const DELETE_PRODUCT = "[products] Delete";
export const SEARCH_FLIGHTS = "[flights] Search";
export const ADD_PASSENGER = "[flights] Add passenger";
export const ADD_PASSENGER_SUCCESS = "[flights] Add passenger success";
export const ADD_PASSENGER_ERROR = "[flights] Add passenger error";

export const getProducts = (val) => ({
  type: GET_PRODUCTS,
  payload: val,
});

export const updateProducts = data => ({
  type: UPDATE_PRODUCTS,
  payload: data
});

export const selectProduct = productId => ({
  type: SELECT_PRODUCT,
  payload: productId
});

export const deleteProduct = productId => ({
  type: DELETE_PRODUCT,
  payload: productId
});

export const searchFlights = data => ({
  type: SEARCH_FLIGHTS,
  payload: data
});

export const addPassenger = data => ({
  type: ADD_PASSENGER,
  payload: data
});

export const setPassengerAddError = data => ({
  type: ADD_PASSENGER_ERROR,
  payload: data
});
