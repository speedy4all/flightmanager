
export const GET_AIRPORTS = "[airports] GET";
export const UPDATE_AIRPORTS = "[airports] Update";
export const FETCH_AIRPORTS_SUCCESS = "[airports] Success";
export const FETCH_AIRPORTS_ERROR = "[airports] Error";

export const getAirports = () => ({
  type: GET_AIRPORTS
});
export const updateAirports = (data) => ({
  type: UPDATE_AIRPORTS,
  payload: data
});
