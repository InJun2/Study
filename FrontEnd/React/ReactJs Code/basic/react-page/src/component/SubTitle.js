import React from 'react';
import '../css/subtitle.css';

function SubTitle(props){

    return(
        <div className='subtitle'>
            <h1>{props.title}</h1>
        </div>
    );
}

export default SubTitle;