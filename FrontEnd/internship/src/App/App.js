import React from "react";
import Login from "./Login"
import Admin from "./Admin"
import AddUser from "./AddUser"
import { BrowserRouter,Switch,Route } from "react-router-dom";

const App = () => {
    return(
        <BrowserRouter>
            <div>
                <Switch>
                    <Route exact path="/" component={Login}/>;
                    <Route path="/Admin" component={Admin}/>;
                    <Route path="/AddUser" component={AddUser}/>;
                </Switch>
            </div>
        </BrowserRouter>
    )
    
};

export default App;