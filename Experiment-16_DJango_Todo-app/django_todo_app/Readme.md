---

# Skill Development Lab – Full Stack Experiments

---
Welcome to the **Skill Development Lab** repository!  
This collection contains **16 hands-on experiments** designed to help students and beginners learn modern web and software development skills across **Frontend, Backend, and Full Stack** technologies.

Each folder contains code and files for a specific experiment, named accordingly.

---

## What You’ll Learn

- Frontend Development  
- Responsive Web Design  
- JavaScript & ES6  
- Java & MySQL (CRUD)  
- Java Servlet (MVC)  
- Session Management  
- Node.js (REST APIs, Authentication)  
- React.js (SPA, Routing, Services)  
- Django (Python Full-Stack)  
- OpenWeatherMap API Integration  
- Chart.js (Data Visualization)  

---

## List of Experiments & Technologies Used

| S.no | Experiment             | Description                         | Technology                  |
|-------|-----------------------|-----------------------------------|-----------------------------|
| 01    | Shopping Cart – CSS     | Basic shopping cart using Flex & Grid | HTML, CSS3                |
| 02    | Shopping Cart – Bootstrap | Responsive cart using Bootstrap   | HTML, Bootstrap             |
| 03    | Form Validation        | Client-side form validation         | JavaScript                  |
| 04    | Weather Info App       | Fetch weather data & show graph     | ES6, Fetch API, Chart.js    |
| 05    | Java CRUD              | Perform Create, Read, Update, Delete | Java, JDBC, MySQL         |
| 06    | Servlet Controller     | Connect frontend to DB using Servlet | Java Servlets, JSP         |
| 07    | Session Management     | User session tracking               | Cookies, HTTP Session       |
| 08    | NodeJS Server          | Custom server, use modules          | Node.js, HTTP, OS, path     |
| 09    | Student API            | RESTful API to manage students      | Node.js, Express            |
| 10    | Auth API               | JWT-based secure endpoints          | Node.js, Express, JWT       |
| 11    | React App – Student Mgmt | SPA with routing & forms           | React.js, React Router      |
| 12    | React Weather App      | Fetch & graph weather data          | React, Chart.js, OpenWeatherMap |
| 13    | React TODO App         | Basic TODO with components          | React.js                   |
| 14    | Django – Student Mgmt  | Django app with routing             | Django (Python)             |
| 15    | Django Weather App     | Fetch & graph weather info          | Django, Chart.js            |
| 16    | Django TODO App        | Basic TODO app using Django         | Django (Python)             |

---

## How to Use This Repository

### 1. Clone the Repository

```bash
git clone https://github.com/swayamprakashm/Skill-Development-Lab.git

cd Skill-Development-Lab 
````

### 2. Open Specific Experiment

Use **VS Code** or any IDE of your choice to explore each folder.

### 3. Run Web Projects

* Open `index.html` directly in a browser *(for HTML/CSS/JS tasks)*
* Use `npm` / `node` for Node.js experiments
* Use `python manage.py runserver` for Django apps
* Use `javac` / `java` for Java-based tasks

---

## External Tools & APIs Used

* **OpenWeatherMap.org** – For real-time weather data
* **Chart.js** – For data visualization (React & Django)
* **MySQL / Oracle DB** – For backend Java persistence
* **JWT** – For API authentication in Node.js

---

## Author

**M Swayam Prakash**

Passionate about full-stack development and building impactful projects with modern web technologies.

---

## Suggestions

* **Beginners:** Start with Experiments 1–4 to get comfortable with HTML/CSS/JS
* **Intermediate:** Try Experiments 5–10 to build your backend skills
* **Advanced:** Explore React and Django projects (11–16)

---

## License

This repository is open for learning and educational use.

---
This project is **open-source** and free to use.

---

### **GitHub** 

[https://github.com/swayamprakashm](https://github.com/swayamprakashm)

---

---

## **Program 16 – Django TODO App**

---

### **AIM**

To develop a **TODO list application backend** using **Django**, allowing users to add, view, and manage tasks with a clean and functional web interface.

---

### **DESCRIPTION**

This experiment demonstrates how to build a server-rendered TODO application using Django. The app allows users to manage tasks—such as adding new tasks and viewing task lists—using Django’s powerful **Model-View-Template (MVT)** architecture.

It showcases key Django concepts like **models**, **views**, **templates**, **forms**, and **URL routing**. This project is ideal for beginners to learn about **Django’s ORM**, **template rendering**, and basic **backend development**.

---

### **PROJECT STRUCTURE**

```
django_todo_app/
│
├── todo_project/              # Project settings folder
│   ├── __init__.py
│   ├── settings.py            # Project configuration
│   ├── urls.py                # Root URL configuration
│   └── wsgi.py                # WSGI entry point
│
├── todo/                      # Main app folder
│   ├── migrations/
│   ├── templates/
│   │   └── todo/
│   │       └── index.html     # HTML template for the app
│   ├── __init__.py
│   ├── admin.py               # Admin interface
│   ├── apps.py
│   ├── models.py              # Task model
│   ├── views.py               # Logic for handling requests
│   └── urls.py                # URL routing for the app
│
├── db.sqlite3                 # SQLite database
├── manage.py                  # Django management script
└── README.md                  # Project documentation
```

---

### **INSTALLATION & SETUP**

#### **PREREQUISITES**

• Python 3.8+

• pip (Python package installer)

• VS Code or any preferred code editor

• Basic knowledge of Django

---

### **STEPS TO RUN THE PROJECT**

#### **1. Create Project and App**

```bash
django-admin startproject todo_project  
cd todo_project  
python manage.py startapp todo
```

#### **2. Define Model in `todo/models.py`**

```python
from django.db import models

class Task(models.Model):
    title = models.CharField(max_length=200)
    completed = models.BooleanField(default=False)

    def __str__(self):
        return self.title
```

#### **3. Create and Apply Migrations**

```bash
python manage.py makemigrations  
python manage.py migrate
```

#### **4. Set Up Views, Templates, and URLs**

* Write logic in `views.py` to render the task list.
* Create the template: `templates/todo/index.html`.
* Map URLs in `todo/urls.py` and include them in `todo_project/urls.py`.

#### **5. Run the Project**

```bash
python manage.py runserver
```

#### **6. Visit in Browser**

Open your browser and navigate to:

```
http://127.0.0.1:8000/
```

---

### **LICENSE**

This project is **open-source** and free to use.

---

### **Author**

• **N Ranadheer**

• GitHub: [https://github.com/ranadheernakka](https://github.com/ranadheernakka)

---
