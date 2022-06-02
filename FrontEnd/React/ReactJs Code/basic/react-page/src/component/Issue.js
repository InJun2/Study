import React from 'react';

import '../css/issue.css';

export default function Issue(props){
        return(
                <div className='issue_box'>
                        <h3>{props.title}</h3>
                        <p>{props.body}</p>
                </div>
        );
}