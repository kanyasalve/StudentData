Students
Create Student

Method: POST
URL: http://localhost:8080/students/create-student
Request Body:

{
  "name": "Kanyakumari",
  "address": " pune "
}

get all student
Method:GET
URL: http://localhost:8080/students/get-of-all-students

Subjects
Method: POST
URL: http://localhost:8080/subjects/subjects
Request Body:

{
  "name": "java"
}

get all subjects 
Method: GET
URL:http://localhost:8080/subjects/list-of-all-subjects

Security
Current Status
Security Features: The project is designed to include JWT-based authentication and role management. However, the security configuration is not yet implemented.
Roles and Authentication: While the design includes roles for student and admin and a login endpoint for JWT tokens, the actual security mechanisms are incomplete.
Note: The following features are not yet implemented:

JWT-based authentication and authorization are not functional.
Role-based access control is not enforced.
Secure password handling and token management are not in place.
