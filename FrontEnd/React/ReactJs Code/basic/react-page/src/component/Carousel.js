import React from 'react';
import { Carousel } from "react-bootstrap";

function CarouselUI(){
    return(
        <Carousel fade>
            <Carousel.Item>
                <img
                    style={{ height: "350px" }}
                    className="d-block w-100"
                    src="img/river1.png"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <h3 style={{fontFamily:"BMHA", color:"black"}}>First img</h3>
                    <p style={{fontFamily:"BMHA", color:"black"}}>this is river</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    style={{ height: "350px" }}
                    className="d-block w-100"
                    src="img/tower1.png"
                    alt="Second slide"
                />
                <Carousel.Caption>
                    <h3 style={{fontFamily:"BMHA"}}>Second img</h3>
                    <p style={{fontFamily:"BMHA"}}>this is tower</p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
}

export default CarouselUI;