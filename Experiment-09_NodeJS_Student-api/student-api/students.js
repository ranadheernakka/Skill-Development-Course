const express = require('express');
const router = express.Router();

let students = []; // In-memory DB (You can later use MongoDB/MySQL)

// Create student
router.post('/', (req, res) => {
  const student = {
    id: Date.now().toString(),
    name: req.body.name,
    age: req.body.age,
    course: req.body.course
  };
  students.push(student);
  res.status(201).json(student);
});

// Read all students
router.get('/', (req, res) => {
  res.json(students);
});

// Read student by ID
router.get('/:id', (req, res) => {
  const student = students.find(s => s.id === req.params.id);
  if (!student) return res.status(404).send('Student not found');
  res.json(student);
});

// Update student
router.put('/:id', (req, res) => {
  const student = students.find(s => s.id === req.params.id);
  if (!student) return res.status(404).send('Student not found');
  student.name = req.body.name;
  student.age = req.body.age;
  student.course = req.body.course;
  res.json(student);
});

// Delete student
router.delete('/:id', (req, res) => {
  students = students.filter(s => s.id !== req.params.id);
  res.send('Student deleted');
});

module.exports = router;
