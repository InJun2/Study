import React from "react";
import ContactInfo from "./ContactInfo";
import ContactDetail from "./ContactDetails";
import update from 'react-addons-update';   // immutable.js : 객체나 배열을 더 쉽게 수정
import ContactCreate from "./ContactCreate";

export default class Contact extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            selectedKey: -1,
            keyword : '',
            contactData: [{
                name:'Abet',
                phone: '010-0000-0001'
            }, {
                name:'Betty',
                phone: '010-0000-0002'
            }, {
                name:'Charlie',
                phone: '010-0000-0003'
            }, {
                name:'David',
                phone: '010-0000-0004'
            }]
        };

        this.handleChange = this.handleChange.bind(this);   // 변수에 넣는다면 값을 찾지 못함. ( 바인드 하는 이유 ), 바인드를 하지 않을경우 render에서 this로 사용 시 this에 전역변수인 window 객체에 접근함
        this.handleClick = this.handleClick.bind(this);

        this.handleCreate = this.handleCreate.bind(this);
        this.handleRemove = this.handleRemove.bind(this);
        this.handleEdit = this.handleEdit.bind(this);
    }
    // 값들을 입/출력은 해당 state의 정보를 property로 다른 js파일로 보내고 해당 배열의 변화는 바인딩 해둔 메소드를 property로 보내고 보낸 js에서 실행시킨다?

    componentDidMount(){ // 컴포넌트 생성 시 호출되는 메서드 ( 리액트 라이프사이클 메서드 )
        const contactData = localStorage.localContactData;

        if(contactData){
            this.setState(()=> ({contactData : JSON.parse(contactData)}))   // 로컬 스트리지에서 JSON 스트링 형태를 object로 변환 ( JSON.parse ) 후 contactData 값 변경
        }
    }

    componentDidUpdate(prevProps, prevState){          // 업데이트 후 로컬스토리지에 저장
        if(JSON.stringify(prevState.contactData) != JSON.stringify(this.state.contactData)){    // state.contactDate가 변경될 시 
            localStorage.localContactData = JSON.stringify(this.state.contactData);  // Json 객체를 스트링형태로 변환 ( JSON.strongify ) 후 로컬스토리지에 저장
        }
    }

    handleChange(e){
        this.setState({                         // setState로 접근해야함
            keyword: e.target.value
        });
    }

    handleClick(key){
        this.setState({
            selectedKey: key
        });
    }

    handleCreate(contact){
        this.setState({
            contactData: update(this.state.contactData,     // immutability helper의 push : 해당 배열에 데이터 추가
                {$push: [contact]})
        });
    }

    handleRemove(){
        if(this.state.selectKey<0){
            return;
        }

        this.setState({
            contactData : update(this.state.contactData,    // immutability helper의 splice: 해당 배열에 인덱스 요소부터 시작해서 n개 데이터 제거
                    {$splice: [[this.state.selectedKey, 1]]}
                ),
                selectedKey: -1
        });
    }

    handleEdit(name, phone){
        this.setState({
            contactData: update(this.state.contactData,     // immutability helper의 set : 데이터 값을 변경
                {
                    [this.state.selectedKey] : {
                        name: {$set: name},
                        phone: {$set: phone}
                    }
                })
        });
    }

    render() {
        const mapToComponents = (data) => {
            data.sort();
            data = data.filter(
                (contact) => {
                    return contact.name.toLowerCase().indexOf(this.state.keyword.toLowerCase()) > -1;   // 소문자로 변경 후 비교
                }
            )
            return data.map((contact, i) => {       // 맵 동작 원리 찾아봐야 할 듯
                return (<ContactInfo contact={contact} key={i} onClick={()=> this.handleClick(i)}/>);
            });
        };

        return (
            <div>
                <h1>Contacts</h1>
                <input 
                    name="keyword"
                    placeholder="Search"
                    value={this.state.keyword}
                    onChange={this.handleChange}
                />
                <div>{mapToComponents(this.state.contactData)}</div>
                <ContactDetail
                    isSelected={this.state.selectedKey !== -1}
                    contact = {this.state.contactData[this.state.selectedKey]}
                    onRemove = {this.handleRemove}
                    onEdit = {this.handleEdit}
                />
                <ContactCreate onCreate={this.handleCreate}/>
            </div>
        );
    }
}
