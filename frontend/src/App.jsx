import { useState } from "react";

function App()
{
    // {"id":1,"name":"diya","course":"cse"}
    const[ students,setStudents]=useState({}); //used to store data

    const getStudentData=async()=>{
        const response=await fetch('http://localhost:8080/students');
        const data=await response.json();
        setStudents(data);
    }
    return(
        <div>
            <button onClick={getStudentData}>
                Get Student data
            </button>
            <h1>This is the student data:</h1>
            <h2>{students.name}</h2>
            <h2>{students.id}</h2>
            <h2>{students.course}</h2>
        </div>
    );
}
export default App;