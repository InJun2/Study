import React, { useEffect, useRef, useState } from 'react';
import PopupPostCode from '../component/DaumAddress';
import { useForm } from 'react-hook-form';
import PopupDom from '../component/PopupDom';
import '../css/join.css';

function Join(){
    const { register, handleSubmit, getValues, formState: { errors } } = useForm();
    const onSubmit = data => console.log(data); // 모든 input 유효성 검사완료시 해당 데이터 확인 후 join 진행 예정

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
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className='join_input_row'>
                            <span className='join_title'>Id</span>
                            <span className='pull_input_span'>
                                <input type='text' {...register("id",{
                                    required: {value: true, message: "ID 입력은 필수 입니다"},
                                    maxLength: {value: 12, message: "ID의 최대길이는 12자 입니다"},
                                    minLength : {value: 6, message: "ID의 최소길이는 6자 입니다" },
                                    pattern: {value:/^[A-Za-z0-9]{6,12}/, message: "영문자와 숫자를 조합해야 합니다"}
                                })} placeholder="영문자 숫자를 포함한 6~12자 입력"/>
                            </span>
                            {errors.id && <span className='join_error_text'>{errors.id.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Pwd</span>
                            <span className='pull_input_span'>
                                <input type='password' {...register("password",{
                                    required: {value: true, message: "PWD 입력은 필수 입니다"},
                                    maxLength: {value: 16, message: "PWD의 최대길이는 16자 입니다"},
                                    minLength : {value: 8, message: "PWD의 최소길이는 8자 입니다" },
                                    pattern: {value:/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/, message: "영문자와 숫자와 특수문자를 조합해야 합니다"}
                                })} placeholder="영문자 숫자 특수문자를 포함한 8~16자 입력"/>
                            </span>
                            {errors.password && <span className='join_error_text'>{errors.password.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Pwd Check</span>
                            <span className='pull_input_span'>
                            <input type='password' {...register("passwordCheck",{
                                required: {value: true, message: "PWD를 다시 입력해주세요"},
                                validate: {passwordChecked: value =>
                                    { const {password} =getValues(); return password === value || "PWD가 동일하지 않습니다";}
                                }
                            })} placeholder="비번 재입력"/>
                            </span>
                            {errors.passwordCheck && <span className='join_error_text'>{errors.passwordCheck.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Name</span>
                            <span className='pull_input_span'>
                            <input type='text' {...register("name",{
                                    required: {value: true, message: "Name 입력은 필수 입니다"},
                                    maxLength: {value: 5, message: "Name의 최대길이는 5자 입니다"},
                                    minLength : {value: 2, message: "Name의 최소길이는 2자 입니다"},
                                    pattern: {value:/^[가-힣]{2,5}$/, message: "잘못된 입력입니다"}
                                })} placeholder="한글 2자~5자 입력"/>
                            </span>
                            {errors.name && <span className='join_error_text'>{errors.name.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Birthday</span>
                            <div className='join_birthday_div'>
                                <span>
                                    <input type='number' min={1922} max={2022} placeholder='연도(4자)'/> 
                                </span>
                                <span>
                                    <input type='number' min={1} max={12} placeholder='월'/>
                                </span>
                                <span>
                                    <input type='number' min={1} max={31} placeholder='일'/>
                                </span>
                            </div>
                            <span className='join_error_text'>잘못된 생일 정보 입니다</span>
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Gender</span>
                            <span className='pull_input_span'>
                                <select>
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
                                <span className='input_span_readonly'>
                                    <input type='text' ref={addressInput} readOnly/>
                                </span>
                                <button type="button" onClick={openAddress}>주소찾기</button>
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
                                    <input type='text'/> 
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
                            <button type='submit'>Join</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Join;