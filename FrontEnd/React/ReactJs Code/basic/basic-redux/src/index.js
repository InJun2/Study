import React from 'react';
import {createRoot} from 'react-dom/client';

import App from './components/App';
import {createStore} from 'redux';
import reducers from './reducer';
import * as actions from './actions';
import reportWebVitals from './reportWebVitals';

const store = createStore(reducers);

console.log(store.getState());
store.subscribe(() => console.log(store.getState()));
store.dispatch(actions.increment());
store.dispatch(actions.increment());
store.dispatch(actions.decrement());
store.dispatch(actions.setColor([200,200,200]));


const root = createRoot(document.getElementById("root"));
root.render(
    <React.StrictMode>
        <App/>,
    </React.StrictMode>
);

reportWebVitals();