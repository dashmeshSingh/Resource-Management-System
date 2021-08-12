import React from 'react'
import '../home/home.css'
import Featuredinfo from '../../components/featuredinfo/Featuredinfo'
import Chart from '../../components/charts/Chart'
import { Projectdata } from '../../dummydata'

const Home = () => {
    return (
        <div className="homePage">
           <Featuredinfo />
            {/* <Chart data={Projectdata} title="ACTIVE PROJECT ANALYSIS" dataKey="ActiveProjects"/> */}
        </div>
    )
}

export default Home;