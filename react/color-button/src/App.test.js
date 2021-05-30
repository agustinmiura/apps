<<<<<<< HEAD
<<<<<<< HEAD
import { render, screen, fireEvent } from "@testing-library/react";
import App from "./App";
import { replaceCamelWithSpaces } from "./App";

test("button has correct initial color", () => {
  render(<App />);

  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });

  expect(colorButton).toHaveStyle({
    backgroundColor: "MediumVioletRed",
  });
});
test("button turns blue when clicked", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });

  expect(colorButton).toHaveStyle({
    backgroundColor: "MediumVioletRed",
  });

  fireEvent.click(colorButton);

  expect(colorButton).toHaveStyle({
    backgroundColor: "MidnightBlue",
  });

  expect(colorButton.textContent).toBe("Change to Medium Violet Red");
});

test("initial conditions", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  expect(colorButton).toBeEnabled();
  const check = screen.getByRole("checkbox", {
    name: "Disable button",
  });
  expect(check).not.toBeChecked();
});

test("when clicked button is disabled", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  const check = screen.getByRole("checkbox", {
    name: "Disable button",
  });

  fireEvent.click(check);
  expect(colorButton).not.toBeEnabled();
  expect(check).toHaveAttribute("checked");
});

test("Checkbox disables the button on first click and enables on the second one", () => {
  render(<App />);
  const checkbox = screen.getByRole("checkbox", { name: "Disable button" });
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
=======
import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';
=======
import { render, screen, fireEvent } from "@testing-library/react";
import App from "./App";
import { replaceCamelWithSpaces } from "./App";
>>>>>>> ccd2ac9 (Added more components and tests.)

test("button has correct initial color", () => {
  render(<App />);

  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });

  expect(colorButton).toHaveStyle({
    backgroundColor: "MediumVioletRed",
  });
});
test("button turns blue when clicked", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });

  expect(colorButton).toHaveStyle({
    backgroundColor: "MediumVioletRed",
  });

  fireEvent.click(colorButton);

  expect(colorButton).toHaveStyle({
    backgroundColor: "MidnightBlue",
  });

  expect(colorButton.textContent).toBe("Change to Medium Violet Red");
});

test("initial conditions", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  expect(colorButton).toBeEnabled();
  const check = screen.getByRole("checkbox", {
    name: "Disable button",
  });
  expect(check).not.toBeChecked();
});

test("when clicked button is disabled", () => {
  render(<App />);
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
  const check = screen.getByRole("checkbox", {
    name: "Disable button",
  });

  fireEvent.click(check);
  expect(colorButton).not.toBeEnabled();
  expect(check).toHaveAttribute("checked");
});

<<<<<<< HEAD
  render(<App />)
  const checkbox = screen.getByRole('checkbox', {name:'Disable button'});
  const colorButton = screen.getByRole('button', {name:'Change to red'});
>>>>>>> 56ef978 (Created React js app with unit testing and code coverage.)
=======
test("Checkbox disables the button on first click and enables on the second one", () => {
  render(<App />);
  const checkbox = screen.getByRole("checkbox", { name: "Disable button" });
  const colorButton = screen.getByRole("button", {
    name: "Change to Midnight Blue",
  });
>>>>>>> ccd2ac9 (Added more components and tests.)

  fireEvent.click(checkbox);
  expect(colorButton).toBeDisabled();

  fireEvent.click(checkbox);
  expect(colorButton).toBeEnabled();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
});

describe("spaces before camel-case capital letters", () => {
  test("Works for no inner capital letters", () => {
    expect(replaceCamelWithSpaces("Red")).toBe("Red");
  });
  test("works for one inner capital leter", () => {
    expect(replaceCamelWithSpaces("MidnightBlue")).toBe("Midnight Blue");
  });
  test("for multiple capital letters", () => {
    expect(replaceCamelWithSpaces("MediumVioletRed")).toBe("Medium Violet Red");
  });
});
<<<<<<< HEAD
=======

})
>>>>>>> 56ef978 (Created React js app with unit testing and code coverage.)
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
