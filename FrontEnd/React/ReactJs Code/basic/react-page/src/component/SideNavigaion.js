import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/side_navi.css';
import { FiAlignJustify } from 'react-icons/fi';

export default function SideNavigation(){
    const [menuToggle, setMenu] = useState(false);

    const openMenu = () =>{
        setMenu(!menuToggle);
    }
    
    return(
        <div>
            <ul className={menuToggle ? "show-menu navigation" : "hide-menu navigation"}>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/support">Support</Link></li>
                <li><Link to="/inquery">My Inquiry</Link></li>
                <li><Link to="/board">Board</Link></li>
                <li><Link to="/login">Login</Link></li>
            </ul>

            <input type="checkbox" id ="nav-trigger" className="nav-trigger" onChange={()=>openMenu()}/>
            <label htmlFor="nav-trigger"><FiAlignJustify className='toggle-menu-icon'/></label>
        </div>
    );
}

