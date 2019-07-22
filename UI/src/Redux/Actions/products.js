export const GET_PRODUCTS = "[products] GET";
export const FETCH_PRODUCTS_SUCCESS = "[products] Fetch success";
export const FETCH_PRODUCTS_ERROR = "[products] Fetch Error";
export const UPDATE_PRODUCTS = "[products] Update";
export const SELECT_PRODUCT = "[products] Select";
export const DELETE_PRODUCT = "[products] Delete";

export const getProducts = () => ({
  type: GET_PRODUCTS
});

export const updateProducts = data => ({
  type: UPDATE_PRODUCTS,
  payload: data
});

export const selectProduct = productId => ({
  type: SELECT_PRODUCT,
  payload: productId
});

export const deleteProduct = productId => ({
  type: DELETE_PRODUCT,
  payload: productId
});
