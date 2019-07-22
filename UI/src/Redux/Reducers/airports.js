import { UPDATE_AIRPORTS } from "../Actions/airports";

export function airportsReducer(airports = [], action) {
  switch (action.type) {
    case UPDATE_AIRPORTS:
      return action.payload;

    default:
      return airports;
  }
}
