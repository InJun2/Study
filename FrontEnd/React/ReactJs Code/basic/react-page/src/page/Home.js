import React from 'react';
import '../css/home.css';
import 'bootstrap/dist/css/bootstrap.css';

import LineChart from '../component/LineChart';
import CarouselUI from '../component/Carousel';
import HomeTable from './Table';

function Home(){

    return(
        <>
            <div className='container_home'>
                <div className="home_img_box shadow-lg">
                    <CarouselUI/>
                </div>

                <div className='home_boarder'>
                    <HomeTable/>
                </div>

                <div className="line_chart_box shadow">
                    <LineChart/>
                </div>

                <div className='container_item shadow-lg'>
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