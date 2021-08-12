import React from "react";
import Login from "./Login/Login"
import Dashboard from "./Dashboard/Dashboard";
import Dashboard2 from "./PM_DASHBOARD/Dashboard2";
import Dashboard3 from "../src/FinanceDashboard/Dashboard3";
import { BrowserRouter as Router , Switch , Route} from "react-router-dom";

function App() {
  return (
    <>
    <Router>
      <Switch>
      <Route exact path ='/' component={Login}/>
      
      <Route exact path ='/admin'>
            <Dashboard/>
      </Route>
      <Route exact path ='/pm'>
            <Dashboard2/>
      </Route>
      <Route exact path ='/finance'>
            <Dashboard3/>
      </Route>
        
      </Switch>
    </Router>
    </>
  );
}

export default App;
