import axios from 'axios';
import React, { useEffect, useState } from 'react';
import '../css/board_table.css';
import { Table } from 'react-bootstrap';

function LoadBoard(){
    const [load, setLoad] = useState(true);
    const [boards, setBoards] = useState([]);

    // board api는 spring boot를 사용한 ( https://github.com/InJun2/Study/tree/main/Spring/Springboot/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/boardapi/apiserver ) 프로젝트 사용
    useEffect(()=>{
        axios.get("https://localhost:8446/board/list")  //  api 서버 컨트롤러에 @CrossOrigin 를 이용해 cors 헤더 설정
            .then((response) => {
                setLoad(false);
                setBoards((response.data).reverse());   // 최신 순의 게시판 정렬을 위해 배열 reverse() 형태로 저장
            })
            .catch((err)=> {throw new Error(err)})
    }, [])

    return(
    <div className='board_container'>
        {load?
            <div className='spinner-border'></div>:
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th><input type="checkbox"/></th>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일자</th>
                    </tr>
                </thead>
                <tbody>
                    {boards.map((row)=>(
                        <React.Fragment key={row.boardNo}>
                            <tr>
                                <td><input type="checkbox"/></td>
                                <td>{row.boardNo}</td>
                                <td>{row.boardTitle}</td>
                                <td>{row.boardWriter}</td>
                                <td>{row.boardDate}</td>
                            </tr>
                        </React.Fragment>
                    ))}
                </tbody>
            </Table>
        }
    </div>
    );
}

export default LoadBoard;