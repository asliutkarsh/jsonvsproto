# JSON vs Protocol Buffers

This repository demonstrates how to use JSON and Protocol Buffers (protobuf) for data serialization in Java. It features a simple User management system with basic operations such as adding, retrieving, and listing users. The project includes two controllers: one for JSON and another for Protocol Buffers, highlighting the differences in data serialization, performance, and payload size.

---

## Getting Started

### Prerequisites

- Java
- Maven

### Steps

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   ```
2. **Navigate to the project directory:**
   ```bash
   cd jsonvsproto
   ```
3. **Build the project using Maven:**
   ```bash
   mvn clean package
   ```
4. **Run the application:**
   ```bash
   java -jar target/json-vs-protobuf-1.0-SNAPSHOT.jar
   ```
5. The application will start on port `8080`. You can access the endpoints using Postman, curl, or any HTTP client.

---

## API Endpoints

### JSON Endpoints

- **Add User**
  - `POST /api/users`
  - Request Body: JSON object with user details
  - Response: JSON object with the added user details

- **Get User**
  - `GET /api/users/{id}`
  - Response: JSON object with user details

- **List Users**
  - `GET /api/users`
  - Response: JSON array of user objects

### Protobuf Endpoints

- **Add User**
  - `POST /api/users/proto`
  - Request Body: Protobuf-encoded user object
  - Response: Protobuf-encoded user object with the added user details

- **Get User**
  - `GET /api/users/proto/{id}`
  - Response: Protobuf-encoded user object with user details

- **List Users**
  - `GET /api/users/proto`
  - Response: Protobuf-encoded list of user objects

---

## Example Usage

### JSON Example

**Request:**
```bash
curl --location 'http://localhost:8080/api/users' \
  --header 'Content-Type: application/json' \
  --data-raw '{"name": "John Doe", "email": "john@example.com", "age": 25}'
```

**Response:**
```json
{
  "id": 2,
  "name": "John Doe",
  "email": "john@example.com",
  "age": 25
}
```

This command sends a POST request to the `/api/users` endpoint with a JSON object in the request body. The response will be a JSON object with the added user details.

---

### Protobuf Example

**Request:**
```bash
curl --location 'http://localhost:8080/api/users/proto' \
  --header 'Content-Type: application/x-protobuf' \
  --header 'Accept: application/x-protobuf' \
  --data-binary '@/{DIR}/jsonvsproto/user.bin'
```

**Raw Response:**
```
John Doejohn@example.com 
```

This command sends a POST request to the `/api/users/proto` endpoint with a Protobuf-encoded user object in the request body. The response will be a Protobuf-encoded user object.

> **Note:** You can find the `user.bin` file in the source folder after running the application. The generation command is in the `Main` class.

---

## Dependencies

- Spring Boot (REST API)
- Protocol Buffers (data serialization)
- Jackson (JSON serialization/deserialization)
- Lombok (boilerplate reduction)

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contributing

Contributions are welcome! If you find a bug or have a feature request, please open an issue or submit a pull request.