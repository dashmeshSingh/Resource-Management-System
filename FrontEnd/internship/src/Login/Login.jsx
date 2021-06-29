import React, { useState } from "react";
import IconButton from "@material-ui/core/IconButton";
import InputLabel from "@material-ui/core/InputLabel";
import Visibility from "@material-ui/icons/Visibility";
import InputAdornment from "@material-ui/core/InputAdornment";
import VisibilityOff from "@material-ui/icons/VisibilityOff";
import Input from "@material-ui/core/Input";
import "./Login.css"
const details = {
  email: "",
  password: "",
  showpassword: "",
};
const Login = () => {
  const [login, setlogin] = useState(details);
  const [allEntry, setallEntry] = useState([]);

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
  const submitFunction = (event) => {
    event.preventDefault();
    let newEntry = { username : login.email , password : login.password};
    setallEntry([
        ...allEntry,
        newEntry
    ]);
    
    
  }
  return (
    <>
      <div className="main">
        <div className="form_card">
          <form action="" onSubmit={submitFunction}>
            <h1>WELCOME</h1><br />
            <hr/><br />
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
              <button type="submit" id='login'>LOGIN</button>
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
