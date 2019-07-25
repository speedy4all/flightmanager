import { applyMiddleware, createStore, compose } from "redux";
import { reducers } from "./Reducers/index";
import { productsMdl } from "./Middleware/products";
import { api } from "./Middleware/api";
import { uiMdl } from "./Middleware/ui";
import { airportsMdl } from "./Middleware/airports";
import { reservationsMdl } from "./Middleware/reservations";
import { offersMdl } from "./Middleware/offers";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export const store = createStore(
  reducers,
  composeEnhancers(
    applyMiddleware(
      ...productsMdl,
      ...uiMdl,
      ...airportsMdl,
      ...reservationsMdl,
      ...offersMdl,
      api
    )
  )
);
