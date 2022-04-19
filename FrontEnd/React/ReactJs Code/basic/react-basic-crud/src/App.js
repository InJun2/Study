import React from 'react';
import './App.css';

class App extends React.Component{
  state = {
    count : 0
  }
  add = () => {
    this.setState(a => ({count: a.count +1}));  // setState 로 상태를 바꿔야하고 a 라는 매개변수는 state의 현재 상태를 나타냄
  }
  minus = () => {
    this.setState(bb => ({count : bb.count -1}));
  }
  render(){
    return (
      <div className="App">
        <h1>This number is {this.state.count}</h1>
        <button onClick={this.add}>Add</button>
        <button onClick={this.minus}>Minus</button>
      </div>
    );
  }
}

export default App;
