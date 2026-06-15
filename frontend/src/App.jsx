import { use } from "react";
import { useState } from "react";

function App() {
  // {"id":1,"name":"diya","course":"cse"}
  const [students, setStudents] = useState([]); //used to store data
  const [count, setCount] = useState(0);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const login = async () => {
    const response = await fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    });
    alert("Login Succesfully");
  };
  const getStudentData = async () => {
    const response = await fetch("http://localhost:8080/students");
    const data = await response.json();
    setStudents(data);
  };
  const fetchTotalStudentCount = async () => {
    const response = await fetch("http://localhost:8080/students/count");
    const data = await response.json();
    setCount(data);
  };
  return (
    <div>
      <button onClick={getStudentData}>Get Student data</button>
      <h1>This is the student data:</h1>
      <ul>
        {students.map((Student) => (
          <li Key={Student.id}>
            {Student.name}.{Student.course}
          </li>
        ))}
      </ul>
      <button onClick={fetchTotalStudentCount}>Get Total Student Count</button>
      <p>total count:{count}</p>
      <input
        placeholder="Enter username"
        onChange={(e) => setUsername(e.target.value)}
      ></input>
      <input
        type="password"
        placeholder="Enter Password"
        onChange={(e) => setPassword(e.target.value)}
      ></input>
      <button onClick={login}>Login</button>
    </div>
  );
}
export default App;
