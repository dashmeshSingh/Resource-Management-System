import React ,{useEffect,useState} from 'react'
import Table from './OnbenchTable'
import axios from 'axios'
import "./Onbench.css"

const Onbench = () => {
    const [onBench,setonBench] = useState([]);
    const mailId = localStorage.getItem("username");
    useEffect (() =>{
        async function adminData(){
        
          const res = await axios.get(`http://localhost:8080/hrms/dashboardDetails?username=${mailId}&role=projectManager`) 
         
             setonBench(res.data.onbechemplist);
        }
        adminData();
      },[])
    return (
        <div className="onBenchEmpData">
            <div className="tableDisplay">
            <div className="table_main" id="t01">
                <table>
                    <tr>
                    <th>EMP ID</th>
                    <th>EMP NAME</th>
                    <th>PROJECT MANAGER</th>
                    </tr>
                    
                    {onBench.map((val)=>(
                        <tr>
                        <td>{val.empid}</td>
                        <td>{val.empname}</td>
                        <td>{val.manager}</td>
                    </tr>
                    ))}
                    
        
                </table>
        </div>
            </div>
            
        </div>
    )
}

export default Onbench
