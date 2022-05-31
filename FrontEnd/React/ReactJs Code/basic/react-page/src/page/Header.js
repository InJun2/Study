import React from 'react';
import { Link } from 'react-router-dom';
import '../css/header.css';

function header(){
    return(
        <div className='header'>
            <Link to="/">
                <img className='logo' alt="logo" src='img/se.png'/>
            </Link>

            <div className='main-text'>PageName</div>
        
            <div className='navbar'>
                <Link to={{pathname: `/`}} className='navi-item'><div>Home</div></Link>
                <Link to={{pathname: `/support`}} className='navi-item'><div>Support</div></Link>
                <Link to={{pathname: `/board`}} className='navi-item'><div>Board</div></Link>
            </div>

            <div className='header_toolbar'>
            <Link to="/login">Login/Logout</Link> | <Link to="/join">Join</Link> | <Link to="#">Mypage</Link> 
            </div>
        </div>
    )
}

export default header;