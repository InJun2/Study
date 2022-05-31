import React from 'react';
import {BsArrowRight} from 'react-icons/bs'
import { Link } from 'react-router-dom';

import Issue from '../component/Issue';
import SubTitle from '../component/SubTitle';
import '../css/support.css';

export default function Support(){

    return(
        <div className='issue_container'>
            <SubTitle title="Inquery Issues"/>

            <div className='issue_boxs'>
                <Issue 
                    title="해당 페이지는 무엇인가요?" 
                    body="react와 몇몇 라이브러리들을 이용하여 간단한 페이지를 구현한 페이지입니다."/>
                <Issue 
                    title="ID/Pwd를 잊어버렸어요" 
                    body="로그인 페이지에서 ID/PWD 찾기를 이용하여 주세요. 해당 실행이 불가능 하다면 문의 사항 작성바랍니다."/>
                <Issue
                    title="문의 사항은 어떻게 진행하나요?"
                    body="아래의 버튼을 이용하여 문의사항 페이지로 이동합니다. 해당 문의사항 페이지는 자신이 작성한 문의 내역만 조회가 가능합니다."/>
            </div>

            <Link to="/inquery">
                <button>문의하기<BsArrowRight/></button>
            </Link>
        </div>
    );
}