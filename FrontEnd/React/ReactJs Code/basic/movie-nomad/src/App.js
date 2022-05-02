import './css/App.css';
import { HashRouter, Routes, Route } from "react-router-dom";
import Home from "./routes/Home";
import About from "./routes/About";
import Detail from "./routes/Detail.js";
import Navigation from "./component/Navigation";

function App() {
  return (
  <HashRouter>
    <Navigation/>
    <Routes>
      <Route path="/" exact={true} element={<Home/>}></Route>
      <Route path="/about" element={<About/>}></Route>
      <Route path="/movie/:id" element={<Detail/>}></Route>
    </Routes>
  </HashRouter>
  );
}

export default App;