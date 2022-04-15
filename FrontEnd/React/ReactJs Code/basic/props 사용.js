import './App.css';
import React from "react";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Test name="test name">childer</Test>
      </header>
    </div>
  );
}

export default App;

class Codelab extends React.Component{
  render(){
    
    return (
        <div>
          <h1>Hello {this.props.name}</h1>
          <p>{this.props.childer}</p>
          <p>{this.props.default}</p>
          {FunTest("버튼")}
        </div>
      );
  }
}

function FunTest(data){
  return <button>{data}</button>
}

class Test extends React.Component{
  render(){   // 이안에는 JS 와 값을 돌려보낼 return 이 들어가는 듯
    let childerName= "Hwang";

    return (
      <div>
        <Codelab childer={this.props.name} name={childerName}/>      
        </div>
      );
  }
}


Codelab.defaultProps = {
    name : "DefaultProps Test",
    childer : "DefaultChilder Test",
    default : "DefaultParam Test"
}

