import React from 'react';
import '../Dashboard/dashboard.css'
import Topbar from './components/topbar/Topbar';
import Sidebar from './components/sidebar/Sidebar';
import Home from './pages/home/Home';
import { BrowserRouter as Router , Switch , Route } from "react-router-dom";
import Invoice from './pages/Invoice/Invoice'
import Bill from './pages/Invoice/bill'
import ActiveEmployee from './LandingPages/ActiveEmployee/ActiveEmp';
import Onbench from './LandingPages/ONBENCH/Onbench';
import Activeproject from './LandingPages/ActiveProjects/Activeproject';
import Totalproject from './LandingPages/TOTALPROJECTS/Totalproject';


const Dashboard3 = () => {
    return (
        <>
        <Router>
           <Topbar />
           <div className="container">
               
           <Sidebar />
           <Switch>
               <Route exact path ='/finance'>
                    <Home />
               </Route>
               <Route exact path ='/finance/invoice'>
                    <Invoice />
               </Route>
               <Route exact path ='/finance/bill'>
                    <Bill />
               </Route>
               <Route exact path ='/finance/activeemp'>
                    <ActiveEmployee />
               </Route>
               <Route exact path ='/finance/onbenchemp'>
                    <Onbench />
               </Route>
               <Route exact path ='/finance/activeproject'>
                    <Activeproject />
               </Route>
               <Route exact path ='/finance/totalproject'>
                    <Totalproject />
               </Route>
           </Switch>
           </div>

        </Router>  
        </>
    )
}

export default Dashboard3;
