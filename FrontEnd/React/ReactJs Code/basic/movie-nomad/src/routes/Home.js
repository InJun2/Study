import React, { useEffect, useState } from "react";
import axios from "axios";
import Movie from "../component/Movie";
import "../css/Home.css";

function Home() {
    const [isLoading, setIsLoading] = useState(true);
    const [movies, setMovies] = useState([]);

    useEffect(()=>{
        async function get(){
            const result = await axios.get(
                "https://yts-proxy.now.sh/list_movies.json?sort_by=rating"
                );
            if(isLoading) {
                setIsLoading(false);
                setMovies(result.data.data.movies);
            }
        }

        get();
    });


    return (
        <section className="container">
            {isLoading ? (
            <div className="loader">
                <span className="loader__text">Loading...</span>
            </div>
            ) : (
            <div className="movies">
                {movies.map(movie => (
                <Movie
                    key={movie.id}
                    id={movie.id}
                    year={movie.year}
                    title={movie.title}
                    summary={movie.summary}
                    poster={movie.medium_cover_image}
                    genres={movie.genres}
                />
                ))}
            </div>
            )}
        </section>
    );
}

export default Home;
