<<<<<<< HEAD
<<<<<<< HEAD
import Container from "react-bootstrap/Container";
import OrderEntry from "./pages/entry/OrderEntry";
import { OrderDetailsProvider } from "./contexts/OrderDetails";

function App() {
  return (
    <Container>
      <OrderDetailsProvider>
        {}
        <OrderEntry />
      </OrderDetailsProvider>
      {}
    </Container>
=======
import logo from "./logo.svg";
import "./App.css";
import SummaryForm from "./pages/summary/SummaryForm";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
import Container from "react-bootstrap/Container";
import OrderEntry from "./pages/entry/OrderEntry";
import { OrderDetailsProvider } from "./contexts/OrderDetails";

function App() {
  return (
    <Container>
      <OrderDetailsProvider>
        {}
        <OrderEntry />
      </OrderDetailsProvider>
      {}
    </Container>
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
  );
}

export default App;
