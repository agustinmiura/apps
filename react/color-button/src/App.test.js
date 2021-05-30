import { render, screen , fireEvent } from '@testing-library/react';
import App from './App';

test('button has correct initial color', () => {
  render(<App />)
  
  const colorButton = screen.getByRole('button', {
    name:'Change to red'
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