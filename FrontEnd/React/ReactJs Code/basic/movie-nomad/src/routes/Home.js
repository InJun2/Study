import React, { createContext, useEffect, useState } from "react";
import axios from "axios";
import Movie from "../component/Movie";
import "../css/Home.css";

export const movieContext = createContext();

function Home() {
    const [isLoading, setIsLoading] = useState(true);
    const [movies, setMovies] = useState([]);

    useEffect(()=>{
        async function get(){
            await axios.get(
                "https://yts-proxy.now.sh/list_movies.json?sort_by=rating"
                ).then((response)=>{
                    console.log("success get response movies info");
                    setIsLoading(false);
                    setMovies(response.data.data.movies);
                }).catch((ex)=>{
                    throw new Error(ex);
                });
        }
        get();
    }, []);


    const movieObject = (movie) =>{
        const movieObj = {
            id: movie.id,
            year: movie.year,
            title: movie.title,
            summary: movie.summary,
            poster: movie.medium_cover_image,
            genres: movie.genres
        };

        return movieObj;
    }

    return (
        <section className="container">
            {isLoading ? (
            <div className="loader">
                <span className="loader__text">Loading...</span>
            </div>
            ) : (
            <div className="movies">
                {movies.map(movie => (
                    <movieContext.Provider key={movie.id} value={movieObject(movie)}>
                        <Movie/>
                    </movieContext.Provider>
                ))}
            </div>
            )}
        </section>
    );
}

export default Home;
