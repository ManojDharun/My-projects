import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.css';
import LoginForm from './Component/LoginForm';
import Dashboard from './Component/Dashboard';
import {useState} from 'react';
import { BrowserRouter as Router, Routes, Route,Link} from 'react-router-dom';
import Navbar from './Component/Navigation';
function App() {
  const [users, setUsers] = useState<{ username: string; email: string; password: string; }[]>([]);
  return (
    <Router>
    <div className="App">
      <Navbar />
      <Routes>
      <Route path="/" element={<LoginForm userslist={users}/>} />
      <Route path="/dashboard" element ={<Dashboard/>} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
