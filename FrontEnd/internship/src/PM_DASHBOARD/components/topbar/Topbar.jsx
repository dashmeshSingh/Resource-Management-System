import React from 'react'
import '../../../Dashboard/components/topbar/Topbar.css'
import {ExitToApp} from '@material-ui/icons';
import { Link ,Redirect } from 'react-router-dom';
const Topbar = () => {
    return (
        <div className='topbar'>
            <div className="topbarWrapper">
                <div className="topLeft"> 
                <Link className="logo" to='/admin/'><span className="logo">LOGO</span></Link>
                </div>
                <div className="topRight"> 
                <Link to='/'>
                <button className="Log-out" onClick={<Redirect to='/' />}>
                    <ExitToApp style={{ fontSize: 40 }}/>
                    </button>
                </Link>
                    
                </div>
            </div>
            
        </div>
    )
}

export default Topbar
