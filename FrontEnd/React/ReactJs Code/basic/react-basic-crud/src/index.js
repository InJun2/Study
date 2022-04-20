import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Contacts from './Contacts';
import Header from './Header';
import Footer from './Footer';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));  // index.html 의 root 엘리먼트에 밑에 해당하는 요소들을 모두 밀어넣어 렌더링 ( 구현 ) 한다 
  // text 엘리먼트를 받아온다면 해당 text id인 엘리먼트에 들어가게 될것
  // 즉 보여주는건 결국 index.html 이지만 해당 js 파일에서 모두 구현해놓고 해당 구현부를 index.html의 root 엘리먼트에 구현
root.render(
  <React.StrictMode>  {/* 애플리케이션 내의 잠재적인 문제를 알아내기 위한 도구, Fragment와 같이 UI를 렌더링하지 않으며 자손들에 대한 부가적인 검사와 경고 활성화 */}
    <Header/>
    <Contacts/>
    <Footer/>
  </React.StrictMode>
);

reportWebVitals();  // CRA(Create React App) 에서 웹 퍼포먼스 측정 도구, web-vitals 라는 라이브러리 사용