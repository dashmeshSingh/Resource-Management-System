import React ,{useEffect,useState} from 'react'
import axios from 'axios'
import "./Activeproject.css"

const Activeproject = () => {
    const [activeproject,setactiveproject] = useState([]);
    const mailId = localStorage.getItem("username");
    useEffect (() =>{
        async function adminData(){
        
          const res = await axios.get(`http://localhost:8080/hrms/dashboardDetails?username=${mailId}&role=projectManager`) 
         
             setactiveproject(res.data.activeprojlist);
        } 
        adminData();
      },[])
      const Tabledata = activeproject;
      console.log("data = ",Tabledata);
    return (
        <div className="activeproject">
            <div className="tableDisplay">
            <div className="table_main" id="t01">
                <table>
                    <tr>
                    <th>EMP ID</th>
                    <th>EMP NAME</th>
                    <th>PROJECT NAME</th>
                    <th>PROJECT MANAGER</th>
                    </tr>
                    
                    {activeproject.map((val)=>(
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

export default Activeproject
