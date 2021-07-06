import React from "react";
import Login from "../Login/Login"
import Admin from "../Admin/Admin"
import AddUser from "../AddUser/AddUser"
import Navbar from "../Components/Navbar"
import { BrowserRouter,Switch,Route } from "react-router-dom";

const App = () => {
    return(
        <BrowserRouter>
            <div>
                <Switch>
                    <Route exact path="/" component={Login}/>;
                    <Route path="/Admin" component={Admin}/>;
                    <Route path="/AddUser" component={AddUser}/>;
                    <Route path="/Navbar" component={Navbar}/>;
                </Switch>
            </div>
        </BrowserRouter>
    )
    
};

export default App;