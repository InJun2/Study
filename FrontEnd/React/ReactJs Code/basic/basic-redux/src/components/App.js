import React, {Component} from 'react';
import propType from 'prop-types';
import Counter from './Counter';

const propTypes = {
    number: propType.number
};

const defaultProps = {
    number: -10
};

class App extends Component{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <Counter/>
            </div>
        );
    }
}

App.propTypes = propTypes;
App.defaultProps = defaultProps;

export default App;