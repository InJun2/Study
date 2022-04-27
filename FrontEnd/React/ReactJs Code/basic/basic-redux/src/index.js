import React from 'react';
import {createRoot} from 'react-dom/client';

import App from './components/App';
import {legacy_createStore} from 'redux';
import reducers from './reducer';
import * as actions from './actions';
import reportWebVitals from './reportWebVitals';

import { Provider } from 'react-redux';

const store = legacy_createStore(reducers);        // 현재 해당 react 프로젝트는 인프런 강의 예제코드로 class형 컴포넌트 사용 -> 현재는 대부분 함수형 컴포넌트를 사용하고 현재 지원하는 라이브러리에 차이가 존재
                                                   // redux toolkit와 React Hook을 이용한 새로운 예제 프로젝트 생성 예정
store.subscribe(() => console.log(store.getState()));
store.dispatch(actions.increment());
store.dispatch(actions.decrement());
store.dispatch(actions.setColor([200,200,200]));


const root = createRoot(document.getElementById("root"));
root.render(
    <React.StrictMode>
        <Provider store={store}>
            <App/>,
        </Provider>
    </React.StrictMode>
);

reportWebVitals();
