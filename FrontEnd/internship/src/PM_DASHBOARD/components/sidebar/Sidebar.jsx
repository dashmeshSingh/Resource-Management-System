import React from "react";
import '../../../Dashboard/components/sidebar/Sidebar.css'
import { LineStyle, Group ,Assignment } from "@material-ui/icons";
import AssignmentRoundedIcon from '@material-ui/icons/AssignmentRounded';
import ReceiptIcon from '@material-ui/icons/Receipt';
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
              <div className="itemTitle "><NavLink className="itemTitle"   to = '/pm/'>HOME</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <AssignmentRoundedIcon />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/pm/assigntask'>CREATE PROJECT</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <ReceiptIcon />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/pm/invoice'>INVOICE</NavLink></div>
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">QUICK MENU</h3>
          <ul className="sidebarList">
            
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/pm/activeemp'>ACTIVE EMPLOYEES</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Assignment />
              <div className="itemTitle" ><NavLink  className="itemTitle"  to = '/pm/activeproject'>ACTIVE PROJECTS</NavLink></div>
            </li>
            <li className="sidebarListItem ">
              <Group />
              <div className="itemTitle"><NavLink  className="itemTitle"  to = '/pm/onbenchemp'>ON-BENCH EMPLOYEES</NavLink></div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
