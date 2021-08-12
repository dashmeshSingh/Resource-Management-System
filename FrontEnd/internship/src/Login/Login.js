import React, { useState } from "react";
import IconButton from "@material-ui/core/IconButton";
import InputLabel from "@material-ui/core/InputLabel";
import Visibility from "@material-ui/icons/Visibility";
import InputAdornment from "@material-ui/core/InputAdornment";
import VisibilityOff from "@material-ui/icons/VisibilityOff";
import Input from "@material-ui/core/Input";
import "./Login.css"
import { useHistory } from "react-router-dom";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import Typist from "react-typist";
import axios from "axios";


const details = {
  email: "",
  password: "",
  showpassword: "",
  
 
};
const Login = () => {
  const [login, setlogin] = useState(details);
  // const [allEntry, setallEntry] = useState([]);
  const history = useHistory();


  const handleInput = (event) => {
    var { name, value } = event.target;
    setlogin({
      ...login,
      [name]: value,
    });
  };

  const handleClickShowPassword = () => {
    setlogin({ ...login, showPassword: !login.showPassword });
  };

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

const handlePasswordChange = (prop) => (event) => {
    setlogin({ ...login, [prop]: event.target.value });
  };  

const validation = () => {
  const getData = async() =>{
    let sendData= {username : login.email , password : login.password};
    let result = await axios.post('http://localhost:8080/hrms/login', sendData);
    // console.log('result' ,result);
      let response = result.data;
      // console.log(response);
      if(response === "Admin"){
        // alert("Login successful");
          history.push("/admin/");
        }
        else if(response === "projectManager"){
          history.push("/pm/");
        }
        else if(login.email === "finance@gmail.com" && login.password === "hello"){
          history.push("/finance/");
        }
        else if(login.email === "" && login.password === ""){
          alert("Please enter login credentials")
        }
        else{
          alert("Wrong Login Credentials!!!")
        }
  };
   
     getData();

}



  
  const submitFunction = (event) => {
    event.preventDefault();
    localStorage.setItem("username" , `${login.email}`);
    // let newEntry = { username : login.email , password : login.password};
    // setallEntry([
    //     ...allEntry,
    //     newEntry
    // ]);
    }

    // validation();
  
  return (
    <>
    {/* {login} */}
      <div className="main">
      <div className="sideText">
          <Typist cursor={{ show: false }} avgTypingDelay={400}>
            <Typist.Delay ms={200} />
            <h1>
              WELCOME <br /> USER{" "}
            </h1>
          </Typist>
        </div>
        <div className="form_card">
          <form action="" onSubmit={submitFunction}>
              <AccountCircleIcon style={{ fontSize: 90 }} />
            
            <br />
            <hr/><
              br />
            <div className="username">
              <InputLabel htmlFor="email">ENTER USERNAME</InputLabel>
              <Input
                type="text"
                name="email"
                id="userName"
                value={login.email}
                onChange={handleInput}  
                autoComplete="off"      
              />
            </div><br />
            <div className="password">
              <InputLabel htmlFor="password">ENTER PASSWORD</InputLabel>
              <Input
                name="password"
                type={login.showPassword ? "text" : "password"}
                onChange={handlePasswordChange("password")}
                value={login.password}
                endAdornment={
                  <InputAdornment position="end">
                    <IconButton
                      onClick={handleClickShowPassword}
                      onMouseDown={handleMouseDownPassword}
                    >
                      {login.showPassword ? <Visibility /> : <VisibilityOff />}
                    </IconButton>
                  </InputAdornment>
                }
              />
            </div>
              <br />
            <div className="login">
              
              
              <button type="submit" id='login' onClick={validation}>LOGIN</button>
              
            </div>
            <div className="forgetPassword">
                <a href="/">FORGOT PASSWORD</a>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
