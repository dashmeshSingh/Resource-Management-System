import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import SimpleMenu from "./employeeList";
import axios from 'axios'


import { useLocation } from 'react-router-dom';


const TAX_RATE = 0.07;

const useStyles = makeStyles({
  table: {
    minWidth: 700,
  },
});

function ccyFormat(num) {
  return `${num.toFixed(2)}`;
}

function priceRow(qty, unit) {
  return qty * unit;
}

function createRow(desc, qty, unit) {
  const price = priceRow(qty, unit);
  return { desc, qty, unit, price };
}

function subtotal(items) {
  return items.map(({ price }) => price).reduce((sum, i) => sum + i, 0);
}




export default function SpanningTable() {
  const classes = useStyles();
  const [totalempassigned, settotalempassigned] = useState();
  const [paymentperday, setpaymentperday] = useState();
  const location = useLocation();


  const [anchorEl, setAnchorEl] = useState(null);
  const [employeelist, setemployeelist] = useState([]);
  

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };



  useEffect(() => {


    async function employeeList() {

      const res = await axios.get(`http://localhost:8080/hrms/invoice?projectName=${location.state}`)
      // console.log("data ",res.data.empAssigned)
      setemployeelist(res.data.empAssigned);
      // console.log("Emp ",employeelist);

    }



    async function invoice() {

      const res = await axios.get(`http://localhost:8080/hrms/invoice?projectName=${location.state}`)

      // console.log(res.data);

      settotalempassigned(res.data.totalEmpAssigned)
      setpaymentperday(res.data.paymentdDay)


    }
    employeeList();
    invoice();
  }, [])

  const rows = [
    // createRow('ACTIVE EMPLOYEES', '',''),
    // createRow(<SimpleMenu />, '', ''),
    // createRow(SimpleMenu.employeelist.map((val) => ( <MenuItem  key={val}> {val} </MenuItem>)),'',''),
    // createRow('Waste Basket', 2, 17.99),
  ];

  const invoiceSubtotal = paymentperday * totalempassigned;
  const invoiceTaxes = TAX_RATE * invoiceSubtotal;
  const invoiceTotal = invoiceTaxes + invoiceSubtotal;


  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="spanning table">
        <TableHead>
          <TableRow>
            <TableCell align="center" colSpan={3}>
              Details
            </TableCell>
            <TableCell align="right">Price</TableCell>
          </TableRow>
          <TableRow>
            <TableCell>ACTIVE EMPLOYEES</TableCell>
            <TableCell align="right">Quantity</TableCell>
            <TableCell align="right">Per day amount</TableCell>
            <TableCell align="right">Sum</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.desc}>
              <TableCell>{row.desc}</TableCell>
              <TableCell align="right">{row.qty}</TableCell>
              <TableCell align="right">{row.unit}</TableCell>
              <TableCell align="right">{ccyFormat(row.price)}</TableCell>
            </TableRow>
          ))}

          {employeelist.map((val) => (
            <TableRow key={val}>
              <TableCell> {val}  </TableCell>
              <TableCell> 1 </TableCell>
              <TableCell> {paymentperday} </TableCell>
              <TableCell align="right"> {paymentperday} </TableCell>

            </TableRow>
          ))}

          <TableRow>
            <TableCell rowSpan={3} />
            <TableCell colSpan={2}>Subtotal</TableCell>
            <TableCell align="right">{ccyFormat(invoiceSubtotal)}</TableCell>
          </TableRow>
          <TableRow>
            <TableCell>Tax</TableCell>
            <TableCell align="right">{`${(TAX_RATE * 100).toFixed(0)} %`}</TableCell>
            <TableCell align="right">{ccyFormat(invoiceTaxes)}</TableCell>
          </TableRow>
          <TableRow>
            <TableCell colSpan={2}>Total</TableCell>
            <TableCell align="right">{ccyFormat(invoiceTotal)}</TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}

