// 1. 함수선언
// 1) 선언적 함수
function test1(){
    alert('test1()함수 실행');
}

// 2) 익명함수
let btn1 = document.getElementById('btn1');

btn1.addEventListener('click', function(){
    alert('익명 함수 실행 (이벤트 핸들러를 통해 실행)');
});

// 3) 스스로 실행하는 함수
(
    function (a,b){
        document.getElementById('p1').innerHTML = `a : ${a}, b : ${b} ( 자동으로 혼자실행 )`;
    }(10,20)
);

// 2. 함수의 매개 변수
// 1) 매개 변수
let btn2 = document.getElementById('btn2');

btn2.addEventListener('click', () => {
    argTest('안녕하세요.', '반갑습니다');   // 매개변수가 2개여도 실행됨 '안녕하세요'만 실행
    // argTest(); // 매개변수가 없으면 undefind 
});

// 매개변수에 기본값을 지정하면 전달되는 매개값이 없을 경우 기본값으로 사용한다 (ES6부터 도입)
function argTest(value = '매개값 없음'){    
    alert(value);
}

// 2) arguments
let btn3 = document.getElementById('btn3');

btn3.addEventListener('click', () =>{
    let result = 0;

    result = sum(11,22,33,44);

    alert(`sum : ${result}`);
});

function sum() {
    let result = 0;

    for(let i=0; i <arguments.length; i++){
        result += arguments[i];
    }

    return result;
}

// 3. 함수의 리턴
// 1) 일반적인 값 리턴
let btn4 = document.getElementById('btn4');

btn4.addEventListener('click', () => {
    let random = ran();

    alert(`random : ${random}`);
});

function ran() {
    let random = parseInt(Math.random() * 100 + 1);

    return random;
}

// 2) 익명 함수를 리턴하는 함수
let btn5 = document.getElementById('btn5');

btn5.addEventListener('click', () =>{
    let func = funcTest();

    func();
});

function funcTest(){
    let name = '황인준';
    
    return function() {
        alert(`${name}님 환영합니다`);
    };
}

// 4. 내장 함수
// 1) eval() 함수
let btn6 = document.getElementById('btn6');

btn6.addEventListener('click', () => {
    let p = document.getElementById('p2');
    let calc = document.getElementById('calc');

    p.innerHTML = `실제 입력된 값 : ${calc.value} <br>`;
    p.innerHTML += `eval() 후 : ${eval(calc.value)}<br>`;
});


// 2) isInfinity()와 isNaN() 함수
let btn7 = document.getElementById('btn7');

btn7.addEventListener('click', ()=>{
    let p = document.getElementById('p3');
    let num1 = 10/0;
    let num2 = 10/ 'a';

    p.innerHTML = `10 / 0 : ${num1} <br>`;
    p.innerHTML += `10 / 'a' : ${num2} <br>`;
    p.innerHTML += `num1 == Infinity : ${num1 == -Infinity} <br>`;  // -를 붙여야함
    p.innerHTML += `num2 == NaN : ${num2 == NaN} <br>`;
    p.innerHTML += `isFinite(num1) : ${isFinite(num1)} <br>`;   // 유한한 함수인지 확인
    p.innerHTML += `isNaN(num2) : ${isNaN(num2)} <br>`; // NaN인지 확인
});
