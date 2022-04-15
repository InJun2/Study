import './App.css';
import React from "react";
import ReactDom from 'react-dom';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Test/>

      </header>
    </div>
  );
}

export default App;

class Codelab extends React.Component{
  render(){
    let text="Text test";
    let style={
      backgroundColor: 'aqua'
    }
    
    return (
      <div style={style}>{text}</div>
    );
  }
}

class Test extends React.Component{
  render(){
    return (
      <Codelab/>
      );
  }
}
