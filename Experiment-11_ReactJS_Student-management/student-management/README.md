PROGRAM 11 – Student Management System with React.

AIM
To develop a student management system frontend using React, implementing navigation through registration, login, contact, and about pages using React Router.

DESCRIPTION
This experiment demonstrates how to build a single-page application (SPA) using React.js. The application simulates a student management system with basic navigation between multiple pages. It leverages React Router for client-side routing and component-based architecture for modular design. This project is ideal for beginners to understand the fundamentals of React, routing, JSX, component communication, and styling with CSS.

PROJECT STRUCTURE
student-management-react/
│
├── public/
│   └── index.html           # HTML template
│
├── src/
│   ├── components/
│   │   ├── About.js         # About page component
│   │   ├── Contact.js       # Contact page component
│   │   ├── Login.js         # Login page component
│   │   └── Registration.js  # Registration page component
│   ├── App.js               # Main app with routing
│   ├── App.css              # Styling for the app
│   ├── index.js             # Entry point of the React app
│   └── index.css            # Global styles
│
├── package.json             # Project metadata and dependencies
└── README.md                # Project documentation


 

INSTALLATION & SETUP
PREREQUISITES
•	Node.js & npm
•	VS Code or any code editor
•	Basic knowledge of React

STEPS TO RUN THE PROJECT
1.Create Project using Create React App
npx create-react-app student-management-react
cd student-management-react

2.Install React Router DOM
npm install react-router-dom

3.Create Component Files
Inside src/components/, create:
•	About.js
•	Contact.js
•	Login.js
•	Registration.js
Each should return basic JSX content.

4.Update App.js to Implement Routing
Use BrowserRouter, Routes, and Route from react-router-dom to route pages.

5.Run the Project
npm start

6.Visit in Browser
http://localhost:3000

LICENSE
This project is licensed under the MIT License.
