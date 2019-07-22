import React from "react";
import { Drawer, Navigation } from "react-mdl";

const NavigationComponent = props => {
  return (
    <Drawer>
      <Navigation>
        {props.menu.map((item, index) => {
          return (
            <span
              key={index}
              style={{ cursor: "pointer" }}
              onClick={() => props.menuClickHandler(item.route)}
            >
              {item.name}
            </span>
          );
        })}
      </Navigation>
    </Drawer>
  );
};

export default NavigationComponent;
