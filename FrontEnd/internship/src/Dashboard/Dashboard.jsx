import React from 'react';
import '../Dashboard/dashboard.css'
import Topbar from './components/topbar/Topbar';
import Sidebar from './components/sidebar/Sidebar';
import Home from './pages/home/Home';
import  AddUser from './pages/adduser/AddUser';
import { BrowserRouter as Router , Switch , Route } from "react-router-dom";
import ActiveEmployee from './LandingPages/ActiveEmployee/ActiveEmp';
import Onbench from './LandingPages/ONBENCH/Onbench';
import Activeproject from './LandingPages/ActiveProjects/Activeproject';
import Totalproject from './LandingPages/TOTALPROJECTS/Totalproject';


const Dashboard = () => {
    return (
        <>
        <Router>
           <Topbar />
           <div className="container">
               
           <Sidebar />
           <Switch>
               <Route exact path ='/admin'>
                    <Home />
               </Route>

               <Route exact path ='/admin/adduser' component={AddUser}/>

               <Route exact path ='/admin/activeemp'>
                    <ActiveEmployee />
               </Route>
               <Route exact path ='/admin/onbenchemp'>
                    <Onbench />
               </Route>
               <Route exact path ='/admin/activeproject'>
                    <Activeproject />
               </Route>
               <Route exact path ='/admin/totalproject'>
                    <Totalproject />
               </Route>
           </Switch>
           </div>

        </Router>  
        </>
    )
}

export default Dashboard
