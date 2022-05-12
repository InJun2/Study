import React, {useState, useEffect} from 'react';
import axios from 'axios';

import Post from '../component/Post';
import '../css/posts.css';

export default function Posts(){
    const [load, setLoad] = useState(true);
    const [posts, setPost] = useState([]);

    useEffect (()=>{
        axios.get("https://jsonplaceholder.typicode.com/posts")
            .then((response)=> {
                setLoad(false);
                setPost(response.data);
            })
            .catch((err)=> {throw new Error(err)})
    }, [])

    return(
        <div className='post_container'>
            <h1>Post Infomation</h1>

            {load?
                <div className='load'>post load..</div>
            :
                <div className='post_boxs'>
                        {posts.map((post)=>(
                            <React.Fragment key={post.id}>
                                <Post post={post}/>
                            </React.Fragment>
                        ))}
                </div>
            }
            </div>
    );
}