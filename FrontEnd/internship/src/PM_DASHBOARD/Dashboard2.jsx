import React from 'react';
import '../Dashboard/dashboard.css'
import Topbar from './components/topbar/Topbar';
import Sidebar from './components/sidebar/Sidebar';
import Home from './pages/home/Home';
import AssignTask from './pages/assignTask/AssignTask';
import Invoice from './pages/Invoice/Invoice';
import { BrowserRouter as Router , Switch , Route } from "react-router-dom";
import Bill from './pages/Invoice/bill';
import ActiveEmployee from './LandingPages/ActiveEmployee/ActiveEmp';
import Onbench from './LandingPages/ONBENCH/Onbench';
import Activeproject from './LandingPages/ActiveProjects/Activeproject';


const Dashboard2 = () => {
    return (
        <>
        <Router>
           <Topbar />
           <div className="container">
               
           <Sidebar />
           <Switch>
               <Route exact path ='/pm/'>
                    <Home />
               </Route>
               <Route exact path ='/pm/assigntask'>
                    <AssignTask />
               </Route>
               <Route exact path ='/pm/invoice'>
                    <Invoice />
               </Route>
               <Route exact path ='/pm/bill'>
                    <Bill />
               </Route>
               <Route exact path ='/pm/activeemp'>
                    <ActiveEmployee />
               </Route>
               <Route exact path ='/pm/onbenchemp'>
                    <Onbench />
               </Route>
               <Route exact path ='/pm/activeproject'>
                    <Activeproject />
               </Route>
               
           
           </Switch>
           </div>

        </Router>  
        </>
    )
}

export default Dashboard2
