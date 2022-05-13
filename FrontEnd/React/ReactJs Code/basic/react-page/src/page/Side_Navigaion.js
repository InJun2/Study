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
                <li><Link to="Post">Post</Link></li>
                <li><Link to="#">About</Link></li>
                <li><Link to="#">About</Link></li>
                <li><Link to="#">About</Link></li>
            </ul>

            <input type="checkbox" id ="nav-trigger" className="nav-trigger" onChange={()=>openMenu()}/>
            <label htmlFor="nav-trigger"><FiAlignJustify className='toggle-menu-icon'/></label>
        </div>
    );
}
