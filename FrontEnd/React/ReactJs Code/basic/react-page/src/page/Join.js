import React, { useEffect, useRef, useState } from 'react';
import PopupPostCode from '../component/DaumAddress';
import { IdValidation } from '../component/JoinValidation';
import PopupDom from '../component/PopupDom';
import '../css/join.css';

function Join(){
    
    const [inputs, setInputs] = useState({
        id: '',
        password: '',
        passwordCheck: '',
        name: '',
        birthYear: '',
        birthMonth: '',
        birthDay: '',
        gender: '',
        detailAddress: '',
        email: '',
        phone: ''
    });

    const { id, password, passwordCheck, name, birthYear, birthMonth, birthDay, gender, detailAddress, email, phone } = inputs;    // 비구조화 할당 ( address 제외)
    
    const onChange = (e) =>{
        const { value, name } = e.target;
        setInputs({
            ...inputs,
            [name]:value
        });
    };

    const [isBooleans, setIsBooleans] = useState({
        isId: false,
        isPassword: false,
        isPasswordCheck: false,
        isName: false,
        isBirthYear: false,
        isBirthMonth: false,
        isBirthDay: false,
        isGender: false,
        isAddress: false,
        isEmail: false,
        isPhone: false
    })

    const { isId, isPassword, isPasswordCheck, isName, isBirthYear, isBirthMonth, isBirthDay, isGender, isAddress, isEmail, isPhone} = isBooleans;

    const [address, setAddress] = useState(""); 
    const [addressPopup, setAddressPopup] = useState(false);

    const addressInput = useRef(""); 

    useEffect(()=>{
        addressInput.current.value = address;
    }, [address])

    const openAddress = () => {
        setAddressPopup(true)
    }
    const closeAddress = () => {
        setAddressPopup(false)
    }

    return(
        <div className='join_container'>
            <div className='join_box'>
                <div className='join_content'>
                    <div className='join_input_row'>
                        <span className='join_title'>Id</span>
                        <span className='pull_input_span'>
                            <input type='text' onChange={onChange} name='id' value={id} onBlur={IdValidation}/>
                        </span>
                        <span className='join_error_text'>필수정보입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Pwd</span>
                        <span className='pull_input_span'>
                            <input type='password' onChange={onChange} name='password' value={password}/>
                        </span>
                        <span className='join_error_text'>8~16자 영문 대 소문자, 숫자 사용</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Pwd Check</span>
                        <span className='pull_input_span'>
                            <input type='password' onChange={onChange} name='passwordCheck' value={passwordCheck}/>
                        </span>
                        <span className='join_error_text'>비밀번호가 일치하지 않습니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Name</span>
                        <span className='pull_input_span'>
                            <input type='text' onChange={onChange} name='name' value={name}/>
                        </span>
                        <span className='join_error_text'>한글 혹은 영문 사용</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Birthday</span>
                        <div className='join_birthday_div'>
                            <span>
                                <input type='text' onChange={onChange} name='birthYear' value={birthYear} placeholder='연도(4자)'/> 
                            </span>
                            <span>
                                <input type='text' onChange={onChange} name='birthMonth' value={birthMonth} placeholder='월'/>
                            </span>
                            <span>
                                <input type='text' onChange={onChange} name='birthDay' value={birthDay} placeholder='일'/>
                            </span>
                        </div>
                        <span className='join_error_text'>잘못된 생일 정보 입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Gender</span>
                        <span className='pull_input_span'>
                            <select onChange={onChange} name='gender' value={gender}>
                                <option value="M">남자</option>
                                <option value="F">여자</option>
                            </select>
                        </span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Email</span>
                        <span className='pull_input_span'>
                            <input type='email' onChange={onChange} name='email' value={email}/>
                        </span>
                        <span className='join_error_text'>잘못된 이메일 정보 입니다</span>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Address</span>
                        <div className='join_address'>
                            <span className='input_span_readonly'>
                                <input type='text' ref={addressInput} readOnly/>
                            </span>
                            <button onClick={openAddress}>주소찾기</button>
                            <div id="popupDom" className='addressPopup'>
                                {addressPopup && 
                                    (
                                        <PopupDom>
                                            <PopupPostCode onClose={closeAddress} setAddress={setAddress}/>
                                        </PopupDom>
                                    )}
                            </div>
                            <span className='join_title'>Detail Address</span>
                            <span className='pull_input_span'>
                                <input type='text' onChange={onChange} name='detailAddress' value={detailAddress}/> 
                            </span>
                            <span className='join_error_text'>주소가 입력되지 않았습니다</span>
                        </div>
                    </div>

                    <div className='join_input_row'>
                        <span className='join_title'>Phone</span>
                        <span className='pull_input_span'>
                            <input type='text' onChange={onChange} name='phone' value={phone}/>    
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