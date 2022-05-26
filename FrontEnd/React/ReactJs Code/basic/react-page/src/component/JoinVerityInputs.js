import * as yup from 'yup';

export const verityIsJoinInputs = yup.object().shape({
    id: yup
        .string()
        .required("ID 입력은 필수 입니다")
        .min(6,"ID의 최소길이는 6자 입니다")
        .max(12,"ID의 최대길이는 12자 입니다")
        .matches(/^(?=.*[A-Za-z])[A-Za-z0-9]{6,12}/, {message: "영문자이거나 영문자,숫자 조합이여야 합니다"}),
    password: yup  
        .string()
        .required("비밀번호 입력은 필수 입니다")
        .min(8,"비밀번호의 최소길이는 8자 입니다")
        .max(16, "비밀번호의 최대길이는 16자 입니다")
        .matches(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/, {message: "영문자와 숫자와 특수문자를 조합해야 합니다"}),
    passwordCheck: yup
        .string()
        .required("비밀번호를 다시 입력해주세요")
        .oneOf([yup.ref('password')], "비밀번호가 일치하지 않습니다"),
    name: yup
        .string()
        .required("이름 입력은 필수입니다")
        .min(2, "이름의 최소길이는 2자 입니다")
        .max(5, "이름의 최대길이는 5자 입니다")
        .matches(/^[가-힣]{2,5}$/, {message: "잘못된 입력입니다"}),
    birthYear: yup 
        .string()
        .required("태어난 연도를 입력해주세요")
        .matches(/^[0-9]+$/g, { message: '숫자만 입력해주세요.' })
        .test(
            "birthYear",
            "잘못된 연도 입니다",
            value => value >new Date().getFullYear() -101 && value < new Date().getFullYear()-6
        ),
    birthMonth: yup 
        .string()
        .required("태어난 달을 입력해주세요")
        .matches(/^[0-9]+$/g, { message: '숫자만 입력해주세요.' })
        .test(
            "birthMonth",
            "잘못된 월 입니다",
            value => value >=1 && value<=12
        ),
    birthDay: yup 
        .string()
        .required("태어난 일를 입력해주세요")
        .matches(/^[0-9]+$/g, { message: '숫자만 입력해주세요.' })
        .test(
            "birthDay",
            "테스트",
            value=> {
                const year = (yup.ref('birthYear'));
                const month = (yup.ref('birthMonth'));
                console.log(year, month)

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
            }),
    email: yup 
        .string()
        .required("이메일을 입력해주세요")
        .email("잘못된 이메일 양식입니다"),
    gender: yup
        .string()
        .matches(/^[MF]+$/g, { message: "잘못된 입력입니다"}),
    
    addressDetail: yup
        .string(),
    phone: yup
        .string()
        .required("휴대폰 번호를 입력해주세요")
        .min(12, "잘못된 휴대폰 번호 입니다")
        .max(13, "잘못된 휴대폰 번호 입니다")
        .matches(/^01([0|1|6|7|8|9])*-([0-9]{3,4})*-([0-9]{4})$/, {message: "잘못된 핸드폰번호 입니다"})
    
})

        // required: { value: true, message: "태어난 연도를 입력해주세요"},
        // validate: { checkBirthYear :value => { return (value>new Date().getFullYear()-101 && value < new Date().getFullYear()-8) ||"잘못된 생년 정보 입니다"},
        //             checkInteger: value => checkInteger(value) ||"잘못된 생년 정보 입니다",
        //             checkBirthAll: () => verityBirthYear() || "잘못된 생일 정보입니다"}
        // required: { value: true, message: "태어난 월을 입력해주세요"},
        // validate: { checkBirthMonth :value => {return (value>=1 && value<=12) || "잘못된 생월 정보 입니다"},
        //             checkInteger: value => checkInteger(value) ||"잘못된 생월 정보 입니다",
        //             checkBirthAll: () => verityBirthMonth() || "잘못된 생일 정보 입니다"} 
        // required: { value: true, message: "태어난 일을 입력해주세요"},
        // validate: { checkBirthDay :value => {return birthDayValidate(value) || "잘못된 생일 정보 입니다"},
        //             checkInteger: value => checkInteger(value) ||"잘못된 생일 정보 입니다"}


// const verityBirthMonth = () => {
//     const year = getValues("birthYear");
//     const day = getValues("birthDay");
//     if(year!=="" && day!==""){
//         return birthDayValidate(day);
//     }else
//         return true;
// }

// const verityBirthYear = () => {
//     const month = getValues("birthYear");
//     const day = getValues("birthDay");
//     if(month!=="" && day!==""){
//         return birthDayValidate(day);
//     }else
//         return true;
// }