import React from 'react';
import { Link } from 'react-router-dom';
import '../css/navi.css';

function Navigation(){
    return(
        <header>
            <div className='header'>
                <Link to="/"><img className='logo' alt="logo" src='img/se.png'/></Link>

                <div className='navbar'>
                    <Link to={{pathname: `/`}} className='navi-item'><div>Home</div></Link>
                    <Link to={{pathname: `/post`}} className='navi-item'><div>Post</div></Link>
                    <Link to={{pathname: `/`}} className='navi-item'><div>Home</div></Link>
                </div>
            </div>
        </header>
    );
}

export default Navigation;