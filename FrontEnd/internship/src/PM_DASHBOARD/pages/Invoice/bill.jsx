import React , {useRef,useEffect,useState} from "react";
import { useReactToPrint } from "react-to-print";
import "../Invoice/bill.css";
import SpanningTable from "./billTable";
import axios from 'axios';  
import { useLocation } from "react-router-dom";


const Bill = () => {
  const compRef = useRef();
  const [clientname,setclientname] = useState();
  const [invoiceno,setinvoiceno] = useState();
  const [billingdate,setbillingdate] = useState();
  const [clientaddress,setclientaddress] = useState();
  const [contactno,setcontactno] = useState();
  const [contactperson,setcontactperson] = useState();
  const [projectname,setprojectname] = useState();
  const [gstno,setgstno] = useState();
  const location = useLocation();
  // console.log(location);
  const generatePdf = useReactToPrint({
      content : ()=> compRef.current,
    })

  useEffect (() =>{
   
    async function invoice(){
    
      const res = await axios.get(`http://localhost:8080/hrms/invoice?projectName=${location.state}`) 
        console.log("NAme: ",location.state);
        console.log(res.data);
        setclientname(res.data.clientName)
        setinvoiceno(res.data.invoiceId)
        setbillingdate(res.data.billingDate)
        setclientaddress(res.data.clientAddress)
        setcontactno(res.data.clientContactPerson)
        setcontactperson(res.data.clientContact)
        setprojectname(res.data.projectName)
        setgstno(res.data.gstno)
     
        
    }
    invoice();
  },[])

  return (<>
    <div className="bill"  >
     
      <div className="mainConBill" ref={compRef}>
        <h1 id="mainHeadingBill">GST INVOICE</h1>
        <div className="head">
          <div className="logo">LOGO</div>
          <div className="invoiceDetails">
            <span className="invoiceNo">
              <h4>Invoice No :{invoiceno}</h4>{" "}
            </span>
            <span className="curDate">
              <h4> DATED : {billingdate}</h4>{" "}
            </span>
            <span className="gstNumber">GST : GST51H65</span>
          </div>
        </div>

        <div className="head">
          <div className="invoiceDetails">
            {/* <span id="invoiceno" >
              <h4>Client No :54</h4>{" "}
            </span> */}
            <span id="clientname">
              <h4> Client Name: {clientname}</h4>{" "}
            </span>
            
            <span className="gstNumber">GST :{gstno}</span>
            <span id="clientadd" >Client Address :{clientaddress}</span>
            <span id="contactperson" >Contact Person :{contactperson}</span>
            <span id="contactnumber" >Contact Number :{contactno}</span>
            <span id="projectname" >Project Name :{projectname}</span>
          
          </div>

          
          <div className="logo">CLIENT</div>
        </div>
        
        <div className="billing">
          <SpanningTable />
        </div>
        <button id="generatePdf" onClick={generatePdf}>
          PRINT
        </button>
      </div>
      
    </div>
    
  </>
  );
};

export default Bill;


