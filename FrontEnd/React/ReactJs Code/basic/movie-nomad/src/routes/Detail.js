import React from "react";

class Detail extends React.Component {
    componentDidMount() {
        const { location, history } = this.props;
        
        if (location.state === undefined) { // uri로 직접 접속시 props 정보가 없으므로 home으로 다이렉트 보냄
            history.push("/");
        }
    }
    
    render() {
        const { location } = this.props;
        console.log(location);
        if (location.state) {
            return <span>{location.state.title}</span>;
        } else {
            return null;
        }
    }
}

export default Detail;
