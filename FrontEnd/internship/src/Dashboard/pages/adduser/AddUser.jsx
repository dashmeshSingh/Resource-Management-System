import React,{useState,useEffect} from "react";
import { makeStyles } from '@material-ui/core/styles';
import InputLabel from "@material-ui/core/InputLabel";
import Input from "@material-ui/core/Input";
import axios from 'axios';
// import ProjectManager from "./ProjectManager";
import {
  FormControlLabel,
  RadioGroup,
  FormLabel,
  Radio,
  FormControl,
  MenuItem,
  Select, 
} from "@material-ui/core";
import "./AddUser.css";

const useStyles = makeStyles((theme) => ({
  formControl: { 
    margin: theme.spacing(1),
    minWidth: 120,
  },
  selectEmpty: {
    marginTop: theme.spacing(2),
  },
}));

const credentials ={
  
  emp_name: '',
  emp_mail : '',
  role : '',
  workingUnder: '',
  status : ''
}
const AddUser = () => {
  const [details, setdetails] = useState(credentials);
  const [empData, setempData] = useState([]);
  const [show, setShow] = useState(false);
  const [ProjMan,setProjMan] = useState();
  const classes = useStyles();

  
  let newData;


 

  const handleInput=(event)=>{
    var {name ,value} =event.target;
    setdetails({
      ...details,
      [name] : value
    })

    
  };

   
  useEffect (() =>{
    async function getProjectManager(){
    
      const res = await axios.get("http://localhost:8080/hrms/projManager") 
      // const newEntry = {ProjMan: res.data}
      // setProjMan(...ProjMan,newEntry);
      
        // setProjMan({ProjMan:res.data});
        console.log(res.data.projectManagerList);
        setProjMan(res.data.projectManagerList);
    }
    getProjectManager();
  },[])
  
  
 

// var Manager ;
// const ProjectManger = getProjectManager.ProjMan.ProjMan;

  const submitFunction = (event) =>{
    event.preventDefault();
     newData = {
      
      name: details.emp_name,
      mail : details.emp_mail,
      role : details.role,
      workingUnder : details.workingUnder,
      status : details.status
    }
    setempData([
      ...empData,
      newData
    ])
    const EmpData = {
      
      empname: details.emp_name,
      email: details.emp_mail,
      role: details.role,
      reportingto: details.workingUnder,
      status : details.status
    }
      async function addEmp(){
        const res = await axios.post("http://localhost:8080/hrms/addemployee",EmpData) 
        // console.log(res.data);
      
    }
    

    // console.log(ProjectManger);
    addEmp();
    setdetails({emp_name:"", emp_mail:"", role:'', workingUnder:"", status:""});
      }
      

  return (
    <>
    
    <div className="addUser">
    <div className="main_con">
        <div className="form_card">
          <br />
          <h1>ADD USER</h1>
          <hr />
          <br />
          <form action="" onSubmit= {submitFunction}>
            
            <InputLabel htmlFor="emp_name">ENTER EMPLOYEE NAME</InputLabel>
            <Input type="text" name="emp_name" id="emp_name" value={details.emp_name}  onChange={handleInput}/>
            <br /> <br />
            <InputLabel htmlFor="emp_mail">ENTER EMPLOYEE EMAIL</InputLabel>
            <Input type="text" name="emp_mail" id="emp_mail" value={details.emp_mail} onChange={handleInput}/>
            <br />
            <br />
            <div className="role_assigned">
              <FormControl component="fieldset">
                <FormLabel component="legend">ROLE</FormLabel>
                <RadioGroup aria-label="role" name="role"> 
                  <FormControlLabel
                    value="project manager"
                    control={<Radio />}
                    label="PROJECT MANAGER"
                    onChange={() => {
                      setdetails({...details ,role : 'ProjectManager', workingUnder : 'Admin' ,status :'Active'})
                      
                      setShow(false)}} 

                    
                   
                  
                  />
                  <FormControlLabel
                    value="finance"
                    control={<Radio />}
                    label="FINANCE"
                    onChange={() => {
                      setdetails({...details ,role : 'Finance', workingUnder : 'Admin' ,status :'Active'})
                      
                      setShow(false)}}
                    
                  />
                  <FormControlLabel
                    value="employee"
                    control={<Radio />}
                    label="EMPLOYEE"
                    onChange={() => {
                      setdetails({...details,role : 'Employee', workingUnder :details.workingUnder ,status :'On Bench'})
                      
                      setShow(true)
                    }}
                    
                  />
                </RadioGroup>

                {show?  
                    <FormControl className={classes.formControl}>
                      <InputLabel id="demo-simple-select-autowidth-label">Working Under</InputLabel>
                      <Select
                        labelId="demo-simple-select-autowidth-label"
                        id="demo-simple-select-autowidth"
                        name="workingUnder"
                        value={details.workingUnder}
                        onChange={handleInput}>
                        
                        {ProjMan.map((val) => ( <MenuItem key={val.empName} value={val.empName}> {val.empName} </MenuItem>))}
                         
                        
                      </Select>
                      
                    </FormControl>
                  :null}
                  
                  

              </FormControl>
            </div>
            <br />
            <button id="add_user" type="submit">ADD</button>
          </form>
        </div>
      </div>
    </div>
      
    </>
  );
};

export default AddUser;
