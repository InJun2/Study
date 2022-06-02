import React from 'react';
import '../css/itembox.css';

function ItemBox(props){
    return(
        <div className='itembox shadow-lg'>
            <div className='itembox_img'><img src={props.item.src} alt={props.item.title}/></div>
            
            <div className='itembox_title'>{props.item.title}</div>

            <div className='itembox_content'>{props.item.content}</div>
        </div>
    );
}

export default ItemBox;