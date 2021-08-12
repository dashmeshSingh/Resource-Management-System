import React ,{useEffect,useState} from 'react'
import Table from './OnbenchTable'
import axios from 'axios'
import "./Onbench.css"

const Onbench = () => {
    const [onBench,setonBench] = useState([]);
    useEffect (() =>{
        async function adminData(){
        
          const res = await axios.get("http://localhost:8080/hrms/dashboardDetails?username=admin@test.com&role=Admin") 
         
             setonBench(res.data.onbechemplist);
        }
        adminData();
      },[])
      const Tabledata = onBench;
      console.log("data = ",Tabledata);
    return (
        <div className="onBenchEmpData">
            <div className="tableDisplay">
            <div className="table_main" id="t01">
                <table>
                    <tr>
                    <th>EMP ID</th>
                    <th>EMP NAME</th>
                    {/* <th>PROJECT MANAGER</th> */}
                    </tr>
                    
                    {onBench.map((val)=>(
                        <tr>
                        <td>{val.empid}</td>
                        <td>{val.empname}</td>
                        {/* <td>{val.manager}</td> */}
                    </tr>
                    ))}
                    
        
                </table>
        </div>
            </div>
            
        </div>
    )
}

export default Onbench
