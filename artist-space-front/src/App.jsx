import axios from 'axios'
import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'

import SignUp from './user/SignUp'
import SignIn from './user/SignIn'

function App() {
  return (
    <Router>
      <div className="App">
        {/* 네비게이션 바 (임시) */}
        <nav style={navStyles}>
          <Link to="/" style={linkStyles}>ArtistSpace</Link>
          <Link to="/signup" style={linkStyles}>회원가입</Link>
          <Link to="/signin" style={linkStyles}>로그인</Link>
        </nav>

        {/* 페이지 경로 설정 */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/signin" element={<SignIn />} />
        </Routes>
      </div>
    </Router>
  );
}

// 메인 홈 화면 (임시)
const Home = () => (
  <div style={{ textAlign: 'center', marginTop: '50px' }}>
    <h1>ArtistSpace에 오신 것을 환영합니다!</h1>
    <p>창작자들을 위한 새로운 SNS 공간</p>
  </div>
);

// 간단한 스타일
const navStyles = {
  padding: '20px',
  backgroundColor: '#f8f9fa',
  borderBottom: '1px solid #ddd',
  display: 'flex',
  gap: '20px'
};

const linkStyles = {
  textDecoration: 'none',
  color: '#333',
  fontWeight: 'bold'
};

export default App;

