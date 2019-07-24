import { UPDATE_RESERVATIONS } from "../Actions/reservations";

export function reservationsReducer(reservations = [], action) {
  switch (action.type) {
    case UPDATE_RESERVATIONS:
      return action.payload;

    default:
      return reservations;
  }
}
