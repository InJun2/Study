const express = require('express'); // express의 내장 body-parser 사용
const app = express();
const port = 3300;

// request에서 body 정보를 받아오기 위해서 body-parser 라이브러리를 사용해야함 ( post 로 값을 받아 올 경우 사용 )
// express는 node.js를 이용하여 백엔드 서버를 운용하기 위한 웹 프레임워크. 유사한 최근 프레임워크는 koa가 존재. 현재는 대부분 express 사용

app.use(express().json());
app.use(express.urlencoded( {extended : false}));
app.use('/api', (req, res)=> res.json({username:'bryan'}));

app.listen(port, ()=>{
    console.log(`express is running on ${port}`);
})
