import { createSlice } from '@reduxjs/toolkit';

const initialStateValue = {name: "", age:0, email: ""}

export const userSlice = createSlice({  // createSlice는 기존의 createReducer과 createAction 이 하던일을 같이해줌 ( actions js 파일 필요없음 )
    name: "user",                   // prefix에 해당하는 이름
    initialState: {value: initialStateValue},       // 초기 상태
    reducers: {             // 각 액션 선언
        login: (state, action) =>{
            state.value = action.payload        // login 액션 로직
        },
        logout: (state) => {
            state.value = initialStateValue     // lgout 액션 로직
        }
    },
});

export const { login, logout } = userSlice.actions;     // createSlice로 만든 액션들 정의

export default userSlice.reducer;