const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());

// Sample in-memory database
let students = [];
let idCounter = 1;

// Create student
app.post('/api/students', (req, res) => {
  const { name, age, course } = req.body;
  const student = { id: idCounter++, name, age, course };
  students.push(student);
  res.status(201).json(student);
});

// Read all students
app.get('/api/students', (req, res) => {
  res.json(students);
});

// Read single student
app.get('/api/students/:id', (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (!student) return res.status(404).send('Student not found');
  res.json(student);
});

// Update student
app.put('/api/students/:id', (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (!student) return res.status(404).send('Student not found');
  const { name, age, course } = req.body;
  student.name = name;
  student.age = age;
  student.course = course;
  res.json(student);
});

// Delete student
app.delete('/api/students/:id', (req, res) => {
  const index = students.findIndex(s => s.id === parseInt(req.params.id));
  if (index === -1) return res.status(404).send('Student not found');
  const deleted = students.splice(index, 1);
  res.json(deleted[0]);
});

// Start server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
