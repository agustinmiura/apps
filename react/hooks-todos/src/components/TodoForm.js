import React, { useState, useContext, useEffect } from "react";
import TodosContext from "../context";
import axios from "axios";
import { v4 as uuidv4 } from "uuid";

export default function TodoForm() {
  const [todo, setTodo] = useState("");

  const {
    state: { currentTodo = {} },
    dispatch,
  } = useContext(TodosContext);

  useEffect(() => {
    if (currentTodo.text) {
      setTodo(currentTodo.text);
    } else {
      setTodo("");
    }
  }, [currentTodo.id]);

  const handleSubmit = async event => {
    event.preventDefault();

    if (currentTodo.text) {
      dispatch({
        type: "UPDATE_TODO",
        payload: todo,
      });
    } else {

      const response = await axios.post('http://localhost:9000/todos', {
        id:uuidv4(),
        text: todo,
        complete:false
      })
      dispatch({ type: "ADD_TODO", payload: response.data });

    }
    setTodo("");
  };

  return (
    <div className="container-form mt-3">
      <form onSubmit={handleSubmit} className="">
        <input
          type="text"
          className="border border-primary border-5 rounded"
          onChange={(event) => setTodo(event.target.value)}
          value={todo}
        />
      </form>
    </div>
  );
}
