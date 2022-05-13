import React from 'react';
import '../css/home.css';

import LineChart from '../component/Line_Chart';
import SideNavigation from './Side_Navigaion';

function Home(){

    return(
        <>
            <SideNavigation/>

            <div className='container'>
                <div className='home_img_box'>
                    <img  src='img/river1.png' alt='home_img'/>
                </div>
                <div className='container_item'>
                    Home IMG.. or BootStrap Carousel Slide..
                </div>

                <div className='container_item'>
                    NIVO LINE CHART Library
                </div>

                <div className="line_chart_box">
                    <LineChart/>
                </div>

                <div className='container_item'>
                    make sure parent container have a defined height when using
                    responsive component, otherwise height will be 0 and
                    no chart will be rendered.
                    website examples showcase many properties,
                    you'll often use just a few of them.
                </div>
            </div>
        </>
    );
}

export default Home;