import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import MainPage from './MainPage';
import MapPage from './MapPage';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));  // index.html 의 root 엘리먼트에 밑에 해당하는 요소들을 모두 밀어넣어 렌더링 ( 구현 ) 한다 
  // text 엘리먼트를 받아온다면 해당 div 파일에 넣어짐
  // 즉 보여주는건 결국 index.html 이지만 해당 js 파일에서 모두 구현해놓고 해당 구현부를 index.html의 root에 쏴주는 느낌
root.render(
  <React.StrictMode>
    <MainPage/> {/* Hedaer.js + Main.js + Footer.js를 가지고 있는 MainPage.js 호출 */}
    <App />
    <MapPage/>   {/* Hedaer.js + Map.js + Footer.js를 가지고 있는 MapPage.js 호출 */}
  </React.StrictMode>
);

reportWebVitals();  // CRA(Create React App) 에서 웹 퍼포먼스 측정 도구, web-vitals 라는 라이브러리 사용