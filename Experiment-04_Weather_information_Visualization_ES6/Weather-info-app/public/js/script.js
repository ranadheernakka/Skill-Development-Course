 //🔹 Select the button element from HTML by its ID
const btn = document.getElementById("btn");
// 🔹 Add an event listener to the button to trigger weather fetching when clicked
btn.addEventListener("click", async () => {
  // Using async/await to fetch weather data asynchronously
const city = document.getElementById("city").value; 
// Get city name entered by the user
 const apiKey = "171e009cae7e126fcbcec49c3a5cee6a"; 
// OpenWeatherMap API Key
const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`;

  try {
    const response = await fetch(url); 
// 🔹 Fetch data from the API (returns a Promise)
    const data = await response.json(); // 🔹 Convert the response to JSON format

// 🔹 Check if city is not found (API returns "404" when city is invalid)
    if (data.cod === "404") {
      document.getElementById("result").innerHTML =
        "City not found. Try again!";
      return; // Stop execution if city is invalid
    }

    displayWeather(data); // 🔹 Call function to display weather details
    displayGraph(data.main.temp, data.main.feels_like, data.main.humidity); // 🔹 Call function to display a bar chart
  } catch (error) {
    console.error("Error fetching weather:", error); // 🔹 Handle any errors
  }
});

// 🔹 Function to display weather information dynamically in HTML
const displayWeather = (data) => {
  const result = document.getElementById("result");
  result.innerHTML = `
        <h2 style="font-family: 'Alkatra', serif;">Weather of ${data.name}</h2>
        <h4>Temperature: ${Math.round(
          data.main.temp - 273.15
        )}°C</h4> <!-- Convert Kelvin to Celsius -->
        <h4>Feels like: ${Math.round(data.main.feels_like - 273.15)}°C</h4>
        <h4>Humidity: ${data.main.humidity}%</h4>
        <h4>Pressure: ${data.main.pressure} hPa</h4>
        <h4>Wind speed: ${data.wind.speed} m/s</h4>
        <h4>Wind direction: ${data.wind.deg} degrees</h4>
    `;
};

// 🔹 Function to create and display a weather chart using Chart.js
const displayGraph = (temp, feelsLike, humidity) => {
  const ctx = document.getElementById("weatherChart").getContext("2d"); // 🔹 Get the canvas element from HTML

  new Chart(ctx, {
    type: "bar", // 🔹 Define the chart type as a bar graph
    data: {
      labels: ["Temperature (°C)", "Feels Like (°C)", "Humidity (%)"], // 🔹 Labels for X-axis
      datasets: [
        {
          label: "Weather Data",
          data: [
            Math.round(temp - 273.15), // Convert temperature from Kelvin to Celsius
            Math.round(feelsLike - 273.15),
            humidity,
          ],
          backgroundColor: ["red", "orange", "blue"], // 🔹 Colors for bars
          borderColor: ["darkred", "darkorange", "darkblue"], // 🔹 Border colors
          borderWidth: 1, // 🔹 Thickness of the bar border
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true, // 🔹 Ensure Y-axis starts from 0
        },
      },
    },
  });
};