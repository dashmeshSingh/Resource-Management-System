import React ,{useEffect,useState} from 'react'
import TotalprojectTable from './TotalprojectTable'
import axios from 'axios'
import "./Totalproject.css"

const Totalproject = () => {
    const [ totalProject,settotalProject] = useState([]);
    useEffect (() =>{
        async function adminData(){
        
          const res = await axios.get("http://localhost:8080/hrms/dashboardDetails?username=admin@test.com&role=Admin") 
         
             settotalProject(res.data.projectList);
        }
        adminData();
      },[])
      const Tabledata = totalProject;
      console.log("data = ",Tabledata);
    return (
        <div className="totalproject">
            <div className="tableDisplay">
            <div className="table_main" id="t01">
      <table>
        <tr>
          <th>PROJECT NAME</th>
          <th>PROJECT DESCRIPTION</th>
          <th>CLIENT</th>
          <th>DURATION</th>
          <th>EMPLOYEES ASSIGNED</th>
          <th>MANAGER</th>
        </tr>
        
        {totalProject.map((val)=>(
            <tr>
            <td>{val.projName}</td>
            <td>{val.projDesc}</td>
            <td>{val.client}</td>
            <td>{val.duration}</td>
            <td>{val.empAssigned.map((val)=>(val + "," ))}</td>
            <td>{val.projManager}</td>
          </tr>
        ))}
        
        
      </table>
    </div>
            
            {/* {Tabledata.map(({ projName ,projDesc , client,duration,empAssigned ,projManager})=>{
               return( <TotalprojectTable 
                title1="PROJECT NAME" 
                title2="DESC" 
                title3="CLIENT" 
                title4="DURATION" 
                title5 ="EMPLOYEES"
                title6 = "MANAGER"
                
                projName={projName}  
                projDesc ={projDesc}
                client ={client}
                duration ={duration}
                empAssigned={empAssigned}
                projManager={projManager}  />
            );
            })} */}
            </div>
            
        </div>
    )
}

export default Totalproject
