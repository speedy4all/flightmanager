export const SHOW_SPINNER = "[ui] show spinner";
export const HIDE_SPINNER = "[ui] hide spinner";
export const MENU_CHANGED = "[ui] menu changed";
export const NEW_MENU_ACTIVE = "[ui] new menu active";
export const SEARCH_TRIGGERED = "[ui] search event";
export const SHOW_ORDER_DIALOG = "[ui] show order dialog";
export const HIDE_DIALOG = "[ui] hide dialog";
export const SHOW_DIALOG = "[ui] show dialog";
export const SET_CURRENT_PRODUCT = "[ui] set current product";
export const CONFIRM_ADD_TO_CART = "[ui] confirm add to cart";
export const UPDATE_CART = "[ui] update cart";
export const UPDATE_PRODUCT_QUANTITY = "[ui] update product quantity";
export const SHOW_DELETE_DIALOG = "[ui] show delete dialog";
export const HIDE_DELETE_DIALOG = "[ui] hide delete dialog";

export const showSpinner = () => ({
  type: SHOW_SPINNER
});

export const hideSpinner = () => ({
  type: HIDE_SPINNER
});

export const menuClicked = route => ({
  type: MENU_CHANGED,
  payload: route
});

export const newMenuActive = data => ({
  type: NEW_MENU_ACTIVE,
  payload: data
});

export const createSearchAction = searchParam => ({
  type: SEARCH_TRIGGERED,
  payload: searchParam
});

export const showOrderDialog = id => ({
  type: SHOW_ORDER_DIALOG,
  payload: id
});

export const showDialog = () => ({
  type: SHOW_DIALOG
});

export const hideDialog = () => ({
  type: HIDE_DIALOG
});

export const setCurrentProduct = product => ({
  type: SET_CURRENT_PRODUCT,
  payload: product
});

export const confirmAddToCart = () => ({
  type: CONFIRM_ADD_TO_CART
});

export const updateCart = shoppingCart => ({
  type: UPDATE_CART,
  payload: shoppingCart
});

export const updateProductQuantity = quantity => ({
  type: UPDATE_PRODUCT_QUANTITY,
  payload: quantity
});

export const showDeleteDialog = () => ({
  type: SHOW_DELETE_DIALOG
});

export const hideDeleteDialog = () => ({
  type: HIDE_DELETE_DIALOG
});
