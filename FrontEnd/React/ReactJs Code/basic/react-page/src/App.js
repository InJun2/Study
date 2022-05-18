import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import ScrollToTop from './component/ScrollToTop';
import Home from './page/Home';
import Header from './page/Header';
import Posts from './page/Posts';
import Footer from './page/Footer';
import SideNavigation from './component/SideNavigaion';
import Login from './page/Login';

export default function App() {
  return (
    <BrowserRouter>
      <ScrollToTop/>
      <SideNavigation/>
      <Header/>

      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/post" element={<Posts/>}/>
        <Route path='/login' element={<Login/>}/>
      </Routes>
      
      <Footer/>
    </BrowserRouter>
  );
}
