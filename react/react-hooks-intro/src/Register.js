import React, { useState } from "react";

const initialFormState = {
  username:"",
  email:"",
  password:""
}

export default function Register() {

  const [form, setForm] = useState(initialFormState)

  const [user, setUser] = useState(null);

  const handleChange = event => {
    setForm({
      ...form,
      [event.target.name]:event.target.value
    })
  }

  const handleSubmit = event => {
    event.preventDefault();
    setUser(form);
    setForm(initialFormState);
  }

  return (
    <div
      style={{
        textAlign: "center",
      }}
    >
      <h2>Register</h2>
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
          type="email"
          placeholder="Email address"
          name="email"
          onChange={handleChange}
          value={form.email}
        ></input>
        <input
          type="text"
          placeholder="username"
          name="username"
          onChange={handleChange}
          value={form.username}
        ></input>
        <input
          type="password"
          placeholder="password"
          name="password"
          onChange={handleChange}
          value={form.password}        
        ></input>
        <button type="submit">Submit</button>
      </form>
      {user && JSON.stringify(user, null, 2)}
    </div>
  );
}
