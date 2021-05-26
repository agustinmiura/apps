import React, { useState } from "react";

export default function Login() {
  
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [user, setUser] = useState(null);

  const handleSubmit = event => {
    event.preventDefault();
    const userData = {
      username,
      password
    }
    setUser(userData);
    setUsername("");
    setPassword("");
  }

  return (
    <div
      style={{
        textAlign: "center",
      }}
    >
      <h2>Login</h2>
      <form
        onSubmit={handleSubmit}
        style={{
          textAlign: "center",
          display: "grid",
          alignItemds: "center",
          justifyItems: "center",
        }}
      >
        <input
          onChange={(event) => setUsername(event.target.value)}
          type="text"
          placeholder="username"
          value = {username}
        ></input>
        <input
          onChange={(event) => setPassword(event.target.value)}
          type="password"
          placeholder="password"
          value = {password}
        ></input>
        <button type="submit">Submit</button>
      </form>

      {user && JSON.stringify(user)}
    </div>
  );
}
