import React from 'react'
import '../charts/Chart.css'
import { LineChart, Line, XAxis, Tooltip,ResponsiveContainer } from 'recharts';
const Chart = ({title , data ,dataKey}) => {
    
    return (
        <div className='chart'>
            <h3 className="chart-title">{title}</h3>
            <ResponsiveContainer width="100%" aspect={4 / 1}>
                <LineChart data={data}>
                    <XAxis dataKey="Month" stroke = '#57D5D6'/>
                    <Line type='monotone' dataKey={dataKey} stroke = '#50E4EA' />
                    <Tooltip itemStyle={{'background' : '#000'}} />
                </LineChart>
            </ResponsiveContainer>
        </div>
    )
}

export default Chart
