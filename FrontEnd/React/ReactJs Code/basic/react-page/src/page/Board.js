import React from 'react';
import {BsArrowRight} from 'react-icons/bs'
import LoadBoard from '../component/LoadBoard';
import SubTitle from '../component/SubTitle';
import '../css/board.css';

function Board(){

    return(
        <div className='board_container'>
            <SubTitle title="Board"/>
            
            <LoadBoard/>

            <span className='end_right_button'>
                <button className='table-button'>글 등록 <BsArrowRight/></button>
                <button className='table-button'>글 수정 <BsArrowRight/></button>
                <button className='table-button'>글 삭제 <BsArrowRight/></button>
            </span>
        </div>
    );
}

export default Board;