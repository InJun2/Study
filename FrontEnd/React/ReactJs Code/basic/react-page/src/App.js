import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import ScrollToTop from './component/ScrollToTop';
import Home from './page/Home';
import Header from './page/Header';
import Support from './page/Support';
import Footer from './page/Footer';
import SideNavigation from './component/SideNavigaion';
import Login from './page/Login';
import Join from './page/Join';
import Board from './page/Board';
import Inquery from './page/Inquery';
import InqueryWrite from './page/InqueryWrite';

export default function App() {
  return (
    <BrowserRouter>
      <ScrollToTop/>
      <SideNavigation/>
      <Header/>

      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/support" element={<Support/>}/>
        <Route path="/board" element={<Board/>}/>
        <Route path="/inquery" element={<Inquery/>}/>
        <Route path="/inquery-write" element={<InqueryWrite/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/join' element={<Join/>}/>
      </Routes>
      
      <Footer/>
    </BrowserRouter>
  );
}
