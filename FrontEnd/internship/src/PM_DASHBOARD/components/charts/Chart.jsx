import React from 'react'
import '../../../Dashboard/components/charts/Chart.css'
import { LineChart, Line, XAxis, Tooltip,ResponsiveContainer } from 'recharts';
const Chart = ({title , data ,dataKey,dataKey2}) => {
    
    return (
        <div className='chart'>
            <h3 className="chart-title">{title}</h3>
            <ResponsiveContainer width="100%" aspect={4 / 1}>
                <LineChart data={data}>
                    <XAxis dataKey="Month" stroke = '#57D5D6'/>
                    <Line type='monotone' dataKey={dataKey} stroke = '#50E4EA' />
                    <Line type='monotone' dataKey={dataKey2} stroke = '#70e000' />
                    <Tooltip itemStyle={{'background' : '#000'}} />
                </LineChart>
            </ResponsiveContainer>
        </div>
    )
}

export default Chart
