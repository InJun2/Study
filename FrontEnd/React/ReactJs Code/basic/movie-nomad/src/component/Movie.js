import React, {useContext} from "react";
import { Link } from "react-router-dom";
import { movieContext } from "../routes/Home";
import "../css/Movie.css";

function Movie() {
    const movie = useContext(movieContext);     // Home.js에서 생성해둔 movieContext에서 값 가져옴

    const saveStateValues = (movie) => {
        localStorage.setItem(movie.id, JSON.stringify({    // localStorage가 누적됨, useContext에 담아둔 것을 localState에 저장
            "id":movie.id,
            "year":movie.year,
            "title":movie.title,
            "summary":movie.summary,
            "poster":movie.poster,
            "genres":movie.genres
        }));
    };
    

    return (
        <div className="movie">
            <Link
                to={{           // Detail에 props 정보 전달
                pathname: `/movie/${movie.id}`,
                // state: {     // v6부터 Link to로 state 전달 불가능, 매개 장치 사용해야함 ( localStorage 사용 )
                //     year,
                //     title,
                //     summary,
                //     poster,
                //     genres
                // }    
                }}
                onClick={() => saveStateValues(movie)}
            >
                <img src={movie.poster} alt={movie.title} title={movie.title} />
                <div className="movie__data">
                    <h3 className="movie__title">{movie.title}</h3>
                    <h5 className="movie__year">{movie.year}</h5>
                    <ul className="movie__genres">
                        {movie.genres.map((genre, index) => (
                        <li key={index} className="genres__genre">
                            {genre}
                        </li>
                        ))}
                    </ul>
                    <p className="movie__summary">{movie.summary.slice(0, 180)}...</p>  
                </div>
            </Link>
        </div>
    );
}

export default Movie;
