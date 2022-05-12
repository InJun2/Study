import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import '../css/side_navi.css';

export default function SideNavigation(){
    const [menuToggle, setMenu] = useState(false);

    useEffect(()=>{
        if(menuToggle===true){
            
        }
        if(menuToggle===false){
            
        }
    }, [menuToggle])

    const openMenu = () =>{
        setMenu(!menuToggle);
    }

    return(
        <div>
            <ul class="navigation">
                <li class="nav-item"><Link to="#">Home</Link></li>
                <li class="nav-item"><Link to="#">Portfolio</Link></li>
                <li class="nav-item"><Link to="#">About</Link></li>
                <li class="nav-item"><Link to="#">Blog</Link></li>
                <li class="nav-item"><Link to="#">Contact</Link></li>
            </ul>

            <input type="checkbox" id="nav-trigger" class="nav-trigger" />
            <label for="nav-trigger"></label>

            
        </div>
    );
}
