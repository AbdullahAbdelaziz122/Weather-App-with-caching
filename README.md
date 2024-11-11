# Weather App with Spring Boot and Caching with Redis


This project is a simple Weather App built with Spring Boot that fetches real-time weather data from the RapidAPI Weather API. It incorporates caching with Redis to optimize performance by reducing API calls for frequently requested weather data.

## Features

- Fetch current weather data for a specified city.
- Cache API responses using Redis to improve efficiency and reduce API call limits.
- User-friendly error handling for scenarios such as invalid city names or API connectivity issues.

## Prerequisites

- **Java 17** or newer
- **Spring Boot 3** or newer
- **Redis** installed and running on your system or accessible via a cloud service
- **RapidAPI account** for accessing the Weather API
- **Maven** for dependency management

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/weather-app-spring-redis.git
cd weather-app-spring-redis
```

### 2. Set up environment variables

Add to  `application.properties` or .yml file in the root directory and add the following environment variables:

```plaintext
RAPIDAPI_KEY=your_rapidapi_key
RAPIDAPI_HOST=open-weather13.p.rapidapi.com
REDIS_HOST=localhost
REDIS_PORT=6379
```

### 3. Install Redis (if not already installed)


### 4. Build and Run the Project

Compile and run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

The app should now be running at `http://localhost:8080`.

## API Endpoints

### 1. Fetch Weather Data

- **URL**: `/weatherApp/fetch/{city}`
- **Method**: `GET`
- **Description**: Fetches current weather data for the specified city, e.g., `weatherApp/fetch/london`.
- **Cache**: Results are cached with Redis for the specified duration (default 10 minutes).

### Example

```bash
curl http://localhost:8080/weatherApp/fetch/london
```

### Response

```json
{
  "city": "London",
  "temperature": "15°C",
  "description": "Partly cloudy",
  "humidity": "78%",
  "windSpeed": "10 km/h"
}
```

## Configuration

### Redis Configuration

The Redis configuration is defined in `application.properties`:

```properties
spring.redis.host=${REDIS_HOST:localhost}
spring.redis.port=${REDIS_PORT:6379}
```

## Future Improvements

- **Expand API Support**: Add endpoints for more weather data (e.g., 7-day forecast).
- **Location Autocomplete**: Implement a feature for city name suggestions.
- **Real-time Updates**: Consider implementing real-time updates for cached data based on user demand.
