import React, { useState } from 'react';
import '../css/join.css';

function Join(){
    const [gender, setGender] = useState("");
    
    const genderChange = (e) =>{
        setGender(e.target.value);
        console.log(e.target.value);
    };

    const addressSearch = (e) =>{
    }

    return(
        <div className='join_container'>
            <div className='join_box'>
                <div className='join_content'>
                    <div className='join_input_row'>
                        <span className='join_title'>Id</span>
                        <span className='pull_input_span'>
                            <input type='text' required/>
                        </span>
                        <span className='join_error_text'>필수정보입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Pwd</span>
                        <span className='pull_input_span'>
                            <input type='password'/>
                        </span>
                        <span className='join_error_text'>8~16자 영문 대 소문자, 숫자 사용</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Pwd Check</span>
                        <span className='pull_input_span'>
                            <input type='password'/>
                        </span>
                        <span className='join_error_text'>비밀번호가 일치하지 않습니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Name</span>
                        <span className='pull_input_span'>
                            <input type='text'/>
                        </span>
                        <span className='join_error_text'>한글 혹은 영문 사용</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Birthday</span>
                        <div className='join_birthday_div'>
                            <span>
                                <input type='text' placeholder='연도(4자)'/> 
                            </span>
                            <span>
                                <input type='text' placeholder='월'/>
                            </span>
                            <span>
                                <input type='text' placeholder='일'/>
                            </span>
                        </div>
                        <span className='join_error_text'>잘못된 생일 정보 입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Gender</span>
                        <span className='pull_input_span'>
                            <select onChange={genderChange} value={gender}>
                                <option value="M">남자</option>
                                <option value="F">여자</option>
                            </select>
                        </span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Email</span>
                        <span className='pull_input_span'>
                            <input type='email'/>
                        </span>
                        <span className='join_error_text'>잘못된 이메일 정보 입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Address</span>
                        <div className='join_address'>
                            <span>
                                <input type='text'/>
                            </span>
                            <button onClick={addressSearch}>주소찾기</button>
                            <span className='pull_input_span_readonly'>
                                <input type='text' readOnly/> 
                            </span>
                            <span className='join_error_text'>주소가 입력되지 않았습니다</span>
                        </div>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Phone</span>
                        <span className='pull_input_span'>
                            <input type='text'/>    
                        </span>
                        <span className='join_error_text'>000-0000-0000 형식이여야 합니다</span>
                    </div>

                    <div className='join_button_row'>
                        <button>Join</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Join;