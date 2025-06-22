// Ensure the script runs only after DOM is fully loaded
document.addEventListener("DOMContentLoaded", function () {
    // Attach event listener to the registration form
    const registrationForm = document.getElementById("registrationForm");
    if (registrationForm) {
      registrationForm.addEventListener("submit", function (event) {
        if (!validateRegistrationForm()) {
          event.preventDefault();
        }
      });
    }
    // Attach event listener to the login form
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
      loginForm.addEventListener("submit", function (event) {
        if (!validateLoginForm()) {
          event.preventDefault();
        }
      });
    }
  
    // Display the logged-in user's name
    displayUserProfile();
  });
  // Validate and Store Registration Data
  function validateRegistrationForm() {
    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();
    let email = document.getElementById("email").value.trim();
    let phone = document.getElementById("phno").value.trim();
    let address = document.getElementById("address").value.trim();
    let gender = document.querySelector('input[name="gender"]:checked');
    let languages = document.querySelectorAll('input[name="language"]:checked');
  
    // Email Validation
    let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  
    // Phone Number Validation (Must be 10 Digits)
    let phonePattern = /^[0-9]{10}$/;
  
   // Error messages
    if (username === "") {
      alert("Username is required.");
      return false;
    }
    if (password.length < 6) {
      alert("Password must be at least 6 characters long.");
      return false;
    }
    if (!emailPattern.test(email)) {
      alert("Enter a valid email address.");
      return false;
    }
    if (!phonePattern.test(phone)) {
      alert("Enter a valid 10-digit phone number.");
      return false;
    }
    if (!gender) {
      alert("Please select a gender.");
      return false;
    }
    if (languages.length === 0) {
      alert("Please select at least one language.");
      return false;
    }
    if (address === "") {
      alert("Address is required.");
      return false;
    }
  
    // Store user data
    let userData = {
      username: username,
      password: password,
      email: email,
      phone: phone,
      gender: gender.value,
      languages: Array.from(languages).map((lang) => lang.value),
      address: address,
    };
  
    localStorage.setItem(username, JSON.stringify(userData)); // Store user data
    alert("Registration successful!");
    window.location.href = "login.html"; // Redirect to login page
    return true;
  }
  
  // Validate Login Credentials
  function validateLoginForm() {
    let username = document.getElementById("loginUsername").value.trim();
    let password = document.getElementById("loginPassword").value.trim();
  
    let storedUser = localStorage.getItem(username);
    if (!storedUser) {
      alert("User not found! Please register first.");
      return false;
    }
  
    let userData = JSON.parse(storedUser);
    if (userData.password !== password) {
      alert("Incorrect password!");
      return false;
    }
  
    // Save logged-in user session
    localStorage.setItem("loggedInUser", username);
    alert("Login successful!");
    window.location.href = "index.html"; // Redirect to homepage
    return true;
  }
  
  // Display Logged-in Username (Fixing the error)
  function displayUserProfile() {
    let loggedInUser = localStorage.getItem("loggedInUser");
    let profileElement = document.getElementById("userProfile");
  
    if (loggedInUser && profileElement) {
      profileElement.innerText = "Welcome, " + loggedInUser + "!";
    }
  }
  
  //  Logout Function
  function logout() {
    localStorage.removeItem("loggedInUser");
    alert("Logged out successfully!");
    window.location.href = "login.html";
  }
  