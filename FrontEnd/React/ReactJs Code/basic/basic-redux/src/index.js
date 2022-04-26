import React from 'react';
import {createRoot} from 'react-dom/client';

import App from './components/App';
import {legacy_createStore} from 'redux';
import reducers from './reducer';
import * as actions from './actions';
import reportWebVitals from './reportWebVitals';

import { Provider } from 'react-redux';

const store = legacy_createStore(reducers);        // configureStore 로 변경 예정 ( 개선버전 )

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