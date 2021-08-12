import React ,{useState , useEffect} from 'react'
import '../../../Dashboard/components/featuredinfo/Featuredinfo.css';
import axios from 'axios';

const Featuredinfo = () => {
    const [totalProj,settotalProj] = useState();
    const [activeProj,setactiveProj] = useState();
    const [totalEmp,settotalEmp] = useState();
    const [activeEmp,setactiveEmp] = useState();
    const [onBenchEmp,setonBenchEmp] = useState();
    // console.log(Login.login)
    const mailId = localStorage.getItem("username");
    useEffect (() =>{
        // console.log(Login.login);
        
        async function pmDashboard(){
        
          const res = await axios.get(`http://localhost:8080/hrms/dashboardDetails?username=${mailId}&role=projectManager`) 
         
             //console.log(res.data);
         
            settotalProj(res.data.totalProj);
             setactiveProj(res.data.activeProj);
             settotalEmp(res.data.totalEmp)
             setactiveEmp(res.data.activeEmp)
             setonBenchEmp(res.data.onBenchEmp)
            
        }
        pmDashboard();
      },[])

    return (
        <div className="featured">
            <div className="heading"><h3>OVERALL STATS OF MANAGER</h3></div>
            <div className="featuredItem" style={{gridTemplateColumns : "auto auto"}}>
                
                {/* <div className="featuredItemCard">
                    <h3 className="featuredItemTitle">TOTAL PROJECTS</h3>
                    <div className="featuredValue">
                        VALUE
                    </div>
                    <div className="featuredSub">
                        Compared To Last Month
                    </div>
                </div> */}

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
