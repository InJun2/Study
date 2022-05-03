import React from "react";
import { Link } from "react-router-dom";    // a태그로 새로코침하지 않고 인터랙션
import "../css/Navigation.css";

function Navigation() {
    return (
        <div className="nav">
            <Link to="/">Home</Link>
            <Link 
                to={{           // 링크이동시 state에 존재하는 obj 형태로 props 전달
                    pathname: "/about",
                    // state: {    // es6 부터 Link to에서 state/props 전달 불가능
                    //     fromNavigation: true
                    // }
                }}
            >
                About
            </Link>
        </div>
    );
}

export default Navigation;