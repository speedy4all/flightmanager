import React from "react";
import "./UserInfo.css";
import { Button } from "react-mdl";

export default props => {
  const headerContainerClass = `FloatRight CenterHeader visible ${
    props.isLoggedIn ? "" : "hidden"
  }`;
  return (
    <div className={headerContainerClass}>
      <span className="UserContainer" href="/logout" style={{ color: "white" }}>
        User name
      </span>
      <Button
        raised
        ripple
        accent
        onClick={props.buttonHandler}
        style={{ marginLeft: "10px" }}
      >
        Logout
      </Button>
    </div>
  );
};
