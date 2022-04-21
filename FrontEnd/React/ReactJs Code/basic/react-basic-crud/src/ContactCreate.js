import React from 'react';
import proptypes from 'prop-types';

export default class ContactCreate extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            name : '',
            phone : ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.handleKeyDown = this.handleKeyDown.bind(this);
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

        this.props.onCreate(contact);   // Contacts.js에서 함수를 받아와서 실행 ?

        this.setState({
            name: '',
            phone: ''
        });

        this.nameInput.focus(); // 클릭 후 해당 ref 위치(DOM)에 커서 동작
        console.log(this.nameInput.value);  // 헤당 ref를 지닌 DOM의 값 출력
    }

    handleKeyDown(e){
        if(e.keyCode === 13){
            this.handleClick();
        }
    }

    render(){
        return (
            <div onKeyDown={this.handleKeyDown}>
                <h2>Create Contact</h2>
                <p>
                    <input type="text" name = "name" placeholder="name" value={this.state.name} onChange={this.handleChange} ref={(ref) => {this.nameInput = ref }}/>   {/*ref를 arrow 함수로 지정, react에서 DOM 접근 하는 방법 */}
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

ContactCreate.proptypes = {
    onCreate: proptypes.func    // 함수 타입임을 정의
};
