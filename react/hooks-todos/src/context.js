import React from "react";

const TodosContext = React.createContext({
  currentTodo:{},
  todos: [
  /*
    {
      id: 1,
      text: "Eat breakfast",
      complete: false,
    },
    {
      id: 2,
      text: "Do laundry",
      complete: false,
    },
    {
      id: 3,
      text: "Finish proyect",
      complete: true,
    },
  */
  ]
});

export default TodosContext;