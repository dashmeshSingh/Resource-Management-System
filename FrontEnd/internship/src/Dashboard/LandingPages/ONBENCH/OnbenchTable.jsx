import React from "react";

const Table = ({title1,title2,title3,empid ,empname ,manager}) => {
    
  return (
    <div className="table_main" id="t01">
      <table>
        <tr>
          <th>{title1}</th>
          <th>{title2}</th>
          <th>{title3}</th>
        </tr>
        
        <tr>
            <td>{empid}</td>
            <td>{empname}</td>
            <td>{manager}</td>
          </tr>
      </table>
    </div>
  );
};

export default Table;

