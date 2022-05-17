import React from 'react';
import '../css/itembox.css';

function ItemBox(props){
    return(
        <div className='itembox shadow-lg'>
            <div className='itembox_title'>{props.title}</div>

            <div className='itembox_img'><img src={props.src} alt={props.title}/></div>

            <div className='itembox_content'>{props.content}</div>
        </div>
    );
}

export default ItemBox;