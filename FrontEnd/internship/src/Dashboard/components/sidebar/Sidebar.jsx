import React from "react";
import "../sidebar/Sidebar.css";
import { LineStyle, PersonAdd, Group ,Assignment } from "@material-ui/icons";
import { BrowserRouter as Router , NavLink } from "react-router-dom";


const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="sidebarWrapper">
        <div className="sidebarMenu">
          <h3 className="sidebarTitle ">DASHBOARD</h3>
          <ul className="sidebarList">
            <li className="sidebarListItem" >
              <LineStyle />
              <div className="itemTitle "><NavLink className="itemTitle"   to = '/admin/'>HOME</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <PersonAdd />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/admin/adduser'>ADD USER</NavLink></div>
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">QUICK MENU</h3>
          <ul className="sidebarList">
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle" ><NavLink  className="itemTitle"  to = '/admin/activeemp'>ACTIVE EMPLOYEES</NavLink></div>
            </li>
            <li className="sidebarListItem">
              <Assignment />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/admin/totalproject'>TOTAL PROJECTS</NavLink></div>
            </li>
            {/* <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle">TOTAL EMPLOYEES</div>
            </li> */}
            <li className="sidebarListItem ">
              <Assignment />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/admin/activeproject'>ACTIVE PROJECTS</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/admin/onbenchemp'>ON-BENCH EMPLOYEES</NavLink></div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
