window.onload = () => {
    // Object 객체
    let btn1 = document.getElementById('btn1');

    btn1.addEventListener('click', () => {
        let obj1 = {};
        let obj2 = {name: '홍길동', height: 165};
        let obj3 = new Object();

        console.log(obj1);
        console.log(obj2);
        console.log(obj3);
        
        console.log(obj1 instanceof Object);
        console.log(obj2 instanceof Object);
        console.log(obj3 instanceof Object);

        console.log('-----------------------------------------');
        // 매개값으로 전달되는 속성을 가지고 있는지 확인하는 메소드(ture/false 리턴)
        console.log(obj2.hasOwnProperty('name'));
        console.log(obj2.hasOwnProperty('height'));
        console.log(obj2.hasOwnProperty('name'));
    });

    // Number 객체
    let btn2 = document.getElementById('btn2');

    btn2.addEventListener('click', ()=>{
        let area = document.getElementById('area2');
        let num1 = 314592;
        let num2 = Number(3.141592);
        let num3 = new Number(3.141592);

        area.innerHTML = 'Number 객체 <br><br>';
        area.innerHTML += `num1 : ${num1}, <br> num1 instanceof Number : ${num1 instanceof Number}
            , <br> typeof(num1) : ${typeof(num1)} <br><br>`;
        area.innerHTML += `num2 : ${num1}, <br> num2 instanceof Number : ${num2 instanceof Number}
            , <br> typeof(num2) : ${typeof(num2)} <br><br>`;
        area.innerHTML += `num3 : ${num1}, <br> num3 instanceof Number : ${num3 instanceof Number}
            , <br> typeof(num3) : ${typeof(num3)} <br><br>`;

        area.innerHTML += `(314592).toExponential() : ${(314592).toExponential()}<br><br>`; // toExponential 메소드는 Number객체에 지원하는 메소드이지만 Number로 래핑함
        
        area.innerHTML += `num1.toExponential() : ${num1.toExponential()}, typeof(num1.toExponential()) : ${typeof(num1.toExponential())}<br><br>`;
        
        area.innerHTML += `num2.toFixed(2) : ${num2.toFixed(2)}, typeof(num2.toFixed(2)) : ${typeof(num2.toFixed(2))}<br><br>`;
        
        area.innerHTML += `num3.toPrecision(4) : ${num3.toPrecision(4)}, typeof(num3.toPrecision(4)) : ${typeof(num3.toPrecision(4))}<br><br>`; //마지막자리 반올림
        
    });

    // String 객체
    let btn3 = document.getElementById('btn3');

    btn3.addEventListener('click', () => {
        let area = document.getElementById('area3');
        let str1 = 'javascript';
        let str2 = new String('javascript');

        area.innerHTML = `str1 : ${str1}, typeof(str1) : ${typeof(str1)} <br>`;
        area.innerHTML += `str2 : ${str2}, typeof(str2) : ${typeof(str2)} <br><br>`;

        area.innerHTML += `str1.bord() : ${str1.bold()} <br>`;
        area.innerHTML += `str1.italics() : ${str1.italics()}<br>`;
        area.innerHTML += `str1.fontcolor('red') : ${str1.fontcolor('red')}<br>`;
        area.innerHTML += `str1.link('https://www.naver.com') : ${str1.link('https://www.naver.com')} <br>`;
    });

    // Date 객체
    let btn4 = document.getElementById('btn4');

    btn4.addEventListener('click', () => {
        let area = document.getElementById('area4');
        // Date 객체를 생성하는 방법
        let date1 = new Date();
        let date2 = new Date(2000);        // 밀리초 단위로 나타남 (1000 일시 1초)
        let date3 = new Date('2021/11/23/20:19:30');
        let date4 = new Date('2021-11-23T20:19:30');
        let date5 = new Date(2021,10,23,20,24,40);  // 월 같은경우에는 0부터 시작해서 -1을 해주어야함

        area.innerHTML = `Date 객체 <br><br>`;

        area.innerHTML += `date1 : ${date1} <br>`;
        area.innerHTML += `date2 : ${date2} <br>`;
        area.innerHTML += `date3 : ${date3} <br>`;
        area.innerHTML += `date4 : ${date4} <br>`;
        area.innerHTML += `date5 : ${date5} <br><br>`;
        
        // Date 객체의 메소드 호출
        area.innerHTML += `date1.getFullYear() : ${date1.getFullYear()} <br>`;
        area.innerHTML += `date1.getMonth() : ${date1.getMonth()+1 } <br>`;    // 월 같은경우 0부터 시작해서 +1을 해주어야 현재 달이 나옴
        area.innerHTML += `date1.getDate() : ${date1.getDate()}<br>`; 
        area.innerHTML += `date1.getDay() : ${date1.getDay()}<br>`;  // 0:일요일 1:월요일....
        area.innerHTML += `date1.getHours() : ${date1.getHours()}<br>`;
        area.innerHTML += `date1.getMinutes() : ${date1.getMinutes()}<br>`;
        area.innerHTML += `date1.getSeconds() : ${date1.getSeconds()}<br>`;
        area.innerHTML += `date1.getMilliseconds() : ${date1.getMilliseconds()}<br><br>`;

        // getTime() : 1970년 1월 1일 00시를 기준으로 현재 시간에 대한 밀리 세컨드 값을 반환한다.
        area.innerHTML += `date1.getTime() : ${date1.getTime()} <br>`;
        // 표준시와 Date 객체에 지정된 시간과 차이를 분 단위로 반환한다.
        area.innerHTML += `date1.getTimezoneOffset() : ${date1.getTimezoneOffset()} <br>`;
        area.innerHTML += `date1.toDateString() : ${date1.toDateString()} <br>`;
        area.innerHTML += `date1.toTimeString() : ${date1.toTimeString()} <br>`;
        area.innerHTML += `date1.toUTCString() : ${date1.toUTCString()} <br>`;  // 그리니치 표준시
        area.innerHTML += `date1.toISOString() : ${date1.toISOString()} <br>`;  // 표준시
        area.innerHTML += `date1.toLocaleTimeString() : ${date1.toLocaleTimeString()} <br>`;
        area.innerHTML += `date1.toLocaleTimeString('en-Us') : ${date1.toLocaleTimeString('en-Us')} <br>`;
        area.innerHTML += `date1.toLocaleString('en-Us') : ${date1.toLocaleString('en-Us')} <br>`;
        area.innerHTML += `date1.toLocaleDateString('en-Us') : ${date1.toLocaleDateString('en-Us')} <br>`;


    });
};