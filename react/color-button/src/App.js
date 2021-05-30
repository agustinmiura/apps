<<<<<<< HEAD
import { useState } from 'react';

export function replaceCamelWithSpaces(colorName) {
  return colorName.replace(/\B([A-Z])\B/g, ' $1');
}

function App() {
  const [ buttonColor, setButtonColor ] = useState('MediumVioletRed');
  const [ disabled, setDisabled ] = useState(false);
  
  const newButtonColor = buttonColor === 'MediumVioletRed' ? 'MidnightBlue' : 'MediumVioletRed';
  
  return (
    <div>
      <button
        style={{backgroundColor: disabled ? 'gray' : buttonColor}}
        onClick={() => setButtonColor(newButtonColor)}
        disabled={disabled}
      >Change to {replaceCamelWithSpaces(newButtonColor)}</button>
    <br />
    <input
=======
import './App.css';

import { useState } from 'react';

function App() {

  const [buttonColor, setButtonColor] = useState('blue')
  const [disabled, setDisabled] = useState(false);

  const newButtonColor = buttonColor === 'red' ? 'blue' : 'red';

  return (
    <div className="App">
      <button
        style={{ backgroundColor: disabled ? 'gray' : buttonColor }}
        onClick={() => setButtonColor(newButtonColor)}
        disabled={disabled}
      >Change to {newButtonColor}</button>
      <br />
      <input
>>>>>>> 56ef978 (Created React js app with unit testing and code coverage.)
        type="checkbox"
        id="disable-button-checkbox"
        defaultChecked={disabled}
        aria-checked={disabled}
        onChange={(e) => setDisabled(e.target.checked)} />
<<<<<<< HEAD
        <label htmlFor="disable-button-checkbox">Disable button</label>
    </div>  
  );
}

export default App;
=======
      <label htmlFor="disable-button-checkbox">Disable button</label>
    </div>
  );
}

export default App;
>>>>>>> 56ef978 (Created React js app with unit testing and code coverage.)
