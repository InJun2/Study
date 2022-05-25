import React, { useEffect, useRef, useState } from 'react';
import PopupPostCode from '../component/DaumAddress';
import { useForm } from 'react-hook-form';
import PopupDom from '../component/PopupDom';
import '../css/join.css';

function Join(){
    const { register, handleSubmit, getValues, formState: { errors } } = useForm({mode: "onBlur"});
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

    const getData = (value) =>{
        const getValue = getValues(value);
        return getValue;
    }

    const numberMaxLength = (e) =>{
        if(e.target.value.length > e.target.maxLength){
            e.target.value = e.target.value.slice(0, e.target.maxLength);
        }
    }

    const birthDayValidate = (value) =>{
        const year = parseInt(getData("birthYear"));
        const month = parseInt(getData("birthMonth"));

        if(month === 2){
            if((year % 4 === 0) && (year % 100 !== 0 || year % 400 === 0))
                return value<=29 && value>=1
            else
                return value<=28 && value>=1
        }
        else if(month ===4 || month ===6 || month ===9 || month===11){
            return value<=30 && value>=1
        }
        else{
            return value<=31 && value>=1
        }
    }

    const checkInteger = (value) =>{
        return value %1 ===0;
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
                                    pattern: {value:/^(?=.*[A-Za-z])[A-Za-z0-9]{6,12}/, message: "영문자이거나 영문자,숫자 조합이여야 합니다"}
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
                                    { return getData("password") === value || "PWD가 동일하지 않습니다";}
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
                                    <input type='number' placeholder='연도(4자)' maxLength="4" onInput={numberMaxLength} {...register("birthYear",{
                                        required: { value: true, message: "태어난 연도를 입력해주세요"},
                                        validate: { checkBirthYear :value => { return (value>new Date().getFullYear()-101 && value < new Date().getFullYear()-8) ||"잘못된 생년 정보 입니다"},
                                                    checkInteger: value => checkInteger(value) ||"잘못된 생년 정보 입니다"}
                                    })}/> 
                                </span>
                                <span>
                                    <input type='number' placeholder='월' maxLength="2" onInput={numberMaxLength} {...register("birthMonth",{
                                        required: { value: true, message: "태어난 월을 입력해주세요"},
                                        validate: { checkBirthMonth :value => {return (value>=1 && value<=12) || "잘못된 생월 정보 입니다"},
                                                    checkInteger: value => checkInteger(value) ||"잘못된 생월 정보 입니다"}
                                    })}/> 
                                </span>
                                <span>
                                    <input type='number' placeholder='일'  maxLength="2" onInput={numberMaxLength} {...register("birthDay",{
                                        required: { value: true, message: "테어난 일을 입력해주세요"},
                                        validate: { checkBirthDay :value => {return birthDayValidate(value) || "잘못된 생일 정보 입니다"},
                                                    checkInteger: value => checkInteger(value) ||"잘못된 생일 정보 입니다"}
                                    })}/> 
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
                            <input type='text' {...register("email",{
                                    required: {value: true, message: "Email이 입력되지 않았습니다"},
                                    pattern: {value:/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/, message: "잘못된 email 포맷입니다"}
                                })}/>
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
                                        )}
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
                                <input type='text' {...register("phone",{
                                        required: {value: true, message: "휴대폰 번호를 입력해주세요"},
                                        pattern: {value:/^01([0|1|6|7|8|9])*-([0-9]{3,4})*-([0-9]{4})$/, message: "잘못된 핸드폰번호 입니다"}
                                    })} onInput={autoHyphen} maxLength="13"/>
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