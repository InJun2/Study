import React from 'react';
import '../css/infobox.css';

function InfoBox(props){
    return(
        <div className='info_box'>
            <img src='img/react.png' alt='info_img' className='info_img'/>

            <div className='info_text_box'>
                <div className='info_text_main float-end'>
                    <span className='float-end'>{props.title}</span>
                </div>

                <div className='info_text_content'>
                    {props.content}
                </div>
            </div>

        </div>
    );
}

export default InfoBox;