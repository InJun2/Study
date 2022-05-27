import React, { useEffect, useRef, useState } from 'react';
import PopupPostCode from '../component/DaumAddress';
import { useForm } from 'react-hook-form';
import PopupDom from '../component/PopupDom';
import { verityIsJoinInputs } from '../component/JoinVerityInputs';
import { yupResolver } from '@hookform/resolvers/yup';
import '../css/join.css';

function Join(){
    const { register, handleSubmit, formState: { errors } } = useForm({resolver: yupResolver(verityIsJoinInputs), mode: "onBlur"});
    const onSubmit = data => address&&console.log(data); // 모든 input 유효성 검사완료시 해당 데이터 확인 후 join 진행 예정

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

    const autoHyphen = (e) =>{
        e.target.value = e.target.value.replace(/[^0-9]/g, '')
        .replace(/^(\d{3})(\d{3,4})(\d{4})$/g, "$1-$2-$3");
    }

    const numberMaxLength = (e) =>{
        if(e.target.value.length > e.target.maxLength){
            e.target.value = e.target.value.slice(0, e.target.maxLength);
        }
    }

    return(
        <div className='join_container'>
            <div className='join_box'>
                <div className='join_content'>
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className='join_input_row'>
                            <span className='join_title'>Id</span>
                            <span className='pull_input_span'>
                                <input type='text' {...register("id")} placeholder="영문자 숫자를 포함한 6~12자 입력"/>
                            </span>
                            {errors.id && <span className='join_error_text'>{errors.id.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Pwd</span>
                            <span className='pull_input_span'>
                                <input type='password' {...register("password")} placeholder="영문자 숫자 특수문자를 포함한 8~16자 입력"/>
                            </span>
                            {errors.password && <span className='join_error_text'>{errors.password.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Pwd Check</span>
                            <span className='pull_input_span'>
                                <input type='password' {...register("passwordCheck")} placeholder="비번 재입력"/>
                            </span>
                            {errors.passwordCheck && <span className='join_error_text'>{errors.passwordCheck.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Name</span>
                            <span className='pull_input_span'>
                                <input type='text' {...register("name")} placeholder="한글 2자~5자 입력"/>
                            </span>
                            {errors.name && <span className='join_error_text'>{errors.name.message}</span>}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Birthday</span>
                            <div className='join_birthday_div'>
                                <span>
                                    <input type='number' placeholder='연도(4자)' maxLength="4" onInput={numberMaxLength} {...register("birthYear")}/> 
                                </span>
                                <span>
                                    <input type='number' placeholder='월' maxLength="2" onInput={numberMaxLength} {...register("birthMonth")}/> 
                                </span>
                                <span>
                                    <input type='number' placeholder='일'  maxLength="2" onInput={numberMaxLength} {...register("birthDay")}/> 
                                </span>
                            </div>
                            {(errors.birthYear && <span className='join_error_text'>{errors.birthYear.message}</span>) ||
                            (errors.birthMonth && <span className='join_error_text'>{errors.birthMonth.message}</span>) ||
                            (errors.birthDay && <span className='join_error_text'>{errors.birthDay.message}</span>)}
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Gender</span>
                            <span className='pull_input_span'>
                                <select {...register("gender")}>
                                    <option value="M">남자</option>
                                    <option value="F">여자</option>
                                </select>
                            </span>
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Email</span>
                            <span className='pull_input_span'>
                                <input type='text' {...register("email")}/>
                            </span>
                            {errors.email && <span className='join_error_text'>{errors.email.message}</span>}
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
                                        )
                                    }
                                </div>
                                <span className='join_title'>Detail Address</span>
                                <span className='pull_input_span'>
                                    <input type='text' {...register("addressDetail")}/> 
                                </span>
                                {address ==="" &&<span className='join_error_text'>주소찾기를 실행해주세요</span>}
                            </div>
                        </div>

                        <div className='join_input_row'>
                            <span className='join_title'>Phone</span>
                            <span className='pull_input_span'>
                                <input type='text' {...register("phone")} onInput={autoHyphen} maxLength="13"/>
                            </span>
                            {errors.phone && <span className='join_error_text'>{errors.phone.message}</span>}
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