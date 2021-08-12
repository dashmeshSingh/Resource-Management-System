import React from 'react'
import RemoveCircleIcon from '@material-ui/icons/RemoveCircle';
import "./AddEmpComp.css";

const AddEmpComp = (props) => {
    return (
        <div className="list">
<button id="del" onClick={()=>{
    return props.onSelect(props.id);
}}> <RemoveCircleIcon/> </button>
     <li>{props.text}</li> 
     
        </div>
    )
}

export default AddEmpComp
