import React from 'react'
import '../home/home.css'
import Featuredinfo from '../../components/featuredinfo/Featuredinfo'
import Chart from '../../components/charts/Chart'
import { Projectdata } from '../../dummydata'

const Home = () => {
    return (
        <div className="homePage">
           <Featuredinfo />
            {/* <Chart data={Projectdata} title="EMPLOYEE STATUS" dataKey="ActiveEmployees" dataKey2="On-BenchEmployees"/> */}
        </div>
    )
}

export default Home;