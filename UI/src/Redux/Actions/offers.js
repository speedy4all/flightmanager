
export const GET_OFFERS = "[offers] GET";
export const UPDATE_OFFERS = "[offers] Update";
export const FETCH_OFFERS_SUCCESS = "[offers] Success";
export const FETCH_OFFERS_ERROR = "[offers] Error";

export const getOffers = () => ({
  type: GET_OFFERS,
});
export const updateOffers = (data) => ({
  type: UPDATE_OFFERS,
  payload: data
});
