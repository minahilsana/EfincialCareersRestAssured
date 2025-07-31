# EfinancialCareers REST Assured API Automation

This project automates the job application workflow for [EfinancialCareers](https://www.efinancialcareers.com/) using **Java**, **REST Assured**, and **JUnit**.  
It includes multipart upload automation (e.g., resume upload) and demonstrates real-world API testing with structured OOP design.

---

## Features

- Token-based authentication using JSON response parsing
- Multipart file upload flow to Filestack
- MD5 content hash generation
- Session storage of dynamic response values
- Modular OOP structure with `client`, `request`, `response`, `endpoints`, `test`, and `utils` packages
- Logging with Lombok and SLF4J
- Assertions using JUnit

---

## Project Structure
src/
├── main/
│ └── java/org/example/
│ ├── client/ # Base API client class
│ ├── endpoints/ # Endpoint-specific request handlers
│ ├── request/ # POJOs for request payloads
│ ├── response/ # POJOs for parsing API responses
│ └── utils/ # Utilities (e.g., SessionStorage)
└── test/
└── java/org/example/test/ # JUnit test classes


## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/minahilsana/EfincialCareersRestAssured.git
   cd EfincialCareersRestAssured
   ```
2. Build the project:
```bash
 mvn clean install
```
3. Run the "FullFlowTest.java" file

## Related Repositories
Postman Version of This Automation
You can find the same workflow automated in Postman here:

https://github.com/minahilsana/EfincialCareersPostmanCollection 


