import {
  SHOW_SPINNER,
  HIDE_SPINNER,
  NEW_MENU_ACTIVE,
  SHOW_DIALOG,
  HIDE_DIALOG,
  UPDATE_CART,
  SET_CURRENT_PRODUCT,
  UPDATE_PRODUCT_QUANTITY,
  HIDE_DELETE_DIALOG,
  SHOW_DELETE_DIALOG,
  SHOW_NOTIFICATION,
  HIDE_NOTIFICATION,
  SHOW_RESERVATION_WINDOW,
  HIDE_RESERVATION_WINDOW
} from "../Actions/ui";
import {
  FLIGHTS_ROUTE,
  OFFERS_ROUTE,
  RESERVATIONS_ROUTE
} from "./../../Menu/Menu";

const initUi = {
  pending: false,
  orderInProgress: false,
  deleteInProgress: false,
  currentProduct: { quantity: "" },
  isLoggedIn: true,
  shoppingCart: [],
  showNotification: false,
  showReservationWindow: false,
  notificationType: "success",
  message: '',
  menu: [
    {
      name: "Flights",
      selected: true,
      route: FLIGHTS_ROUTE
    },
    {
      name: "Offers",
      selected: false,
      route: OFFERS_ROUTE
    },
    {
      name: "Reservations",
      selected: false,
      route: RESERVATIONS_ROUTE
    }
  ]
};

export function uiReducer(state = initUi, action) {
  switch (action.type) {
    case SHOW_SPINNER:
      return { ...state, pending: true };
    case SHOW_RESERVATION_WINDOW:
      return { ...state, showReservationWindow: true };

    case HIDE_RESERVATION_WINDOW:
      return { ...state, showReservationWindow: false };

    case SHOW_NOTIFICATION:
      return {
        ...state,
        showNotification: true,
        message: action.payload,
        notificationType: action.meta
      };

    case HIDE_NOTIFICATION:
      return { ...state, showNotification: false };

    case HIDE_SPINNER:
      return { ...state, pending: false };

    case NEW_MENU_ACTIVE:
      return { ...state, menu: [...action.payload] };

    case SHOW_DIALOG:
      return { ...state, orderInProgress: true };

    case HIDE_DIALOG:
      return { ...state, orderInProgress: false };

    case SET_CURRENT_PRODUCT:
      return { ...state, currentProduct: action.payload };

    case UPDATE_CART:
      return { ...state, shoppingCart: [...action.payload] };

    case UPDATE_PRODUCT_QUANTITY:
      return {
        ...state,
        currentProduct: { ...state.currentProduct, quantity: action.payload }
      };

    case SHOW_DELETE_DIALOG:
      return { ...state, deleteInProgress: true };

    case HIDE_DELETE_DIALOG:
      return { ...state, deleteInProgress: false };
    default:
      return state;
  }
}
