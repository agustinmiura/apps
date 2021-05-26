import "./App.css";

import React, { useContext, useReducer, userReducer } from "react";
import { UserContext } from "./index";

const intialState = { count : 0 };

function reducer(state, action) {
  switch(action.type) {
    case "increment":{
      return {
        count:state.count + 1
      }
    }
    case "decrement":{
      return {
        count:state.count -1
      }
    }
    case "reset": {
      return intialState;
    }
    default:
      return intialState
  }
}

export default function App(props) {
  
  const [state, dispatch] = useReducer(reducer, intialState);
  const value = useContext(UserContext);
  
  /*
  return (
    <div className="container-fluid">
      <h1 className="mt-1">
        <h1>Hello {value}</h1>
      </h1>
    </div>
  );*/

  return (<div>
    Count : {state.count}
    <button 
      className="btn btn-success p-1 m-1" 
      onClick={() => dispatch({type:"increment"})}
    >Increment</button>
    <button 
      className="btn btn-success p-1 m-1" 
      onClick={() => dispatch({type:"decrement"})}
    >Decrement</button>
    <button 
      className="btn btn-success p-1" 
      onClick={() => dispatch({type:"reset"})}
    >Reset</button>
  </div>)

}
