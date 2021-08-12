import React ,{useState} from "react";
import { useHistory } from "react-router-dom";
import InputLabel from "@material-ui/core/InputLabel";
import Input from "@material-ui/core/Input";
import Bill from "./bill";


const credentials ={
 
  projectName: ''
  // projectMonth: ''
}
const Invoice = () => {
  const [details, setdetails] = useState(credentials);
  const [empData, setempData] = useState([]);
  let newData;
  const history = useHistory();
 

  
  
  
  const handleInput=(event)=>{
    // console.log(event.target.value)
    var {name ,value} =event.target;
    setdetails({
      ...details,
      [name] : value
    });
    
    
  };

  const submitFunction = (event) =>{
    console.log("ProjMan: ",details.projectName);
    
    event.preventDefault();
     newData = {
      
      name: details.projectName
      //month : details.projectMonth
    }
    
    setempData([
      ...empData,
      newData
    ])

  }
  const validation = () =>{
    if( details.projectName===""  ){ //|| details.projectMonth===""
      alert("ENTER ALL FIELDS")
    }
    else{
      history.push({pathname: "/finance/bill", state: details.projectName});
    }
    
  }

  return (
    <>
    <div className="addUser">
    <div className="main_con">
        <div className="form_card">
          <br />
          <h1>GENERATE INVOICE</h1>
          <hr />
          <br />
          <form action="" onSubmit= {submitFunction}>
            
            <InputLabel htmlFor="projectName">ENTER PROJECT NAME</InputLabel>
            <Input type="text" name="projectName" id="projectName" value={details.projectName}  onChange={handleInput}/>
            <br /> <br />
            {/* <InputLabel htmlFor="projectMonth">ENTER MONTH</InputLabel>
            <Input type="month" name="projectMonth" id="projectMonth" value={details.projectMonth}  onChange={handleInput}/>
            <br /> <br /> */}
            
            <button id="assign_task" type="submit" onClick={validation}>GENERATE</button>
          </form>
        </div>
      </div>
    </div>
      
    </>
  );
};

export default Invoice;

