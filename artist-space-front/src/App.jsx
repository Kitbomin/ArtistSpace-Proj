import axios from 'axios'
import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    axios.get("/api/hello")
    .then(res => setMessage(res.data))
    .catch(err => console.log(err))
  }, []);

  return (
      <div>
        <h1>ArtistSpace 접속 테스트</h1>
        <p>서버응답: {message}</p>
      </div>
  )
}

export default App
