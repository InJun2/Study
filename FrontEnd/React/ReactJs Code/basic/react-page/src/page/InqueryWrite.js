import React from 'react';
import SubTitle from '../component/SubTitle';
import '../css/inquery_write.css';

function InqueryWrite(){
    return(
        <div className='inquery_write_container'>
            <SubTitle title="Inquery Write"/>

            <div className='inquery_write_explanation_box'>
                해당 페이지는 문의 글쓰기 페이지 입니다 <br/>
                문의 분류를 선택 후 문의 내용을 작성해주시길 바랍니다 <br/>
                아이디는 자동으로 기입되며 글·답글 조회는 Inquery 페이지에서 조회가능합니다.
            </div>
        </div>
    );
}

export default InqueryWrite;