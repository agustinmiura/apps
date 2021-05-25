import React, { Component } from "react";

class App extends Component {
  state = {
    count: 0,
    isOn: false,
  };

  componentDidMount() {
    document.title = `You have clicked ${this.state.count} times`;
  }

  componentDidUpdate() {
    document.title = `You have clicked ${this.state.count} times`;
  }

  toggleLight = () => {
    this.setState((prevState) => ({
      isOn: !prevState.isOn,
    }));
  };

  incrementCount = () => {
    this.setState((state, props) => {
      return { count: state.count + 1 };
    });
  };

  render() {
    return (
      <>
        <h2>Counter</h2>
        <button onClick={this.incrementCount}>
          I was clicked {this.state.count}
        </button>

        <h2>Toggle light</h2>
        <div
          style={{
            height: "50px",
            width: "50px",
            background: this.state.isOn ? "yellow" : "grey",
          }}
          onClick={this.toggleLight}
        ></div>
      </>
    );
  }
}

export default App;
