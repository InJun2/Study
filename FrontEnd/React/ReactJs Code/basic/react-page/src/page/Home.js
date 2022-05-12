import React, {useState} from 'react';
import SideNavigation from './Side_Navigaion';

import axios from 'axios';

function Home(){
    const [load, setLoad] = useState(true);

    return(
        <div className='container'>
            <SideNavigation/>
            <div className='site-wrap'>Homepage</div>
        </div>
    );
}

export default Home;