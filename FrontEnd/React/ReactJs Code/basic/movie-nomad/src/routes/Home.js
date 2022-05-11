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
                }).catch((err)=>{
                    throw new Error(err);
                });
        }
        get();
    }, []);

    return (
        <section className="container">
            {isLoading ? (
            <div className="loader">
                <span className="loader__text">Loading...</span>
            </div>
            ) : (
            <div className="movies">
                {movies.map(movie => (
                    <movieContext.Provider key={movie.id} value={movie}>
                        <Movie/>
                    </movieContext.Provider>
                ))}
            </div>
            )}
        </section>
    );
}

export default Home;