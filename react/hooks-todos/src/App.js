import "./App.css";

import React, { useContext } from "react";
import { UserContext } from "./index";

export default function App(props) {
  const value = useContext(UserContext);
  return (
    <div className="container-fluid">
      <h1 className="mt-1">
        <h1>Hello {value}</h1>
      </h1>
    </div>
  );
}
