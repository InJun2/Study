import React from "react";
import { useParams } from "react-router-dom";

function Detail(){
    const {id} = useParams();
    const value = JSON.parse(localStorage.getItem(id));

    if (id!=null) {
        return <span>{value.title}</span>;
    } else {
        return <span>잘못된 접근입니다.</span>;
    }
}

export default Detail;
