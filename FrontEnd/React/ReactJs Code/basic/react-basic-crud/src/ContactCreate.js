import React from 'react';
import PropTypes from 'prop-types';

export default class ContactCreate extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            name : '',
            phone : ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleChange(e){
        let nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }

    handleClick(){
        const contact = {
            name : this.state.name,
            phone: this.state.phone
        };

        this.props.onCreate(contact);   // 이게 어떻게 동작하는 건지 잘 모르겠음 ( 여기서 부모js 로 보내는것 같은데 )

        this.setState({
            name: '',
            phone: ''
        });
    }

    render(){
        return (
            <div>
                <h2>Create Contact</h2>
                <p>
                    <input type="text" name = "name" placeholder="name" value={this.state.name} onChange={this.handleChange}/>
                    <input type="text" name = "phone" placeholder="phone" value={this.state.phone} onChange={this.handleChange}/>
                </p>
                <button onClick={this.handleClick}>Create</button>
            </div>
        );
    }
}

ContactCreate.defaultProps = {
    onCreate: ()=> {console.error('onCreate not definded')}
};

ContactCreate.PropTypes = {
    onCreate: PropTypes.func
};
