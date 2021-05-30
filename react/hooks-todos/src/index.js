import React, { useContext, useEffect, useReducer, useState } from "react";
import ReactDOM from "react-dom";
import "./index.css";
import reportWebVitals from "./reportWebVitals";

import TodosContext from "./context";
import todosReducer from "./reducer";

import TodoList from "./components/TodoList";
import TodoForm from "./components/TodoForm";
import axios from "axios";

/*
Custom react hook doesn't work
const useApi = (endpoint) => {
  const [data, setData] = useState([]);

  const getData = async () => {
    const response = await axios.get(endpoint);
    setData(response.data);
  };

  useEffect(() => {
    getData();
  }, []);

  return data;
};
*/

const App = () => {
  const initialState = useContext(TodosContext);
  const [state, dispatch] = useReducer(todosReducer, initialState);

  useEffect(() => {
    const endpoint = 'http://localhost:9000/todos'
    axios.get(endpoint).then((response) => {
      dispatch({
        type: "GET_TODOS",
        payload: response.data,
      });
    }, (error) => {

    });
  }, []);

  return (
    <TodosContext.Provider value={{ state, dispatch }}>
      <div class="container-fluid mx-auto text-center w-50">
        <TodoForm />
        <TodoList />
      </div>
    </TodosContext.Provider>
  );
};

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
