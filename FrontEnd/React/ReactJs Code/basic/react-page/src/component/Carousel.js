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
            </Carousel.Item>
            <Carousel.Item>
                <img
                    style={{ height: "350px" }}
                    className="d-block w-100"
                    src="img/tower1.png"
                    alt="Second slide"
                />
            </Carousel.Item>
        </Carousel>
    );
}

export default CarouselUI;