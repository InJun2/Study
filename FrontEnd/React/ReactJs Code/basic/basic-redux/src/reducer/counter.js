import * as types from '../actions/ActionTypes';

const initialState = {
    number: 0,
    dummy: 'dumbdumb',
    dumbObject:{
        d:0,
        u:1,
        m:2,
        b:3
    }
};

export default function counter(state = initialState, action){  // state = initalState : state가 undifined 일 경우 state를 initialState를 사용한다는 의미
    switch(action.type){   
        case types.INCREMENT:
            return {
                ...state, 
                number : state.number +1,
                dumbObject: {...state.dumbObject, u:2}
            };
        case types.DECREMENT:
            return {
                ...state, 
                number : state.number -1,
                dumbObject: {...state.dumbObject, u:3}
            };
        default:
            return state;
    }
}