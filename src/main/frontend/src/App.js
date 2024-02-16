import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("/api/test")
        .then(response => response.text())
        .then(message => {
            setMessage(message);
        });
  }, []);

  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          {message}
        </header>
      </div>
  );
}

export default App;
