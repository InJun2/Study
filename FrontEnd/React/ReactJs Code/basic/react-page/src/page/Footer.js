import React from 'react';
import '../css/footer.css';
import { BsFacebook, BsGoogle, BsYoutube, BsGithub } from 'react-icons/bs';

function Footer(){
    return(
        <div className='footer'>
            <h3>React Page</h3>
            <p>react / react-router-dom / react-bootstrap / react-icons / nivo chart / axios / react-hook-form & yup</p>
            <p>
                <a href='https://ko-kr.facebook.com/'><BsFacebook/></a> |&nbsp; 
                <a href='https://www.google.com/'><BsGoogle/></a> |&nbsp;
                <a href='https://www.youtube.com/'><BsYoutube/></a> |&nbsp;
                <a href='https://github.com/InJun2/Study/tree/main/FrontEnd/React/ReactJs%20Code/basic/react-page'><BsGithub/></a>
            </p>
        </div>
    );
}

export default Footer;