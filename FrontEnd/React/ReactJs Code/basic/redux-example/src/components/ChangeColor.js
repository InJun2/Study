import React, {useState} from 'react';
import {useDispatch} from 'react-redux';
import {changeColor} from '../redux/theme';

function ChangeColor(){
    const [color, setColor] = useState('');     // 기본값이 ''인 color state 생성 및 해당 변수 변경 함수로는 setColor 사용 선언
    const dispatch = useDispatch();             // redux 에서 액션을 통해 리듀서를 접근하기 위한 dispatch를 사용하기 위한 Hook?
    return (
        <div>
            <input
                type="text"
                onChange={e => {
                    setColor(e.target.value);   // useState를 통해 color를 변경할 수 있는 setColor 사용
                }}
            />
            <button onClick={() =>{
                dispatch(changeColor(color))    // color 파라미터를 가진 changeColor 액션을 통해 리듀서 접근
            }}>CHANGE COLOR</button>
        </div>
    )
}

export default ChangeColor