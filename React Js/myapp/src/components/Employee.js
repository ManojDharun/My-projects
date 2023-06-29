import React, { useState,Fragment } from 'react';
import {Table} from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.min.css";

function Employees() {
  // Define the state variable for employee details array
  let [employees, setEmployees] = useState([]);

  // Define the state variables for employee name and age
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [dept, setDept] = useState("");
  const [id, setId] = useState(1);
  const [salary, setSalary] = useState("");
  const handleSubmit = (event) => {
    event.preventDefault();
    const newEmployee = {id : id, name: name, age: age ,dept: dept,salary:salary}; 
    setEmployees([...employees, newEmployee]); 
    setName(''); 
    setAge('');
    setDept('');
    setSalary('');
    setId(id+1);
    alert("EMPLOYEES ARE ADDED SUCCESSFULLY!!") 
  };

  const handleDelete = (event,param) => {
    console.log(param);
    for (let i = 0; i < employees.length; i++) {
        if (employees[i].id === param) {
          employees = employees.splice(i,1);
          break;
        }
    }
  }

  return (
    <div>
        <h1>EMPLOYEE DETAILS</h1>
        <form onSubmit={handleSubmit}>
            <label>
            Name:
            <input type="text" value={name} onChange={(event) => setName(event.target.value)} />
            </label><br/><br/>
            <label>
            Age:
            <input type="number" value={age} onChange={(event) => setAge(event.target.value)} />
            </label><br/><br/>
            Designation:
            <input type="text" value={dept} onChange={(event) => setDept(event.target.value)} />
            <br/><br/>
            Salary:
            <input type = "number" value={salary} onChange={(event) => setSalary(event.target.value)}/>
            <br/><br/>
            <button type="submit">Add Employee</button>
            <br/><br/>
            <hr></hr>
        </form>
        <Fragment>
            <div>
                <Table striped bordered hover size = 'sm'>
                    <thead>
                        <tr>
                            <th>
                                Id
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Age
                            </th>
                            <th>
                                Department
                            </th>
                            <th>
                                Salary
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            employees && employees.length > 0
                            ?
                            employees.map((item) => {
                                return(
                                    <tr>
                                        <td>
                                            {item.id}
                                        </td>
                                        <td>
                                            {item.name}
                                        </td>     
                                        <td>
                                            {item.age}
                                        </td>   
                                        <td>
                                            {item.dept}
                                        </td> 
                                        <td>
                                            {item.salary}
                                        </td>  
                                        <td>
                                            <button onClick={event => handleDelete(event,item.id)}>Delete Employee</button>
                                        </td>
                                    </tr>
                                ) 
                            })
                            :
                            "NO EMPLOYEES FOUND"
                        } 
                    </tbody>
                </Table>
            </div>
        </Fragment>
    </div>
  );
}

export default Employees