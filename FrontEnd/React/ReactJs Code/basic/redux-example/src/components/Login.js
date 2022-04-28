import React from 'react';
import { useDispatch } from 'react-redux';
import { login, logout } from '../redux/user';

function Login(){
    const dispatch = useDispatch()
    return(
        <div>
            <button onClick={()=>{
                dispatch(login({name: "Hwang", age:20, email: "email@gmail.com"}))  // login 액션을 통해 리듀서로 접근
            }}>Login</button>
            <button onClick={()=>{
                dispatch(logout())  // logout 액션을 통해 리듀서로 접근
            }}>Logout</button>
        </div>
    );
}

export default Login;