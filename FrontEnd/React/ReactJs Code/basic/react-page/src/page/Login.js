import React from 'react';
import { Link } from 'react-router-dom';
import '../css/login.css';

function Login(){
    return(
        <div className='login_container'>
            <div className='login_box'>
                
                <Link to="#">
                    <div className='login_button_box'>
                        Login
                    </div>
                </Link>
            </div>

            <div className='login_box_bottom'>
                <Link to="#">Join?</Link>
                <Link to="#">Forgot Id/Pwd?</Link>
            </div>
        </div>
    );
}

export default Login;