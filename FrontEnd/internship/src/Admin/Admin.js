import React from "react";
import "./Admin.css"
import { Link } from "react-router-dom";
const Admin = () => {
    return(
        <div>
            <h1>Welcome, Admin</h1>
            <div className='card1'>
                <Link className="Linkcolor" to="/AddUser">
                <p>Add employee</p>
                </Link>
            </div>
        </div>
    )
}

export default Admin;