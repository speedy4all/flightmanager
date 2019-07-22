import { combineReducers } from "redux";
import { uiReducer } from "./ui";
import { productsReducer } from "./products";

export const reducers = combineReducers({
  ui: uiReducer,
  products: productsReducer
});
