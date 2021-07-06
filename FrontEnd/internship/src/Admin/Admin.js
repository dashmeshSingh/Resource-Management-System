import React from "react";
import "./Admin.css"
// import { Link } from "react-router-dom";
import Navbar from "../Components/Navbar"

const Admin = () => {
    return(
        <div>
            <Navbar/>
            <h1 className="text">Welcome, Admin</h1>
            <div className="conta">
            
         
            <div className="card1">    
             Total Employees<br/>
            </div>

            <div className="card1">
             Active Employees
            </div>

            <div className="card1">
             On-Bench Employees
            </div>

            <div className="card1">
             Active Project
            </div>

            <div className="card1">
             Active Project Managers
            </div>
            
            <div className="card1">
             Finance User
            </div>
            </div>
            
            
        </div>
    )
}

export default Admin;