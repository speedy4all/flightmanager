import { combineReducers } from "redux";
import { uiReducer } from "./ui";
import { productsReducer } from "./products";
import { airportsReducer } from "./airports";

export const reducers = combineReducers({
  ui: uiReducer,
  products: productsReducer,
  airports: airportsReducer
});
