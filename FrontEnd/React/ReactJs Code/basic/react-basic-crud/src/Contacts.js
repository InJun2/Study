import React, {Component} from "react";
import ContactInfo from "./ContactInfo";
import ContactDetail from "./ContactDetails";

export default class Contact extends Component {
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

        this.handleChange = this.handleChange.bind(this);   // bind가 뭐였는지 다시 확인 에정
        this.handleClick = this.handleClick.bind(this);
    }

    handleChange(e){
        this.setState({
            keyword: e.target.value
        });
    }

    handleClick(key){
        this.setState({
            selectedKey: key
        });

        console.log("selected Key..");
    }

    render() {
        const mapToComponents = (data) => {
            data.sort();
            data = data.filter(
                (contact) => {
                    return contact.name.toLowerCase().indexOf(this.state.keyword.toLowerCase()) > -1;
                }
            )
            return data.map((contact, i) => {       // 맵 동작 원리 찾아봐야 할 듯
                return (<ContactInfo contact = {contact} key={i} onClick={()=> this.handleClick(i)}/>);
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
                />
            </div>
        );
    }
}