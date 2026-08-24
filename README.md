# CS 320 Software Testing, Automation, and Quality Assurance Portfolio

This repository contains selected artifacts from CS 320 that demonstrate my work with software testing, automation, and quality assurance. The contact service files show my ability to create and test back-end service logic using JUnit. The Project Two summary and reflections report explains my testing approach, testing techniques, and how I applied requirements-based testing throughout the course projects.

## Portfolio Artifacts

- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`
- `CS320_Project_Two_Summary_And_Reflections_Report.docx`

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I can ensure that my code is functional by writing tests that directly match the software requirements. In this project, I tested valid inputs, invalid inputs, boundary values, null values, and required field limits. To support security, I can validate input, avoid accepting unsafe or unexpected data, and review code carefully before release.

### How do I interpret user needs and incorporate them into a program?

I interpret user needs by turning requirements into clear program rules. For example, if a user requires a contact ID to be unique and no longer than 10 characters, I treat that as both a coding requirement and a testing requirement. This helps ensure the program matches what the customer asked for instead of only what the developer assumed.

### How do I approach designing software?

I approach software design by breaking the problem into smaller parts with clear responsibilities. For this project, the contact object stored contact data, while the contact service handled adding, deleting, and updating contacts. This made the code easier to test, maintain, and improve. I also used testing as part of the design process so that requirements, code, and test cases stayed connected.
