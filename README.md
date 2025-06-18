# Java Login Application

A simple Java web application with login functionality for Jenkins CI/CD demonstration.

## Project Structure

```
java-login-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── login/
│   │   │               ├── dao/
│   │   │               │   └── UserDAO.java
│   │   │               ├── model/
│   │   │               │   └── User.java
│   │   │               └── servlet/
│   │   │                   ├── LoginServlet.java
│   │   │                   └── LogoutServlet.java
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── login.jsp
│   │       └── welcome.jsp
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── login/
│                       ├── dao/
│                       │   └── UserDAOTest.java
│                       └── servlet/
│                           └── LoginServletTest.java
└── pom.xml
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Jenkins with Maven integration

## Building the Project

To build the project, run:

```bash
mvn clean package
```

## Running Tests

To run the tests, execute:

```bash
mvn test
```

## Jenkins Integration

1. Create a new Maven project in Jenkins
2. Configure the SCM to point to your repository
3. Set the Maven goals to `clean package`
4. Configure post-build actions to publish JUnit test results and JaCoCo coverage reports

## Default Users

The application comes with two pre-configured users:

1. Username: `admin`, Password: `admin123`
2. Username: `user`, Password: `user123`

## License

This project is open source and available under the MIT License.
