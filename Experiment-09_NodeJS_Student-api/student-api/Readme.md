PROGRAM 9 – RESTful Student API with Node.js and Express

AIM
To implement a RESTful API for managing student data using Node.js and Express.

DESCRIPTION
This experiment demonstrates how to build a simple REST API using Node.js and Express. The API allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. It simulates a backend service that could be extended with a database in a real-world scenario. Data is stored in-memory for simplicity. This lightweight implementation is ideal for learning API fundamentals, including route handling, JSON processing, and basic REST design. The solution uses Express.js for backend routing and Node.js for the runtime environment.

PROJECT STRUCTURE
student-api/
│
├── server.js # Main server file
├── package.json # Project metadata and dependencies
├── node_modules/ # Installed npm modules
└── README.md # Project documentation

 

INSTALLATION & SETUP
PREREQUISITES
•	Node.js
•	VS Code or any text editor

STEPS TO RUN THE PROJECT
1. Clone or Create Project Folder  
   mkdir student-api
   cd student-api

2.Initialize Node.js Project
npm init -y

3.Install Express
npm install express

4.Create server.js File
Write your API logic in server.js (CRUD for students).
5.Start the Server
node server.js

6.Visit in Browser
http://localhost:3000/api/students

API ENDPOINTS
Get All Students
GET /api/students
Add a Student
POST /api/students
Body:
{
  "name": "Swayam",
  "age": 21,
  "course": " Mathematics"
}

Update Student by ID
PUT /api/students/:id
Delete Student by ID
DELETE /api/students/:id

SAMPLE OUTPUT
[
  {
    "id": 1,
    "name": "Swayam",
    "age": 21,
    "course": "Mathematics"
  }
]


LICENSE
This project is licensed under the MIT License.
