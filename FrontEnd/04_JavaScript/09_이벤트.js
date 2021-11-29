// 1. 이벤트 모델의 종류
// 1) 고전 이벤트 모델
let btn1 = document.getElementById('btn1');
let btn2 = document.getElementById('btn2');

btn1.onclick = function(){
    alert('btn1이 클릭되었습니다');

    console.log(this);  // 버튼 정보
};

btn2.onclick = (event) => {
    alert('btn2이 클릭되었습니다');

    console.log(this);  // window 속성 정보
    console.timeLog(event.target);
};

// 3) 표준 이벤트 모델
let btn3 = document.getElementById('btn3');

btn3.addEventListener('click', clickEventHandler);  // 이미만들어진 콜백함수를 호출할때 괄호를 제외하고 써야함

btn3.addEventListener('mouseenter', function() {    // 클릭한 요소 가르킴
    this.style.backgroundColor = 'red'; 
});
btn3.addEventListener('mouseleave', (event) => {    // 
    event.target.style.backgroundColor = 'green';
});

function clickEventHandler(){
    alert('표준 이벤트 모델');
}

// 2. 이벤트가 발생한 요소 객체에 접근하는 방법
// 1) 고전 이벤트 방식
let btn4 = document.getElementById('btn4');

// btn4.onclick = function(event){
//     console.log(event.target);
//     console.log(window.event.target);
//     console.log(this);
// };

btn4.onclick = (event) =>{
    console.log(event.target);
    console.log(window.event.target);
    // console.log(this);  // window 객체를 가르킨다
};

// 2) 인라인 이벤트 방식
function test(event){
    // console.log(event);  // 매개값으로 event 객체를 가져올 수 없다
    console.log(window.event.target);
    // console.log(this);  // window 객체를 가리킨다
};

// 3) 표준 이벤트 방식
let btn5 = document.getElementById('btn5');

// btn5.addEventListener('click', function(event){
//     console.log(event.target);
//     console.log(window.event.target);
//     console.log(this);
// });

btn5.addEventListener('click', (event) =>{
    console.log(event.target);
    console.log(window.event.target);
    // console.log(this);   // window 객체를 가리킨다
});

// 3. 태그별 기본적으로 가지고 있는 이벤트 제거
// 1) 기본 이벤트 제거 1
function passwordCheck(){
    let pass1 = document.getElementById('pass1').value;
    let pass2 = document.getElementById('pass2').value;

    if (pass1 !== pass2){
        alert('비밀번호가 일지하지 않습니다');
        return false;
    }
}

// 1) 기본 이벤트 제거 2
let submit = document.getElementById('submit');

// submit.onclick = () =>{
//     alert('아이디를 정상적으로 입력해주세요');

//     return false;
// };

submit.addEventListener('click', (event)=>{
    let userId = document.getElementById('userId').value;
    let regExp = /^[a-zA-Z0-9]{5,12}$/;
    if(!regExp.test(userId)){
    alert('아이디를 정상적으로 입력해주세요');

    // 표준 이벤트 방식에서는 아래와 같이 기본 이벤트를 제거해야 한다
    event.preventDefault();
    }
});