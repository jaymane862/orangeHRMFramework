# OrangeHRM Test Automation Framework

## Overview

The **OrangeHRM Test Automation Framework** is a robust, scalable, and maintainable automation framework developed for testing the OrangeHRM web application. The framework is built using **Java**, **Selenium WebDriver**, **Cucumber BDD**, and **TestNG**, following the **Page Object Model (POM)** design pattern and industry best practices.

It is designed to automate end-to-end functional testing while supporting data-driven testing, reusable components, detailed reporting, logging, and Continuous Integration (CI/CD) with Jenkins.

---

## Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- Page Object Model (POM)
- Jenkins
- Git & GitHub
- Extent Reports
- Log4j
- WebDriverManager

---

## Features

- Behavior Driven Development (BDD) using Cucumber
- Page Object Model (POM) architecture
- Reusable utility methods
- Cross-browser support
- Maven dependency management
- Configurable test execution using property files
- Automatic WebDriver management
- Extent HTML Reporting
- Screenshot capture for failed test cases
- Logging using Log4j
- Jenkins CI/CD integration
- Git version control
- Easy maintenance and scalability

---

## Project Structure

```
orangeHRMFramework/
│
├── src
│   ├── main
│   │   └── java
│   │       ├── ObjectRepository.MOBILE
│   │       ├── ObjectRepository.WEB
│   │       
│   │
│   └── test
│       ├── java
│       │   ├── Common.Helpers
│       │   ├── Common.Runner
│       │   ├── Common.utils
|       |   └── Steps.Definitions 
│       │
│       └── resources
│           ├── Features
│           ├── extent.properties
│           └── extent-spark-config.xml
│
├── screenShots
├── target
├── Jenkinsfile
├── pom.xml
├── README.md
└── runConfig.prpperties
```

---

## Prerequisites

Before running the project, ensure the following are installed:

- Java JDK 17 or above
- Maven 3.8+
- Git
- Chrome / Edge / Firefox
- IDE (Eclipse or IntelliJ IDEA)

---

## Clone the Repository

```bash
git clone https://github.com/jaymane862/orangeHRMFramework.git
```

```bash
cd orangeHRMFramework
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run All Tests

```bash
mvn test
```

---

## Run Specific Cucumber Runner

```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

Example:

```bash
mvn test -Dcucumber.filter.tags="@Regression"
```

---

## Generate Reports

After execution, open the generated Extent Report:

```
target/test-output
    Spark.html
```

or

```
test-output/
```

---

## Jenkins Integration

The project contains a `Jenkinsfile` that supports automated execution through Jenkins.

Typical CI Pipeline:

- Pull latest code from GitHub
- Build project using Maven
- Execute automation suite
- Generate Extent Report
- Archive test reports

---

## Design Pattern

- Page Object Model (POM)
- Factory Design (Driver Initialization)
- Singleton (Configuration)
- Utility Classes
- Generic Wrapper Methods

---

## Reporting

- Extent Reports
- Console Logs
- Maven Surefire Reports
- Screenshots for failed test cases

---

## Version Control

This project uses Git for version control.

Common Git Commands:

```bash
git clone <repository-url>
git pull origin master
git checkout -b feature/new-feature
git add .
git commit -m "Added new feature"
git push origin feature/new-feature
```

---

## Future Enhancements

- Docker Integration
- Selenium Grid
- GitHub Actions
- Allure Reporting
- Database Validation
- API Automation Integration
- Parallel Execution
- Cloud Execution (BrowserStack/Sauce Labs)

---

## Author

**Jay Mane**

QA Automation Engineer

Specializing in Java, Selenium WebDriver, Cucumber BDD, TestNG, Jenkins, Maven, Git, and CI/CD automation frameworks.
