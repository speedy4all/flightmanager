import React from "react";
import "./MenuItem.css";
import PropTypes from "prop-types";

const MenuItem = props => {
  return (
    <li
      className={props.selected ? "MenuItem selected" : "MenuItem"}
      onClick={() => props.clickHandler(props.index)}
    >
      <span className="MenuItemText">{props.name}</span>
    </li>
  );
};

MenuItem.propTypes = {
  selected: PropTypes.bool.isRequired,
  index: PropTypes.number.isRequired,
  name: PropTypes.string,
  clickHandler: PropTypes.func.isRequired
};

export default MenuItem;
