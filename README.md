# Inventory Management Backend

## Description

This project is the backend for a comprehensive Inventory Management System. It provides a robust set of RESTful APIs designed to manage various aspects of inventory, including but not limited to:
- Product cataloging and categorization.
- Supplier information and contract management.
- Purchase order creation and tracking.
- User authentication and authorization for secure access.
The system aims to streamline inventory operations, improve data accuracy, and provide a scalable backend solution.

## Technologies Used

- Java 17
- Spring Boot
- Spring Security (with JWT for authentication)
- Maven
- H2 Database (for development/testing, can be configured for other databases)
- Flyway (for database migrations)
- Docker

## Setup and Installation

### Prerequisites

- Java JDK 17 or later
- Maven
- Docker Desktop (optional, for containerized deployment)

### Running Locally

1.  **Clone the repository (if applicable):**
    ```bash
    # git clone <repository-url>
    # cd Inventory-Management-backend
    ```
2.  **Build the project:**
    ```bash
    ./mvnw clean install
    ```
3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

### Running with Docker

1.  **Ensure Docker Desktop is running.**
2.  **Build the Docker image:**
    Navigate to the project root directory (`Inventory-Management-backend`) where the `Dockerfile` is located and run:
    ```powershell
    docker build -t inventory-management-backend .
    ```
3.  **Run the Docker container:**
    ```powershell
    docker run -p 8080:8080 inventory-management-backend
    ```
    The application will be accessible at `http://localhost:8080`.

## API Endpoints

The application exposes various RESTful endpoints, typically under the `/api/v1` base path, for managing resources. All request and response bodies are in JSON format.

Key controllers include:

-   `AuthController` (`/api/v1/auth`): Handles user registration (`/register`) and login (`/login`) to obtain JWT tokens.
-   `CategoryController` (`/api/v1/categories`): Manages product categories (CRUD operations).
-   `ProductController` (`/api/v1/products`): Manages products, including searching and filtering.
-   `SupplierContractController` (`/api/v1/supplier-contracts`): Manages supplier contracts.
-   `PurchaseOrderController` (`/api/v1/purchase-orders`): Manages purchase orders.
-   `UserController` (`/api/v1/users`): Manages user-related operations, such as fetching user details.
-   `OfferController` (`/api/v1/offers`): Manages special offers or discounts on products.

For detailed API documentation, including request/response schemas and specific endpoint paths, you can explore the Swagger UI (if configured, typically at `/swagger-ui.html`) or refer to the controller classes in the `src/main/java/com/example/inventorymanagementbackend/controller` directory.

## Security

-   **Authentication**: Implemented using Spring Security with JSON Web Tokens (JWT). Users authenticate via the `/api/v1/auth/login` endpoint to receive a JWT.
-   **Authorization**: Secured endpoints require a valid JWT in the `Authorization` header (e.g., `Authorization: Bearer <token>`). Role-based access control can be configured to restrict access to certain APIs based on user roles.

## Configuration

Key application configurations are managed in `src/main/resources/application.properties`. This includes:
-   Server port (e.g., `server.port=8080`).
-   Database connection details (URL, username, password for H2 or other configured databases).
-   JWT secret key and expiration time.
-   Flyway settings.
-   Logging levels.

## Database Migrations

Database schema migrations are handled by Flyway. Migration scripts are located in `src/main/resources/db/migration`.

## Running Tests

To run the automated tests:

```bash
./mvnw test
```

## Project Structure

```
Inventory-Management-backend/
├── Dockerfile                # Docker configuration for containerizing the application
├── pom.xml                   # Maven project configuration, dependencies, and build settings
├── mvnw                      # Maven wrapper script (Linux/macOS)
├── mvnw.cmd                  # Maven wrapper script (Windows)
├── src/
│   ├── main/
│   │   ├── java/             # Core Java source code for the application
│   │   │   └── com/example/inventorymanagementbackend/
│   │   │       ├── config/       # Spring Security, JWT, Jackson, and other bean configurations
│   │   │       ├── controller/   # REST API controllers handling HTTP requests
│   │   │       ├── dto/          # Data Transfer Objects for API request/response bodies
│   │   │       ├── exception/    # Custom exception classes and global exception handlers
│   │   │       ├── model/        # JPA entities representing database tables
│   │   │       ├── repository/   # Spring Data JPA repositories for database interactions
│   │   │       └── service/      # Business logic and service layer components
│   │   └── resources/
│   │       ├── application.properties # Main application configuration file
│   │       ├── db/migration/        # Flyway database migration SQL scripts (versioned)
│   │       ├── static/              # Static web resources (e.g., CSS, JavaScript, images)
│   │       └── templates/           # Server-side view templates (e.g., Thymeleaf, if used)
│   └── test/
│       └── java/                 # Java source code for unit and integration tests
└── target/                     # Directory for compiled code, packaged JAR/WAR files, and build artifacts
```

## Contributing

Please refer to the project's contribution guidelines if you wish to contribute.
