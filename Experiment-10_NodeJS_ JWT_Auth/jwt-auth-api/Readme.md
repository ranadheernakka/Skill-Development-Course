PROGRAM 10 – Student API with JWT Authentication

AIM
To develop a secure RESTful Student API using Node.js, Express, MongoDB, and JWT for authentication.

DESCRIPTION
This experiment demonstrates how to build a secure REST API using Node.js and Express with JWT-based user authentication. The API allows authenticated users to perform CRUD (Create, Read, Update, Delete) operations on student records. MongoDB is used for persistent data storage. JWT tokens ensure that only authorized users can access protected routes. This project illustrates best practices for secure API development, including middleware use, route protection, and token-based authentication.

PROJECT STRUCTURE
student-api-jwt/
│
├── controllers/
│ ├── authController.js # Handles login logic
│ └── studentController.js # Handles CRUD logic
│
├── middleware/
│ └── authMiddleware.js # JWT token verification
│
├── models/
│ ├── User.js # User schema
│ └── Student.js # Student schema
│
├── routes/
│ ├── authRoutes.js # /api/login
│ └── studentRoutes.js # /api/students
│
├── .env # Environment variables
├── app.js # Main application file
├── package.json # Project metadata and dependencies
└── README.md # Project documentation

 
INSTALLATION & SETUP
PREREQUISITES
•	Node.js  
•	MongoDB (Cloud or local)  
•	VS Code or any text editor  
•	Postman (for testing)

STEPS TO RUN THE PROJECT
1.Clone the Repository or Create Folder
mkdir student-api-jwt
cd student-api-jwt

2.Initialize Node.js Project
npm init -y

3.Install Required Packages
npm install express mongoose jsonwebtoken dotenv bcryptjs

4.Create the Project Files & Folder Structure
Follow the structure mentioned above.
5Set up Environment File
Create a .env file in the root with the following:
PORT=5000
MONGO_URI=your_mongodb_connection_string
JWT_SECRET=your_secret_key

node app.js
6.Start the Server

7.Test API in Postman
Access routes like:
http://localhost:5000/api/login
http://localhost:5000/api/students

API ENDPOINTS
➤ Login
POST /api/login
Request Body:
{
  "email": "user@example.com",
  "password": "yourpassword"
}

➤ Get All Students
GET /api/students
Authorization: Bearer Token required
➤ Add a Student
POST /api/students
Authorization: Bearer Token required
Body:
{
  "name": "Swayam",
  "age": 21,
  "course": "Mathematics"
}

➤ Update Student by ID
PUT /api/students/:id
Authorization: Bearer Token required
➤ Delete Student by ID
DELETE /api/students/:id
Authorization: Bearer Token required

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
