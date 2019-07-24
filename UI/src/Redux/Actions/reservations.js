
export const GET_RESERVATIONS = "[reservations] GET";
export const UPDATE_RESERVATIONS = "[reservations] Update";
export const FETCH_RESERVATIONS_SUCCESS = "[reservations] Success";
export const FETCH_RESERVATIONS_ERROR = "[reservations] Error";

export const getReservations = (passengerIdentification) => ({
  type: GET_RESERVATIONS,
  payload: passengerIdentification,
});
export const updateReservations = (data) => ({
  type: UPDATE_RESERVATIONS,
  payload: data
});
