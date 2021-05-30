import './App.css';

import { useState } from 'react';

function App() {

  const [buttonColor, setButtonColor] = useState('blue')
  const [disabled, setdisabled] = useState(false);

  const newButtonColor = buttonColor === 'red' ? 'blue' : 'red';

  return (
    <div className="App">
      <button
        style={{ backgroundColor: buttonColor }}
        onClick={() => setButtonColor(newButtonColor)}
        disabled={disabled}
      >
        Change to {newButtonColor}
      </button>
      <input
        type="checkbox"
        id="enable-button-checkbox"
        defaultChecked={disabled}
        aria-checked={disabled}
        onChange={(e) => setdisabled(e.target.checked)} />
      <label htmlFor="enable-button-checkbox">Disable button</label>
    </div>
  );
}

export default App;
