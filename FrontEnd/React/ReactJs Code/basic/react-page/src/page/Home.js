import React from 'react';
import '../css/home.css';
import 'bootstrap/dist/css/bootstrap.css';

import LineChart from '../component/LineChart';
import CarouselUI from '../component/Carousel';
import HomeTable from './HomeTable';
import SubTitle from '../component/SubTitle';
import ItemBox from '../component/ItemBox';

function Home(){

    return(
        <>
            <div className='container_home'>
                <div className="home_img_box shadow-lg">
                    <CarouselUI/>
                </div>

                <div className='container_info_box shadow-lg'>
                    <img src='img/react.png' alt='info_img' className='info_img'/>

                    <div className='info_text_box'>
                        <div className='info_text_main float-end'>
                            <span className='float-end'>React</span>
                        </div>

                        <div className='info_text_content'>
                            웹 프레임워크 & 자바스크립트 라이브러리<br/>
                            싱글 페이지, 모바일 애플리케이션 개발<br/>
                            VirtualDom을 이용, 동적 UI<br/>
                            Component 기반으로 Data Flow는 단방향
                        </div>
                    </div>
                </div>

                <div className="home_subtitle">
                    <SubTitle title="Use Library"/>
                </div>

                <div className='home_item_box'>
                    <ItemBox title="React-Query" src="img/react_query.png" content="#네트워크데이터 #상태변수필요X"/>
                </div>
                <div className='home_item_box'>
                    <ItemBox title="React-Router" src="img/react_router.jpg" content="#라우팅라이브러리 #요청URL페이지이동"/>
                </div>
                <div className='home_item_box'>
                    <ItemBox title="React-BootStrap" src="img/react_bootstrap.jpg" content="#React+Bootstrap #반응형 #웹프레임워크"/>
                </div>
                <div className='home_item_box'>
                    <ItemBox title="Nivo-Chart" src="img/nivo_chart.png" content="#차트라이브러리 #커스텀차트제공"/>
                </div>
                <div className="line_chart_box shadow">
                    <LineChart/>
                </div>

                <div className='container_chart_info_box shadow-lg'>
                    make sure parent container have a defined height when using
                    responsive component, otherwise height will be 0 and
                    no chart will be rendered.
                    website examples showcase many properties,
                    you'll often use just a few of them.
                </div>
                
                <div className='home_boarder'>
                    <HomeTable/>
                </div>
            </div>
        </>
    );
}

export default Home;