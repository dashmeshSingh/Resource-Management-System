import React from "react";
import "../sidebar/Sidebar.css";
import { LineStyle,Group ,Assignment } from "@material-ui/icons";
import { BrowserRouter as Router , NavLink } from "react-router-dom";
import ReceiptIcon from '@material-ui/icons/Receipt';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="sidebarWrapper">
        <div className="sidebarMenu">
          <h3 className="sidebarTitle ">DASHBOARD</h3>
          <ul className="sidebarList">
            <li className="sidebarListItem" >
              <LineStyle />
              <div className="itemTitle "><NavLink className="itemTitle"   to = '/finance/'>HOME</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <ReceiptIcon />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/finance/invoice'>INVOICE</NavLink></div>
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">QUICK MENU</h3>
          <ul className="sidebarList">
            
            <li className="sidebarListItem">
              <Assignment />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/finance/totalproject'>TOTAL PROJECTS</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/finance/activeemp'>ACTIVE EMPLOYEES</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Assignment />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/finance/activeproject'>ACTIVE PROJECTS</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/finance/onbenchemp'>ON-BENCH EMPLOYEES</NavLink></div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
