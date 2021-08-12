import React from "react";

const TotalprojectTable = ({title1,title2,title3,title4,title5,title6,projName ,projDesc , client,duration,empAssigned ,projManager}) => {
    
  return (
    <div className="table_main" id="t01">
      <table>
        <tr>
          <th>{title1}</th>
          <th>{title2}</th>
          <th>{title3}</th>
          <th>{title4}</th>
          <th>{title5}</th>
          <th>{title6}</th>
        </tr>
        
        <tr>
            <td>{projName}</td>
            <td>{projDesc}</td>
            <td>{client}</td>
            <td>{duration}</td>
            <td>{empAssigned}</td>
            <td>{projManager}</td>
          </tr>
      </table>
    </div>
  );
};

export default TotalprojectTable;

