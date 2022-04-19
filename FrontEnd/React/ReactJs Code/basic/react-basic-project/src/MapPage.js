import React, { Component } from 'react';
import Header from './Header';
import Map from './Map';
import Footer from './Footer';

class MapPage extends Component{
    render(){
        return (
            <div>
                <Header/>
                <Map/>
                <Footer/>
            </div>
        );
    }
}

export default MapPage;