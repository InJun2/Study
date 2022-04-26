import React, {Component} from 'react';
import propType from 'prop-types';

const propTypes = {
    number: propType.number
};

const defaultProps = {
    number: -1
};

class Value extends Component{

    render(){
        return(
            <div>
                <h2>{this.props.number}</h2>
            </div>
        );
    }
}

Value.propTypes = propTypes;
Value.defaultProps = defaultProps;

export default Value;