import React ,{useEffect,useState} from 'react'
import Table from './Table'
import axios from 'axios'
import "./ActiveEmp.css"

const ActiveEmployee = () => {
    
    const [activeEmp,setactiveEmp] = useState([]);
    const mailId = localStorage.getItem("username");
    
    useEffect (() =>{
        async function adminData(){
        
          const res = await axios.get(`http://localhost:8080/hrms/dashboardDetails?username=${mailId}&role=projectManager`) 
         
             setactiveEmp(res.data.activemplist);
        }
        adminData();
      },[])
      const Tabledata = activeEmp;
      console.log("data = ",Tabledata);
    return (
        <div className="activeEmpData">
            <div className="tableDisplay">
            <div className="table_main" id="t01">
                <table>
                    <tr>
                    <th>EMP ID</th>
                    <th>EMP NAME</th>
                    <th>PROJECT NAME</th>
                    <th>PROJECT MANAGER</th>
                    </tr>
                    
                    {activeEmp.map((val)=>(
                        <tr>
                        <td>{val.empid}</td>
                        <td>{val.empname}</td>
                        <td>{val.projectname}</td>
                        <td>{val.manager}</td>
                    </tr>
                    ))}
                    
        
                </table>
        </div>
            
            </div>
            
        </div>
    )
}

export default ActiveEmployee;
