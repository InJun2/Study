import React from 'react';
import '../css/home.css';
import 'bootstrap/dist/css/bootstrap.css';
import { BsFillPersonFill } from 'react-icons/bs'

import LineChart from '../component/LineChart';
import CarouselUI from '../component/Carousel';
import HomeTable from '../component/HomeTable';
import SubTitle from '../component/SubTitle';
import ItemBox from '../component/ItemBox';
import InfoBox from '../component/InfoBox';

function Home(){
    const items = [
        {title: "React-Query",src: "img/react_query.png",content: "#네트워크데이터 #상태변수필요X"}, 
        {title: "React-Router", src:"img/react_router.jpg",content: "#라우팅라이브러리 #요청URL페이지이동"}, 
        {title: "React-BootStrap", src:"img/react_bootstrap.jpg", content:"#React+Bootstrap #반응형 #웹프레임워크"},
        {title: "Nivo-Chart", src:"img/nivo_chart.png", content: "#차트라이브러리 #커스텀차트제공"}
    ];

    return(
        <div className='container_home'>
            <div className="home_img_box shadow-lg">
                <CarouselUI/>
            </div>

            <div className='container_info_box shadow-lg'>
                <InfoBox title="React" 
                    content="웹 프레임워크 & 자바스크립트 라이브러리
                    싱글 페이지, 모바일 애플리케이션 개발
                    VirtualDom을 이용, 동적 UI
                    Component 기반으로 Data Flow는 단방향"/>
            </div>

            <div className="home_subtitle">
                <SubTitle title="Team Role"/>
            </div>

            <div className='team_box shadow-lg'>
                <span className='team_role'>BACK-END</span>
                <span className='team_member'>
                    <p><BsFillPersonFill/> OOO</p>
                    <p><BsFillPersonFill/> OOO</p>
                </span>
                <span className='team_member'>
                    <p><BsFillPersonFill/> OOO</p>
                    <p><BsFillPersonFill/> OOO</p>
                </span>
                <span className='team_role'>FRONT-END</span>
                <span className='team_member'>
                    <p><BsFillPersonFill/> OOO</p>
                    <p><BsFillPersonFill/> OOO</p>
                </span>
            </div>

            <div className="home_subtitle">
                <SubTitle title="Use Library"/>
            </div>

            {items.map((item, index)=>{
                    return(
                        <React.Fragment key={index}>
                            <div className='home_item_box'>
                                <ItemBox item={item}/>
                            </div>
                        </React.Fragment>
                    );
            })}

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
    );
}

export default Home;