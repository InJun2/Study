window.onload = () => {
    // window 객체
    // 1) window.open()
    let btn1 = document.getElementById('btn1');

    btn1.addEventListener('click', ()=>{
        // window.open(); // 새탭
        // window.open('http://www.naver.com'); // 열고자하는 URL
        // window.open('http://www.naver.com', 'naver');   // 창이름 전달

        // 특성의 경우 브라우저마다 다르게 동작하기 때문에 정상적으로 동작하는지 꼭 확인해야 한다.
        window.open('http://www.naver.com', 'naver', 'width=500', 'height=600','resizable=no');
    });

    // 2) 타이머 관련 메소드
    // window.setTimeout()
    let btn2 = document.getElementById('btn2');

    btn2.addEventListener('click', () => {
        let timerId = 0;
        let newWindow = window.open();  // 현재 오픈된 윈도우 객체를 넣어줌

        newWindow.alert('3초후에 이 페이지는 종료됩니다');

        // 일정 시간 후에 콜백 함수를 한번 실행
        window.setTimeout(()=>{
            newWindow.close();
        },3000);    // 시간은 밀리세컨드 단위

        console.log(timerId);

        // 타이머 id를 clearTimeout() 함수에 전달하면 해당 id의 타이머를 취소할 수 있다
        clearTimeout(timerId);
    });

    // window.setInterval()
    let btnStart = document.getElementById('btnStart');
    let btnStop = document.getElementById('btnStop');

    btnStart.addEventListener('click', () => {
        let timerId = 0;
        let area = document.getElementById('area1');

        window.setInterval(() =>{
            let date = new Date();

            area.innerHTML = `<span id='timer'> ${date.getHours()}, ${date.getMinutes()}, <span id='second'>${date.getSeconds()}</span></span>`;
        },1000);
    });

    btnStop.addEventListener('click', ()=> {
        clearInterval(timerId);
    });

    //  BOM 객체
    //  1) location 객체
    btn3.addEventListener('click', () =>{
        let area = document.getElementById('area3');

        area.innerHTML = '<h4>location 객체</h4>';

        for(const key in location){
            area.innerHTML += `key: ${key}, value: ${location[key]} <br><br>`;
        }
    });

    //  2) navigator 객체
    let btn4 = document.getElementById('btn4');

    btn4.addEventListener('click', () =>{
        let area = document.getElementById('area4');

        area.innerHTML = '<h4>navigator 객체</h4>';

        for(const key in navigator){
            area.innerHTML += `key: ${key}, value: ${location[key]} <br><br>`;
        }
    });

    // 3) screen 객체
    let btn5 = document.getElementById('btn5');

    btn5.addEventListener('click', () => {
        let area = document.getElementById('area5');

        area.innerHTML = '<h4>screen 객체</h4>';

        for (const key in screen) {
            area.innerHTML += `key: ${key}, value : ${screen[key]} <br><br>`;
        }
    });


};