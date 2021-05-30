import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';
import {replaceCamelWithSpaces} from './App';

test('button has correct initial color', () => {
  render(<App />)

  const colorButton = screen.getByRole('button', {
    name: 'Change to Midnight Blue'
  })

  expect(colorButton).toHaveStyle({
    backgroundColor: 'MediumVioletRed'
  })

});
test('button turns blue when clicked', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to Midnight Blue'
  })

  expect(colorButton).toHaveStyle({
    backgroundColor: 'MediumVioletRed'
  })

  fireEvent.click(colorButton)

  expect(colorButton).toHaveStyle({
    backgroundColor: 'MidnightBlue'
  })

  expect(colorButton.textContent).toBe('Change to Medium Violet Red')

})

test('initial conditions', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to Midnight Blue'
  })
  expect(colorButton).toBeEnabled()
  const check = screen.getByRole('checkbox',{
    name:'Disable button'
  })
  expect(check).not.toBeChecked()
})

test('when clicked button is disabled', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to Midnight Blue'
  })
  const check = screen.getByRole('checkbox', {
    name:'Disable button'
  })

  fireEvent.click(check)
  expect(colorButton).not.toBeEnabled()
  expect(check).toHaveAttribute('checked')
})

test('Checkbox disables the button on first click and enables on the second one', () => {

  render(<App />)
  const checkbox = screen.getByRole('checkbox', {name:'Disable button'});
  const colorButton = screen.getByRole('button', {name:'Change to Midnight Blue'});

  fireEvent.click(checkbox);
  expect(colorButton).toBeDisabled();

  fireEvent.click(checkbox);
  expect(colorButton).toBeEnabled();

})

describe('spaces before camel-case capital letters', () => {
  test('Works for no inner capital letters', () => {
    expect(replaceCamelWithSpaces('Red')).toBe('Red')
  })
  test('works for one inner capital leter', () => { 
    expect(replaceCamelWithSpaces('MidnightBlue')).toBe('Midnight Blue')
  })
  test('test for multiple capital letters ', () => {
    expect(replaceCamelWithSpaces('MediumVioletRed')).toBe('Medium Violet Red');
  })
})


