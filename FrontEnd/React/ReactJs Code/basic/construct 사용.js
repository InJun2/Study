import './App.css';
import React from "react";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Counter/>
      </header>
    </div>
  );
}

export default App;

class Counter extends React.Component{
  constructor(props){
    super(props);
    this.state={
      value:0
    };
    this.handleClick = this.handleClick.bind(this);
  }
  
  handleClick(){
    this.setState({
      value:this.state.value +1
    });
  }

  render(){
    return (
      <div>
        <h2>{this.state.value}</h2>
        <button onClick={this.handleClick}>Press Me</button>
      </div>
    )
  }
}
