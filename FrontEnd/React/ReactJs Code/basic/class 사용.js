import './App.css';
import React from "react";
import ReactDom from 'react-dom';

function App() { /* 최근 트렌드는 클래스형 컴포넌트보다 함수형 컴포넌트 선호 ( hook으로 클래스형 컴포넌트 대체 ) */
  return (
    <div className="App">
      <header className="App-header"> /* 다른 클래스의 코드를 가져올 시 아래처럼 코드 사용 */
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
