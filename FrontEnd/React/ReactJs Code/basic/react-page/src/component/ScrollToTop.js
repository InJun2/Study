import { useEffect } from "react";
import { useLocation } from "react-router-dom";

export default function ScrollToTop() {     // link to 로 route path로 이동 시 스크롤 맨위로 올리게 하기 위함
    const { pathname } = useLocation();

    useEffect(() => {
        window.scrollTo(0, 0);
    }, [pathname]);

    return null;
};