import React, { useState , useContext , useEffect } from "react";
import TodosContext from '../context'

export default function TodoForm() {

  const [todo, setTodo] = useState("")

  const { state: { currentTodo = {} }, dispatch } = useContext(TodosContext);

  useEffect(() => {
    if (currentTodo.text) {
      setTodo(currentTodo.text);
    }
  }, [currentTodo.id])

  const handleSubmit = (event) => {

    event.preventDefault(); 

    if (currentTodo.text) {
      dispatch({
        type:"UPDATE_TODO",
        payload: todo
      })
    
    } else {
      dispatch({type:"ADD_TODO", payload:todo});
    
    }
    setTodo("")
  };

  return (
    <div className="container-form mt-3">
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
