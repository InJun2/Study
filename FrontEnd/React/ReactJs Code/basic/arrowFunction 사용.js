import './App.css';
import React from "react";
 
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Contact/>
      </header>
    </div>
  );
}

export default App;

class Contact extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      ContactDate : [
        {name :'Kim', phone: '010-0000-0000'},
        {name :'Hwang', phone: '010-0000-0001'},
        {name :'Hong', phone: '010-0000-0002'},
        {name :'Oh', phone: '010-0000-0003'},
      ]
    }
  }

  render(){
    const mapToComponent = (data) => {
      return data.map((contact, i) => { // arrow 함수는 js코드
        return (
          <ContactInfo contact = {contact} key = {i}/>
        );
      });
    }

    return (
      <div>
        {mapToComponent(this.state.ContactDate)}
      </div>
    )
  }
}

class ContactInfo extends React.Component{
  render(){
    return (
      <div>
        {this.props.contact.name}
        {this.props.contact.phone}
      </div>
    )
  }
}
