import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import ScrollToTop from './component/ScrollToTop';
import Home from './page/Home';
import Navigation from './page/Navigation';
import Posts from './page/Posts';

export default function App() {
  return (
    <BrowserRouter>
      <Navigation/>
      <ScrollToTop/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/post" element={<Posts/>}/>
        </Routes>
    </BrowserRouter>
  );
}
