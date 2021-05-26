import { v4 as uuidv4 } from "uuid";

export default function reducer(state, action) {
  switch (action.type) {
    case "GET_TODOS":
      
      console.log('Payload i : ', action.payload);

      return {
        ...state,
        todos: action.payload,
      };

    case "UPDATE_TODO":
      if (!action.payload) {
        return state;
      }
      if (state.todos.findIndex((t) => t.text === action.payload) > -1) {
        return state;
      }
      const updatedTodo = { ...state.currentTodo, text: action.payload };
      const index = state.todos.findIndex((t) => t.id === state.currentTodo.id);
      const updatedTodos = [
        ...state.todos.slice(0, index),
        updatedTodo,
        ...state.todos.slice(index + 1),
      ];
      return {
        ...state,
        currentTodo: {},
        todos: updatedTodos,
      };
    case "SET_CURRENT_TODO":
      return {
        ...state,
        currentTodo: action.payload,
      };
    case "ADD_TODO":
      /* goes before doing the post request
      if (!action.payload) {
        return state;
      }
      if (state.todos.findIndex((t) => t.text === action.payload) > -1) {
        return state;
      }
      */
      /*
      const newTodo = {
        id: uuidv4(),
        text: action.payload,
        complete: false,
      };
      */
      const addedTodos = [...state.todos, action.payload];
      return {
        ...state,
        todos: addedTodos,
      };
    case "REMOVE_TODO":
      const filteredTodos = state.todos.filter(
        (t) => t.id !== action.payload.id
      );
      const isRemovedTodo =
        state.currentTodo.id === action.payload.id ? {} : state.currentTodo;
      return {
        ...state,
        todos: filteredTodos,
        currentTodo: isRemovedTodo,
      };
    case "TOGGLE_TODO":
      const toggledTodos = state.todos.map((t) =>
        t.id === action.payload.id ? action.payload : t
        /*? { ...action.payload, complete: !action.payload.complete }*/
      );
      return {
        ...state,
        todos: toggledTodos,
      };
    default:
      return state;
  }
}
