import axios from "axios";
import React, { useContext } from "react";
import TodosContext from "../context";

export default function TodoList() {
  const { state, dispatch } = useContext(TodosContext);

  const title =
    state.todos.length > 0 ? `${state.todos.length} Todos` : `Nothing to do!`;

  return (
    <div>
      <h1 className="font-weight-bold">{title}</h1>
      <ul className="unstyled text-white p-0">
        {state.todos.map((todo) => (
          <li
            className="bg-primary border p-4 m-2 d-flex"
            key={todo.id}
            data-toggle="tooltip"
            data-placement="top"
            title="Tooltip"
          >
            <span
              className={`flex-grow-1 ${
                todo.complete && "text-decoration-line-through text-secondary"
              }`}
              onDoubleClick={async () => {
                const response = await axios.patch(`http://localhost:9000/todos/${todo.id}`, {
                  complete: !todo.complete,
                });
                dispatch({ type: "TOGGLE_TODO", payload: response.data })
              }}
            >
              {todo.text}
            </span>

            <div className="d-grip gap-3">
              <button
                onClick={() =>
                  dispatch({ type: "SET_CURRENT_TODO", payload: todo })
                }
              >
                <div className="img-container">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-pencil-fill"
                    viewBox="0 0 16 16"
                    width="10"
                    height="10"
                  >
                    <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
                  </svg>
                </div>
              </button>
              <button
                /*
                onClick={() => dispatch({type:"REMOVE_TODO", payload:todo})}
                */
                onClick={() => {
                  axios.delete(`http://localhost:9000/todos/${todo.id}`).then(
                    (response) => {
                      dispatch({ type: "REMOVE_TODO", payload: todo });
                    },
                    (error) => {}
                  );
                }}
              >
                <div className="img-container">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-trash"
                    viewBox="0 0 16 16"
                    width="10"
                    height="10"
                  >
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                    <path
                      fill-rule="evenodd"
                      d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"
                    />
                  </svg>
                </div>
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}
