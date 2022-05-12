import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './page/Home';
import Navigation from './page/Navigation';
import Posts from './page/Posts';

function App() {
  return (
    <BrowserRouter>
      <Navigation/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/post" element={<Posts/>}/>
        </Routes>
    </BrowserRouter>
  );
}

export default App;
