import {combineReducers } from 'redux';
import counter from './counter';
import ui from './ui';

const reducers = combineReducers({  // sub reducers 통합, root reducer 
    counter, ui
});

export default reducers;