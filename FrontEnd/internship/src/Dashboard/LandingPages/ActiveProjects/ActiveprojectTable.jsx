import React from "react";

const ActiveprojectTable = ({title1,title2,title3,title4,empid ,empname ,projectname,manager}) => {
    
  return (
    <div className="table_main" id="t01">
      <table>
        <tr>
          <th>{title1}</th>
          <th>{title2}</th>
          <th>{title3}</th>
          <th>{title4}</th>
        </tr>
        
        <tr>
            <td>{empid}</td>
            <td>{empname}</td>
            <td>{projectname}</td>
            <td>{manager}</td>
          </tr>
      </table>
    </div>
  );
};

export default ActiveprojectTable;

