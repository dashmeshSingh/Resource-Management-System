import React from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";
import { NavLink } from "react-router-dom";

const Redirect=()=>{
    return (window.location.assign("/"));
};

const Navbar = () =>{
    return(<>
        <header>
            <div className="nav">
                <span className="logo">
                    <p>LOGO</p>
                    {/* <NavLink className="Linkcolor" to="/Navbar"></NavLink> */}
                </span>
                <span className="list">
                    <ul>
                        <NavLink activeClassName="active_class" className="Linkcolor" to="/Admin">
                        <li>DASHBOARD</li>  
                        </NavLink>

                        <NavLink activeClassName="active_class" className="Linkcolor" to="/AddUser">
                        <li>ADD EMPLOYEE</li>
                        </NavLink>
                    </ul>
                </span>
                <span className="logOut">
                    <button onClick={Redirect}>LOGOUT</button>
                </span>
            </div>
        </header>
    </>);
};
 export default Navbar;