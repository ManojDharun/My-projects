//import 'bootstrap/dist/js/bootstrap.js';
//import 'bootstrap/dist/css/bootstrap.css';
import { useState } from 'react';
import {useLocation} from 'react-router-dom';
const Navbar = () => {
    const [isVisible,setVisible] = useState(true);
    const loc = useLocation();
    const isdashboard = loc.pathname === '/dashboard';
    var loginid = document.getElementById('Loginid');
    if(isdashboard){
        if(loginid){
            loginid.textContent = "Logout";
        }
    }
    else {
        if(loginid){
            loginid.textContent = "Login";
        }
    }
    return (
        <div className = "container-fluid bg-light">
        <nav className = "navbar navbar-expand-lg">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"></link>
            <a href = "#" id = "Loginid" className = "navbar-brand">
                Login<i className="fas fa-user"></i>
            </a>
            <div>
                <ul className = "navbar-nav">
                    <li className = "nav-item">
                        <a href = "#" className = "nav-link active">Home</a>
                    </li>
                    <li className = "nav-item ">
                        <a href = "#" className = "nav-link active">Index</a>
                    </li>
                    <li className ="nav-item dropdown">
                            <a className ="nav-link active dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Services
                            </a>
                            <ul className ="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li><a className ="dropdown-item" href="#">Action</a></li>
                                <li><a className ="dropdown-item" href="#">Another action</a></li>
                                <li><a className ="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                    </li>
                    <li className = "nav-item">
                        <a href = "#" className = "nav-link active">Support</a>
                    </li>
                </ul>
            </div>
        </nav>
        </div>
    )
}
export default Navbar;