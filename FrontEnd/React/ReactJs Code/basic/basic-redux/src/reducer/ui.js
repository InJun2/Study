import * as types from '../actions/ActionTypes';

const initalState = {
    color : [255, 255, 255]
};

export default function ui(state = initalState, action){    // state = initalState : state가 undifined 일 경우 state를 initialState를 사용한다는 의미
    if(action.type === types.SET_COLOR){
        return {
            color: action.color
        };
    }else {
        return state;
    }
}