import React, { useState ,useEffect } from "react";
import InputLabel from "@material-ui/core/InputLabel";
import Input from "@material-ui/core/Input";
import PersonAddIcon from '@material-ui/icons/PersonAdd';
import AddEmpComp from "./AddEmpComp";
import "./CreateProject.css";
import axios from 'axios';

const credentials = {
  task_ass: "",
  client_name: "",
  projDesc : "",
  // duration : "",
  paymentPerDay:"",
  contactPerson:"",
  contactPersonContact : "",
  clientAddress : "",
};
const AssignTask = () => {
  const [details, setdetails] = useState(credentials);
  const [projName, setProjName] = useState();
  const [start_date, setStart_date] = useState();
  const [end_date, setend_date] = useState();
  const [empData, setempData] = useState([]);
  const [empName, setempName] = useState("");
  const [EmpAddedList, setEmpAddedList] = useState([]);
  let newData;
  
  
  useEffect (() =>{
    const mailId = localStorage.getItem("username");
    async function projectManagerName(){
    
      const res = await axios.get(`http://localhost:8080/hrms/projManagerName?username=${mailId}`) 
     
        // console.log(res.data.projectManagerList[0]);
     
         setProjName(res.data.projectManagerList[0].empName);
        
    }
    projectManagerName();
  },[])


  const handleInput = (event) => {
    let { name, value } = event.target;
    setdetails({
      ...details,
      [name]: value,
    });
  };
  const handleEmpName =(event) =>{
    let { name, value } = event.target;
    setempName(value);
};
const deleteItem = (id) => {
  console.log("deleted");
  setEmpAddedList((olditems)=>{
      return olditems.filter((arrElem , index)=>{
          return index!==id;
      })

  })
};
const AddEmployee = (event) =>{
  event.preventDefault();
  setEmpAddedList((olditems)=>{
    return([...olditems,empName]);
})
setempName("");
};

const name_array = EmpAddedList;
console.log(name_array);
  const submitFunction = (event) => {
    localStorage.setItem("projectName" , `${details.projName}`);
    event.preventDefault();
    newData = {
      pmName : projName,
       name: name_array,
      task: details.task_ass,
      projDesc : details.projDesc,
      client: details.client_name,
      startDate: start_date,
      endDate : end_date,
      // duration : details.duration,
      paymentPerDay: details.paymentPerDay,
      contactPerson : details.contactPerson,
      contactPersonContact : details.contactPersonContact,
      clientAddress : details.clientAddress,
    };
    setempData([...empData, newData]);

    const projectData = {
      projManager: projName,
      empAssigned: name_array,
      projName: details.task_ass,
      projDesc : details.projDesc,
      client: details.client_name,
      startDate: start_date,
      endDate : end_date,
      // duration : details.duration,
      paymentPerDay: details.paymentPerDay,
      contactPerson : details.contactPerson,
      contactPersonContact : details.contactPersonContact,
      clientAddress : details.clientAddress,
    }
      async function addProject(){
        const res = await axios.post("http://localhost:8080/hrms/addproject",projectData); 
        // console.log(res.data);
      
    }

    addProject();
    setdetails({task_ass: "",
    client_name: "",
    projDesc : "",
    paymentPerDay:"",
    contactPerson:"",
    contactPersonContact : "",
    clientAddress : "",});
    setProjName("");
    setStart_date({start_date:""});
    setend_date({end_date:""});
    setempName("");
    setEmpAddedList([]);
  };
 

  return (
    <>
      <div className="addUser">
        <div className="main_con" id="main_con">
          <div className="form_card" id="form_card">
            <br />
            <h1>CREATE PROJECT</h1>
            <hr />
            <br />
            <form action="" onSubmit={submitFunction}>
            <InputLabel htmlFor="pmName">PROJECT MANAGER NAME</InputLabel>
                <Input
                  type="text"
                  name="pmName"
                  id="pmName"
                  value={projName}
                  onChange={handleInput}
                  fullWidth ={true}
                />
                <br/>
                <br />
              <div className="task_assigned">
                <InputLabel htmlFor="task_ass">ENTER PROJECT NAME</InputLabel>
                <Input
                  type="text"
                  name="task_ass"
                  id="task_ass"
                  value={details.task_ass}
                  onChange={handleInput}
                  fullWidth ={true}
                />
              </div>
              <br />
              <InputLabel htmlFor="projDesc">PROJECT DESCRIPTION </InputLabel>
              <Input
                type="text"
                name="projDesc"
                id="projDesc"
                value={details.projDesc}
                onChange={handleInput}
                fullWidth ={true}
              />
              <br />
              <br />
              <InputLabel htmlFor="client_name">ENTER CLIENT NAME</InputLabel>
              <Input
                type="text"
                name="client_name"
                id="client_name"
                value={details.client_name}
                onChange={handleInput}
                fullWidth ={true}
              />
              <br />
              <br />
              <InputLabel htmlFor="start_date">ENTER STARTING DATE</InputLabel>
              <Input
                type="date"
                name="start_date"
                id="start_date"
                value={start_date}
                onChange={(event) => {
                  setStart_date(event.target.value);
                }}
                fullWidth ={true}
              />
              <br /> 
              <br />
              <InputLabel htmlFor="end_date">ENTER END DATE</InputLabel>
              <Input
                type="date"
                name="end_date"
                id="end_date"
                value={end_date}
                onChange={(event) => {
                  setend_date(event.target.value);
                }}
                fullWidth ={true}
              />
              <br /> 
              <br />
              {/* <InputLabel htmlFor="duration">ENTER DURATION(days)</InputLabel>
              <Input
                type="text"
                name="duration"
                id="duration"
                value={details.duration}
                onChange={handleInput}
                fullWidth ={true}
              />
              <br />
              <br /> */}

              <InputLabel htmlFor="paymentPerDay">PER DAY AMOUNT</InputLabel>
              <Input
                type="number"
                name="paymentPerDay"
                id="paymentPerDay"
                value={details.paymentPerDay}
                onChange={handleInput}
                fullWidth ={true}
              />
              <br />
              <br />
              <div className="task_assigned">
                <InputLabel htmlFor="contactPerson">ENTER CONTACT PERSON</InputLabel>
                <Input
                  type="text"
                  name="contactPerson"
                  id="contactPerson"
                  value={details.contactPerson}
                  onChange={handleInput}
                  fullWidth ={true}
                />
              </div>
              <br />
              <div className="task_assigned">
                <InputLabel htmlFor="contactPersonContact">ENTER CONTACT PERSON'S PHONE </InputLabel>
                <Input
                  type="tel"
                  name="contactPersonContact"
                  id="contactPersonContact"
                  value={details.contactPersonContact}
                  onChange={handleInput}
                  fullWidth ={true}
                />
              </div>
              <br />
              <div className="task_assigned">
                <InputLabel htmlFor="clientAddress">ENTER CLIENT ADDRESS</InputLabel>
                <Input
                  type="text"
                  name="clientAddress"
                  id="clientAddress"
                  value={details.clientAddress}
                  onChange={handleInput}
                  fullWidth ={true}
                />
              </div>
              <br />
              <div className="addEmployee">
                <InputLabel htmlFor="emp_name">ENTER EMPLOYEE's</InputLabel>
                <div className="AddEmpDetails">
                  <Input
                    type="text"
                    name="emp_name"
                    id="emp_name"
                    autoComplete="off"
                    value={empName}
                    onChange={handleEmpName}
                    fullWidth ={true}
                  />
                  <button id="addEmp" onClick={AddEmployee}><PersonAddIcon style={{ fontSize: 35 }}/></button>
                </div>
                <div className="Emp_details_show">
                {EmpAddedList.map((data , index)=>{
                        return <AddEmpComp text={data}
                        key ={index}
                        id ={index}
                        onSelect = {deleteItem}
                        />;
                    })}
                </div>
              </div>
              <br />
              <button id="assign_task" type="submit">
                ASSIGN
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default AssignTask;
