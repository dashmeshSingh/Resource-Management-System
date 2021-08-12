import React from 'react';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import axios from 'axios'
import {useEffect,useState} from 'react'
import { useLocation } from 'react-router-dom';


export default function SimpleMenu() {
  const [anchorEl, setAnchorEl] = useState(null);
  const [employeelist,setemployeelist] = useState([]);
  const location = useLocation();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  

  useEffect (() =>{
    
    
    async function employeeList(){
    
      const res = await axios.get(`http://localhost:8080/hrms/invoice?projectName=${location.state}`) 
      // console.log("data ",res.data.empAssigned)
      setemployeelist(res.data.empAssigned);
      // console.log("Emp ",employeelist);

      }
    employeeList();
  },[])

  return (
    <div>
      <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
        Employee List 
      </Button>
      
      {employeelist.map((val) => ( <MenuItem  key={val}> {val} </MenuItem>))}
      
    </div>
  );
}
