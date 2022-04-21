import React from 'react';
import proptypes from 'prop-types';     // props를 받아올경우 defaultProps와 Propstype 정의가 기본적. 해당 import로 Proptypes 정의 가능

class ContactDetail extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            isEdit: false,
            name: '',
            phone: ''
        };

        this.handleToggle = this.handleToggle.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleEdit = this.handleEdit.bind(this);
        this.handleKeyDown = this.handleKeyDown.bind(this);
    }

    handleToggle(){
        if(this.props.isSelected){
            if(!this.state.isEdit){
                this.setState({
                    name: this.props.contact.name,
                    phone: this.props.contact.phone
                });
            }
            if(this.state.isEdit){
                this.handleEdit();
            }
    
            this.setState({     // setState는 비동기라서 console.log가 먼저 실행된다고 함
                isEdit: ! this.state.isEdit
            });
            console.log(this.state.isEdit);
        }
    }

    handleChange(e){
        let nextState = {};
        nextState[e.target.name] = e.target.value;
        this.setState(nextState);
    }

    handleEdit(){
        this.props.onEdit(this.state.name, this.state.phone);
    }

    handleKeyDown(e){
        if(e.keyCode === 13){
            this.handleToggle();
        }
    }


    render(){
        const details = (
        <div>
            <p>{this.props.contact.name}</p>
            <p>{this.props.contact.phone}</p>
        </div>
        );

        const edit = (
            <div onKeyDown={this.handleKeyDown}>
                <p>
                    <input type="text" name = "name" placeholder="name" value={this.state.name} onChange={this.handleChange}/>
                </p>
                <p>
                    <input type="text" name = "phone" placeholder="phone" value={this.state.phone} onChange={this.handleChange}/>
                </p>
            </div>
        );

        const view = this.state.isEdit ? edit : details;
        
        const blank = (<div>Not Selected</div>);

        return (
            <div>
                <h2>Details</h2>
                {this.props.isSelected ? view : blank}
                <button onClick={this.handleToggle}>{this.state.isEdit? 'OK' : 'Edit'}</button>
                <button onClick={this.props.onRemove}>Remove</button>
            </div>
        );
    }
}

ContactDetail.defaultProps = {      // props가 없을경우
    contact:{
        name:'',
        phone:''
    },
    isSelected : false,
    onRemove : () => {console.error('onRemove not defineded');},
    onEdit : () => {console.error('onEdit not defineded');}
};

ContactDetail.proptypes = {         // props 타입 확인
    contact: {
        name: proptypes.node.isRequired,
        phone: proptypes.node.isRequired
    },
    isSelected : proptypes.bool,
    onRemove : proptypes.func,
    onEdit : proptypes.func
};

export default ContactDetail;