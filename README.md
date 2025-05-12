# Inventory Management Backend

## Description

This project is the backend for an Inventory Management System. It provides RESTful APIs to manage products, categories, suppliers, purchase orders, and user authentication.

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

The application exposes various RESTful endpoints for managing resources. Key controllers include:

-   `AuthController`: Handles user registration and login.
-   `CategoryController`: Manages product categories.
-   `ProductController`: Manages products.
-   `SupplierContractController`: Manages supplier contracts.
-   `PurchaseOrderController`: Manages purchase orders.
-   `UserController`: Manages user-related operations.
-   `OfferController`: Manages offers.


For detailed API documentation, you can explore the Swagger UI (if configured) or refer to the controller classes in the `src/main/java/com/example/inventorymanagementbackend/controller` directory.

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
├── Dockerfile                # Docker configuration
├── pom.xml                   # Maven project configuration
├── mvnw                      # Maven wrapper script (Linux/macOS)
├── mvnw.cmd                  # Maven wrapper script (Windows)
├── src/
│   ├── main/
│   │   ├── java/             # Java source code
│   │   │   └── com/example/inventorymanagementbackend/
│   │   │       ├── config/       # Spring Security, JWT, Jackson configurations
│   │   │       ├── controller/   # REST API controllers
│   │   │       ├── dto/          # Data Transfer Objects
│   │   │       ├── exception/    # Custom exception handlers
│   │   │       ├── model/        # JPA entities
│   │   │       ├── repository/   # Spring Data JPA repositories
│   │   │       └── service/      # Business logic services
│   │   └── resources/
│   │       ├── application.properties # Application configuration
│   │       ├── db/migration/        # Flyway database migration scripts
│   │       ├── static/              # Static resources (e.g., CSS, JS)
│   │       └── templates/           # Server-side templates (if any)
│   └── test/
│       └── java/                 # Test source code
└── target/                     # Compiled code and packaged JAR
```

## Contributing

Please refer to the project's contribution guidelines if you wish to contribute.
