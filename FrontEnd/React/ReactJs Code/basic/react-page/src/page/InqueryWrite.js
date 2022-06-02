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

            <div className='inquery_write_content'>
                <div className='inquery_write_row'>
                    <span className='inquery_write_row_title'>문의 종류</span>
                    <span className='inquery_write_row_input'>
                        <select>
                            <option value='login'>로그인 문의</option>
                            <option value='member'>회원 정보 문의</option>
                            <option value='board'>게시판 문의</option>
                            <option value='other'>기타</option>
                        </select>
                    </span>
                </div>

                <div className='inquery_write_row'>
                    <span className='inquery_write_row_title'>제목</span>
                    <span className='inquery_write_row_input'>
                        <input type='text'/>
                    </span>
                </div>

                <div className='inquery_write_row'>
                    <span className='inquery_write_row_title'>내용</span>
                    <span className='inquery_write_row_textarea'>
                        <textarea/>
                    </span>
                </div>

                <div className='inquery_write_row'>
                    <span className='inquery_write_row_title'>첨부파일(선택)</span>
                    <span className='inquery_write_row_input'>
                        <input type='file'/>
                    </span>
                </div>

                <div className='inquery_write_button_box'>
                    <button type='button'>취소</button>
                    <button type='button'>작성</button>
                </div>

            </div>
        </div>
    );
}

export default InqueryWrite;