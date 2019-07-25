import { combineReducers } from "redux";
import { uiReducer } from "./ui";
import { productsReducer } from "./products";
import { airportsReducer } from "./airports";
import { reservationsReducer } from "./reservations";
import { offersReducer } from "./offers";

export const reducers = combineReducers({
  ui: uiReducer,
  products: productsReducer,
  airports: airportsReducer,
  reservations: reservationsReducer,
  offers: offersReducer,
});
