import React ,{useEffect , useState} from 'react'
import '../featuredinfo/Featuredinfo.css'
import axios from 'axios';

const Featuredinfo = () => {
    const [totalProj,settotalProj] = useState();
    const [activeProj,setactiveProj] = useState();
    const [totalEmp,settotalEmp] = useState();
    const [activeEmp,setactiveEmp] = useState();
    const [onBenchEmp,setonBenchEmp] = useState();

    useEffect (() =>{
        async function adminDashboard(){
        
          const res = await axios.get("http://localhost:8080/hrms/dashboardDetails?username=admin@test.com&role=Admin") 
         
            //  console.log(res.data);
            settotalProj(res.data.totalProj);
             setactiveProj(res.data.projectList.length)
             settotalEmp(res.data.totalEmp)
             setactiveEmp(res.data.activeEmp)
             setonBenchEmp(res.data.onBenchEmp)
            
        }
        adminDashboard();
      },[])
    return (
        <div className="featured">
            <div className="heading"><h3>OVERALL STATS  of ADMIN</h3></div>
            <div className="featuredItem">
                
                <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">TOTAL PROJECTS</h3>
                    <div className="featuredValue">
                        {totalProj}
                    </div>
                    
                </div>

                <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">ACTIVE PROJECTS</h3>
                    <div className="featuredValue">
                        {activeProj}
                    </div>
                    
                </div>

                <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">TOTAL EMPLOYEES</h3>
                    <div className="featuredValue">
                        {totalEmp}
                    </div>
                    
                </div>

                <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">ACTIVE EMPLOYEES</h3>
                    <div className="featuredValue">
                        {activeEmp}
                    </div>
                    
                </div>

                <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">ON-BENCH EMPLOYEES</h3>
                    <div className="featuredValue">
                        {onBenchEmp}
                    </div>
                    
                </div>
            </div>

            {/* <div className="heading">
                <h3>
                    ANALYSIS
                </h3>
            </div> */}
            
        </div>
    )
}

export default Featuredinfo
