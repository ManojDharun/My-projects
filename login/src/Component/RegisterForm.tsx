import {useState,FormEvent} from 'react';
import LoginForm from './LoginForm';
function RegisterForm(){
    const [isVisible,setVisible] = useState(true);
    const [users, setUsers] = useState<{ username: string; email: string; password: string; }[]>([]);
    const Login = () => {
        setVisible(false);
    }
    const ValidateUserName = (event: React.ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        let pattern = new RegExp("^[a-zA-Z]{4,16}$", "i");
        var errormess = "";
        let istrue = pattern.test(value);
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
    const ValidateEmail = (event: React.ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        let pattern = new RegExp("^[a-zA-Z0-9@@#$%&*!_]{8,16}$","i");
        var errormess = "";
        var istrue = pattern.test(value);
        if(value == ""){
            errormess = "Please fill in the Email field";
        }
        else if(!istrue){
            errormess = "Enter the valid email address";
        }
        var text = document.getElementById('emailerror');
        if(text){
            text.textContent = errormess;
            text.style.color = 'red';
        }
    }
    const ValidatePassword = (event: React.ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        var pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        var errormess = "";
        var istrue = pattern.test(value);
        console.log(istrue);
        if(value == ""){
            errormess = "Please fill in the Password     field";
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
    const handleRegister = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        var user = (document.getElementById('InputUserName') as HTMLInputElement).value;
        var email = (document.getElementById('InputEmail') as HTMLInputElement).value;
        var pass = (document.getElementById('InputPassword') as HTMLInputElement).value;
        const new_user = {username:user,email:email,password:pass};
        setUsers([...users,new_user]); 
        setVisible(false);
    }
    return (
        <div>
        {isVisible ? (
        <div className = "container col-sm-6 border mt-4 bg-info">
        <form id = "myForm" onSubmit={handleRegister} className = "text-center col-sm-5  mb-4">
            <div className = "form-outline mb-3 ">
                <label className = "col-form-label" htmlFor="InputUserName">UserName</label>
                <input name = "InputUserName" type="text" id="InputUserName" className="form-control" placeholder = "Enter UserName" onInput = {ValidateUserName}/>
                <p id = "usererror"></p>
            </div>
            <div className = "form-outline mb-3">
                <label className = "col-form-label"  htmlFor = "InputEmail">Email</label> 
                <input name = "InputEmail" className = "form-control" type = "email" id = "InputEmail" placeholder="Enter Email" onInput = {ValidateEmail}/>
                <p id = "emailerror"></p>
            </div>
            <div className = "form-outline mb-3">
                <label className = "col-form-label"  htmlFor = "InputPassword">Password</label> 
                <input name = "InputPassword" className = "form-control" type = "password" id = "InputPassword" placeholder="Enter Password" onInput = {ValidatePassword}/>
                <p id = "passworderror"></p>
            </div>
            <div>
                <button type="submit" className="form-control btn btn-primary btn-block mb-4">Sign Up</button>
            </div>
            <p>Already a member? <a href="#!" onClick = {Login}>Login</a></p>
        </form>
        </div>): (<LoginForm userslist = {users}/>)
        }
        </div>
    )
}

export default RegisterForm;