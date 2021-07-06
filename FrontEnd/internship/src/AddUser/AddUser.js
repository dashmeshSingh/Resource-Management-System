import React ,{useState} from "react";
import InputLabel from "@material-ui/core/InputLabel";
import Input from "@material-ui/core/Input";
import Navbar from "../Components/Navbar";

import {
  FormControlLabel,
  RadioGroup,
  FormLabel,
  Radio,
  FormControl,
} from "@material-ui/core";
import "./AddUser.css";
const credentials ={
  emp_id : '',
  emp_name: '',
  emp_mail : '',
  role : ''
}
const AddUser = () => {
  const [details, setdetails] = useState(credentials);
  const [empData, setempData] = useState([]);
  let newData;

  const handleInput=(event)=>{
    var {name ,value} =event.target;
    setdetails({
      ...details,
      [name] : value
    })
  };

  const submitFunction = (event) =>{
    event.preventDefault();
     newData = {
      id : details.emp_id,
      name: details.emp_name,
      mail : details.emp_mail,
      role : details.role
    }
    setempData([
      ...empData,
      newData
    ])
  }

  return (
    <>
      <Navbar/>
      <div className="main_con">
        <div className="form_card">
          <br />
          <h1>ADD USER</h1>
          <hr />
          <br />
          <form action="" onSubmit= {submitFunction}>
            <InputLabel htmlFor="emp_id">ENTER EMPLOYEE ID</InputLabel>
            <Input type="number" name="emp_id" id="emp_id" value={details.emp_id}  onChange={handleInput}/>
            <br /> <br />
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
                    onChange={handleInput}

                    onClick={() => setdetails({...details, role : 'project manager'})}
                  />
                  <FormControlLabel
                    value="finance"
                    control={<Radio />}
                    label="FINANCE"
                    onChange={handleInput}
                    onClick={() => setdetails({...details ,role : 'finance'})}
                  />
                  <FormControlLabel
                    value="employee"
                    control={<Radio />}
                    label="EMPLOYEE"
                    onChange={handleInput}
                    onClick={() => setdetails({...details,role : 'employee'})}
                  />
                </RadioGroup>
              </FormControl>
            </div>
            <br />
            <button id="add_user" type="submit">ADD</button>
          </form>
        </div>
      </div>
    </>
  );
};

export default AddUser;



