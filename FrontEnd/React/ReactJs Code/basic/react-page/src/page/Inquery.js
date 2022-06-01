import React from 'react';
import SubTitle from '../component/SubTitle';
import '../css/inquery.css';
import LoadInquery from '../component/LoadInquery';
import { Link } from 'react-router-dom';

function Inquery(){
    return(
        <div className='inquery_container'>
            <SubTitle title="Inquery"/>

            <div className='inquery_box'>
                <span>* 보다 자세한 문의사항은 아래 연락처로 문의해주세요</span>
                <span className='team_title'>로그인</span>
                <span className='team_member'>
                    <ul>
                        <li>OOO (010-1111-2222)</li>
                        <li>OOO (010-33333-4444)</li>
                    </ul>
                </span>
                <span className='team_title'>게시판</span>
                <span className='team_member'>
                    <ul>
                        <li>OOO (010-5555-6666)</li>
                        <li>OOO (010-7777-8888)</li>
                    </ul>
                </span>
            </div>
            
            <LoadInquery/>

            <Link to="/inquery-write">
                <button className='table-button'>등록</button>
            </Link>
        </div>
    );
}

export default Inquery;