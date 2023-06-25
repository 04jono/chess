import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react'
import api from './api/axiosConfig';

function App() {
  const [board, setBoard] = useState([]);

  const getBoard = async () => {
    try {
      const response = await api.get('api/string/647527da2ad0d0603b7ba16b');
      var string = response.data.split("\n");
      console.log(string);
      setBoard(string);
    } catch (err) {
      console.log(err);
    }

  }

  useEffect(() => {
    getBoard()
  }, [])

  return (
    <div>
      {board.map(row => { return <p>{row}</p> })}
    </div>
  );
}

export default App;
