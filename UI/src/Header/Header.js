import React from "react";
import UserInfo from "../UserPrefs/UserInfo";
import "./Header.css";
import { Header, Textfield, Badge, Icon } from "react-mdl";
import { debounce } from "lodash";
import { RESERVATIONS_ROUTE } from "./../Menu/Menu";

const CustomHeader = props => {
  const originalHandler = props.handleSearch;

  const debounceAction = debounce(e => {
    originalHandler(e.target.value);
  }, 400);

  const changeHandler = e => {
    e.persist();
    debounceAction(e);
  };
  return (
    <Header title={props.title}>
      <Textfield
        onChange={changeHandler}
        label="Search"
        expandable
        expandableIcon="search"
        placeholder="Product name ..."
      />
      <Badge
        text={props.orderCount}
        overlap
        style={{ marginLeft: "10px", cursor: "pointer" }}
        onClick={() => props.shoppingCartAction(RESERVATIONS_ROUTE)}
      >
        <Icon name="shopping_cart" />
      </Badge>
      <UserInfo
        isLoggedIn={props.isLoggedIn}
        buttonHandler={props.buttonHandler}
      />
    </Header>
  );
};

export default CustomHeader;
