import './App.css';

import { useState } from 'react';

function App() {

  const [buttonColor, setButtonColor] = useState('blue')

  const newButtonColor = buttonColor === 'red' ? 'blue' : 'red';

  return (
    <div className="App">
      <button
        style={{ backgroundColor: buttonColor }}
        onClick={() => setButtonColor(newButtonColor)}
      >
        Change to {newButtonColor}
      </button>
      <input type="checkbox"
        defaultChecked={false}
      >
      </input>
    </div>
  );
}

export default App;
