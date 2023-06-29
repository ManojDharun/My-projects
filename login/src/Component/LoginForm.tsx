import "./LoginDesign.css";
//import 'bootstrap/dist/js/bootstrap.js';
//import 'bootstrap/dist/css/bootstrap.css';
//import RegisterForm from "./RegisterForm";
import {useNavigate} from 'react-router-dom';
import React,{useState,FormEvent} from 'react';
import RegisterForm from "./RegisterForm";
interface LoginFormProps{
    userslist: { username: string; email: string; password: string; }[];
}
const LoginForm:React.FC<LoginFormProps> = ({userslist}) => {
    const [isVisisble, setIsVisible] = useState(true);
    const [name,setName] = useState('');
    const [password,setPassword] = useState('');
    const navigate = useNavigate();
    const Register = () => {
        setIsVisible(false);
    }
    const ValidateUserName = (event: React.ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        let pattern = new RegExp("^[a-zA-Z]{6,16}$", "i");
        var errormess = "";
        let istrue = pattern.test(value);
        setName(value);
        if(value == ""){
            errormess = "Please fill in the UserName field";
        }
        else if(!istrue){
            errormess = "Only Alphabets are allowed for the username";
        }
        var text = document.getElementById('usererror');
        if(text){
            text.textContent = errormess;
            text.style.color = 'red';
        }
    }
    const ValidatePassword = (event: React.ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        setPassword(value);
        var pattern = new RegExp("^[a-zA-Z0-9@@#$%&*!_]{8,16}$","i");
        var errormess = "";
        var istrue = pattern.test(value)
        if(value == ""){
            errormess = "Please fill in the Password field";
        }
        else if(!istrue){
            errormess = "Password must be atleast 8 characters long and contain atleast one alphabet, one special character, one number";
        }
        var text = document.getElementById('passworderror');
        if(text){
            text.textContent = errormess;
            text.style.color = 'red';
        }
    }
    const login = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        var current_user = name;
        var current_pass = password;
        for(const item of userslist){
            console.log(userslist.length);
            if(item.username == current_user && item.password === current_pass){
                navigate('/dashboard/'+current_user);
            }
        }
    }
    return (
        <div>
        {isVisisble ? (
        <div className = "container col-sm-6 border mt-4 bg-info">
        <form onSubmit={login} className = "text-center col-sm-5  mb-4">
            <div className = "form-outline mb-3 ">
                <label className = "col-form-label" htmlFor="InputUserName">UserName</label>
                <input type="text" id="InputUserName" className="form-control" onInput={ValidateUserName} placeholder = "Enter UserName"/>
                <p id = "usererror"></p>
            </div>
            <div className = "form-outline mb-3">
                <label className = "col-form-label"  htmlFor = "InputPassword">Password</label> 
                <input className = "form-control" type = "password" id = "InputPassword" onInput = {ValidatePassword} placeholder="Enter Password"/>
                <p id = "passerror"></p>
            </div>
            <div>
                <button type="submit" className="form-control btn btn-primary btn-block mb-4">Sign in</button>
            </div>
            <p>Not a member? <a href="#!" onClick = {Register}>Register</a></p>
        </form>
        </div>): (<RegisterForm/>)
        }
        </div>
    );
}
export default LoginForm;   