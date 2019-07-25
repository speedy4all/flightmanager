import { UPDATE_OFFERS } from "../Actions/offers";

export function offersReducer(offers = [], action) {
  switch (action.type) {
    case UPDATE_OFFERS:
      return action.payload;

    default:
      return offers;
  }
}
