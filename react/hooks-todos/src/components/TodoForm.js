import React, { useState , useContext } from "react";
import TodosContext from '../context'

export default function TodoForm() {

  const [todo, setTodo] = useState("")

  const { state, dispatch } = useContext(TodosContext);

  const handleSubmit = (event) => {
    event.preventDefault(); 
    dispatch({type:"ADD_TODO", payload:todo});
    setTodo("")
  };

  return (
    <div className="container-form mt-1">
      <form 
        onSubmit={handleSubmit}
        className="">
        <input type="text" 
          className="border border-primary border-5 rounded"
          onChange={event => setTodo(event.target.value)}  
          value={todo}
        />
      </form>
    </div>
  );
}
