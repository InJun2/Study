const express = require('express'); // express의 내장 body-parser 사용
const app = express();
const port = 3300;

// request에서 body 정보를 받아오기 위해서 body-parser 라이브러리를 사용해야함 ( post 로 값을 받아 올 경우 사용 )

app.use(express().json());
app.use(express.urlencoded( {extended : false}));
app.use('/api', (req, res)=> res.json({username:'bryan'}));

app.listen(port, ()=>{
    console.log(`express is running on ${port}`);
})
