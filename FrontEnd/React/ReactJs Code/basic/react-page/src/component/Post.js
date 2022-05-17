import React, { useEffect, useState } from 'react';
// import { Link } from 'react-router-dom';

import '../css/post.css';

export default function Post(props){
    const initialState = {
        id:"",
        userId:"",
        title:"",
        body:""
    }

    const [post, setPost] = useState(initialState);

    useEffect(()=>{
        setPost(props.post)
    },[props.post])

    return(
            <div className='post_box'>
                    <h3>{post.title}</h3>
                    <p>{post.body}</p>
            </div>
    );
}