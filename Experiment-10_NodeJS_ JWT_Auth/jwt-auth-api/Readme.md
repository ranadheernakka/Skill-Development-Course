---

## **PROGRAM 10 – Student API with JWT Authentication**

---

### **AIM**

To develop a secure **RESTful Student API** using **Node.js**, **Express**, **MongoDB**, and **JWT** for authentication.

---

### **DESCRIPTION**

This experiment demonstrates how to build a secure REST API using **Node.js** and **Express** with **JWT-based user authentication**. The API allows **authenticated users** to perform **CRUD (Create, Read, Update, Delete)** operations on student records.

**MongoDB** is used for persistent data storage, and **JWT tokens** ensure that only authorized users can access protected routes. This project illustrates **best practices** for secure API development, including:

* Middleware usage
* Route protection
* Token-based authentication

---

### **PROJECT STRUCTURE**

```
student-api-jwt/
│
├── controllers/
│   ├── authController.js         # Handles login logic
│   └── studentController.js      # Handles CRUD logic
│
├── middleware/
│   └── authMiddleware.js         # JWT token verification
│
├── models/
│   ├── User.js                   # User schema
│   └── Student.js                # Student schema
│
├── routes/
│   ├── authRoutes.js             # /api/login
│   └── studentRoutes.js          # /api/students
│
├── .env                          # Environment variables
├── app.js                        # Main application file
├── package.json                  # Project metadata and dependencies
└── README.md                     # Project documentation
```

---

### **INSTALLATION & SETUP**

#### **PREREQUISITES**

• Node.js

• MongoDB (local or cloud)

• VS Code or any preferred editor

• Postman (for testing the API)

---

### **STEPS TO RUN THE PROJECT**

1. **Clone the Repository or Create the Project Folder**

```bash
mkdir student-api-jwt  
cd student-api-jwt
```

2. **Initialize Node.js Project**

```bash
npm init -y
```

3. **Install Required Packages**

```bash
npm install express mongoose jsonwebtoken dotenv bcryptjs
```

4. **Create the Project Files & Folder Structure**
   Follow the structure listed above.

5. **Set Up the Environment File**
   Create a `.env` file in the root directory and add:

```
PORT=5000  
MONGO_URI=your_mongodb_connection_string  
JWT_SECRET=your_secret_key
```

6. **Start the Server**

```bash
node app.js
```

7. **Test API in Postman**
   Access API routes like:

* `http://localhost:5000/api/login`
* `http://localhost:5000/api/students`

---

### **API ENDPOINTS**

####  **Login**

```http
POST /api/login
```

**Request Body:**

```json
{
  "email": "user@example.com",
  "password": "yourpassword"
}
```

####  **Get All Students**

```http
GET /api/students
```

**Authorization:** Bearer Token required

####  **Add a Student**

```http
POST /api/students
```

**Authorization:** Bearer Token required
**Request Body:**

```json
{
  "name": "ranadheer",
  "age": 19,
  "course": "Mathematics"
}
```

####  **Update Student by ID**

```http
PUT /api/students/:id
```

**Authorization:** Bearer Token required

####  **Delete Student by ID**

```http
DELETE /api/students/:id
```

**Authorization:** Bearer Token required

---

### **SAMPLE OUTPUT**

```json
[
  {
    "id": 1,
    "name": "ranadheer",
    "age": 19,
    "course": "Mathematics"
  }
]
```

---

### **LICENSE**

This project is **open-source** and free to use.

---

### **Author**

• **N Ranadheer**

• GitHub: [https://github.com/ranadheernakka](https://github.com/ranadheernakka)

---
