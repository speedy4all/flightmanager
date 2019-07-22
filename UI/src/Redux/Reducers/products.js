import { UPDATE_PRODUCTS } from "../Actions/products";

export function productsReducer(products = [], action) {
  switch (action.type) {
    case UPDATE_PRODUCTS:
      return action.payload;

    default:
      return products;
  }
}
