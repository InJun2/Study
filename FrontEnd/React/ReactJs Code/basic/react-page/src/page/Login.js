import React from 'react';
import { Link } from 'react-router-dom';
import '../css/login.css';

function Login(){
    return(
        <div className='login_container'>
            <div className='login_box'>
                <div className='login_text_id'>
                    ID
                </div>
                <div className='login_input_id'>
                    <input type='text' placeholder='ID' name='userId' required/>
                </div>

                <div className='login_text_pwd'>
                    PassWord
                </div>
                <div className='login_input_pwd'>
                    <input type='password' placeholder='Pwd' name='userPwd' required/>
                </div>

                <div className='login_button_box'>
                    <input type="submit" value="Login"/>
                </div>
            </div>

            <div className='login_bottom_link'>
                <Link to="/join">Join?</Link>
                <Link to="#">Forgot Id/Pwd?</Link>
            </div>
        </div>
    );
}

export default Login;