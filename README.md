# Login Application
Written using spring boot

## Branches
1. Main
    * All features except for password encryption
2. Spring-security
    * Password encryption done; integrating all features with spring security
    * I attempted to integrate the industry-standard Spring Security framework for this challenge after completing a basic version. 2 bug fixing are still in progress (preventing redirected to log in page again after authorization & displaying error message during login)

## Features
* Manager's restricted page with interceptor to prevent direct URL access
* Chinese and English option
* Login validation and error messages. Implemented server-side session. 
* Database: h2
* MVC with Service Interfaces

## Login Credentials
1. Manager
Email: tom.tan@abc.com | Password: password
2. Employee
Email: larry.lee@abc.com | Password: password

