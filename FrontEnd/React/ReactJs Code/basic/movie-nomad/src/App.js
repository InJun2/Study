import './css/App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./routes/Home";
import About from "./routes/About";
import Detail from "./routes/Detail.js";
import Navigation from "./component/Navigation";

function App() {
  return (
  <BrowserRouter>
    <Navigation/>
    <Routes>
      <Route path="/" element={<Home/>}></Route> 
      <Route path="/about" element={<About/>}></Route>
      <Route path="/movie/:id" element={<Detail/>}></Route>
    </Routes>
  </BrowserRouter>
  );
}

export default App;