import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';

test('button has correct initial color', () => {
  render(<App />)

  const colorButton = screen.getByRole('button', {
    name: 'Change to red'
  })

  expect(colorButton).toHaveStyle({
    backgroundColor: 'blue'
  })

});
test('button turns blue when clicked', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to red'
  })

  expect(colorButton).toHaveStyle({
    backgroundColor: 'blue'
  })

  fireEvent.click(colorButton)

  expect(colorButton).toHaveStyle({
    backgroundColor: 'red'
  })

  expect(colorButton.textContent).toBe('Change to blue')

})

test('initial conditions', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to red'
  })
  expect(colorButton).toBeEnabled()
  const check = screen.getByRole('checkbox')
  expect(check).not.toBeChecked()
})

test('when clicked button is disabled', () => {
  render(<App />)
  const colorButton = screen.getByRole('button', {
    name: 'Change to red'
  })
  const check = screen.getByRole('checkbox')

  fireEvent.click(check)
  expect(colorButton).not.toBeEnabled()
  expect(check).toHaveAttribute('checked')
})

