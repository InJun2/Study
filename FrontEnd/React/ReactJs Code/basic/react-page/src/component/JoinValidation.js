import React from 'react';
import styled from 'styled-components';

const none_text = styled.span`
    display: none;
`;

const join_error_text = styled.span`
    color: rgb(245, 62, 62);
    font-size: 15px;
    font-family: "BMHA";
    display: block;
    `;

const join_success_text = styled.span`
    color: rgb(88, 247, 67);
    font-size: 15px;
    font-family: "BMHA";
    display: block;
    `;

export const IdValidation = (e) =>{
    console.log(e.target.value);
}

export function PwdValidation(){
    return(
        <span>
            
        </span>
    );
}


export function PwdCheckValidation(){
    return(
        <span>
            
        </span>
    );
}


export function NameValidation(){
    return(
        <span>
            
        </span>
    );
}


export function BirthValidation(){
    return(
        <span>
            
        </span>
    );
}


export function GenderValidation(){
    return(
        <span>
            
        </span>
    );
}


export function EmailValidation(){
    return(
        <span>
            
        </span>
    );
}


export function PhoneValidation(){
    return(
        <span>
            
        </span>
    );
}
