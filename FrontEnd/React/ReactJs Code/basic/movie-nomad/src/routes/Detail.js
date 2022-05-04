import React from "react";
import { useParams } from "react-router-dom";

function Detail(){
    const {id} = useParams();       // http 메소드 get으로 받아온 파라미터 id에 저장
    const value = JSON.parse(localStorage.getItem(id)); // 해당 id 를 key로 가진 localStroage의 값 JSON 형태로 받아옴

    if (id!=null) {
        return <span>{value.title}</span>;
    } else {
        return <span>잘못된 접근입니다.</span>;
    }
}

export default Detail;
