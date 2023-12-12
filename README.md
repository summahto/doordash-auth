# Authentication, Authorization and Session Management
We have different pages in the UI which are accessible to different users based on their roles.
All users can see the homepage, even if they are unauthenticated.

Currently we have 3 roles available :
   
   User : This role has access only to the server page.
   Manager : This role has access to server page and the client page.
   Admin : This role has access to all the pages, server, client and Extra page


Session Management : using Json Web Tokens. 
Authentication we have 2 options : Credentials and GitHub (using OAuth)

<img width="840" alt="Architecture Diagram" src="https://github.com/summahto/doordash-auth/assets/20516618/93fb8d87-128d-44ac-921c-0a85d2205b45">

To run the program :

1. Install latest version npm, node in your system. https://docs.npmjs.com/downloading-and-installing-node-js-and-npm
2. Open the project in 2 in your choice of IDE. 
3. For doordash-ui (frontend) : use VS code (recommended). Open the terminal and run the following 2 commands:
   i. npm i
   ii. npm run dev
4. In another terminal, open doordash-api (backend), and run command : 
   i. ./gradlew bootrun (for mac and linux)
   ii gradlew bootrun (for windows)



Assignment 5: Architecture Breakers in Secure Session Management

1. Definition:  Session management is the process of maintaining and controlling user sessions in a web application or system. It involves managing the interaction between a user and the system during a specific period.
   Stateful : 
      1. Session is stored in the database.
      2. For every request session id needs to be checked if its valid.
      3. Monolithic Architecture.
   
   Stateless : 
      1. All the data is encrypted within the Token (example JWT)
      2. Expiration time is within the token.
      3. Microservices architecture.

Importance:
   Ensures that the user's interactions with the application are seamless and secure.

   Protects sensitive user data and authentication credentials from unauthorized access.

2. Authentication Failure - Weak Credentials
   Common mistake: Allowing weak passwords and usernames like "admin".
   Risks: Easy for attackers to guess and gain unauthorized access.
   Solution: Implement strong password policies and username requirements.

3. Authorization Failure - Privilege Elevation and Permission Checks
   Problem 1: Users manipulating URLs to access unauthorized pages.
   Problem 2: Implementing permission checks only at the user interface level.

   Impact: Unauthorized access to sensitive information or functions.

   Solution: Robust back-end authorization checks and secure URL handling.

4. Bugs in Encryption of Session Data
   Issue: Storing session data in plain text.
   Risk: Increased vulnerability to data breaches and session hijacking.
   Solution: Use strong encryption techniques for session data.

5. Predictable Session ID Properties
   Issues: Predictable, sequentially generated Session IDs or those derived from user data.
   Consequences: Makes it easier for attackers to hijack sessions.
   Solution: Ensure high entropy in Session ID generation and avoid predictable patterns.

Scenario 1 : Successful login & Session Creation (Random unique Session ID : UUID)
![NK_xAt77V4uqF5MY821NgWkuET_s8yji7Sj3wtri5VzsALTVkUOogmLW0pXe6iWWUeEYudmFw9anrGCz1DJ5i6s1MCf__QIo9sseXkAWEhBGhuiJotRPEo9RW2pL](https://github.com/summahto/doordash-auth/assets/20516618/7785cfb6-dd4d-4edd-929d-f1e4728f830e)

Scenario 2 : Fetch user by name (check password encrypted or not : Failed Test case)
![8encINYgCSpC_W9y4fBgB4VlyecH048ByT3Id2uiG5I9wM84apY5TXkKlAS7aqPIJ32XZfIJqHss6Ju1_IsVETMUUQaKQcGUK9cssDOrOaN4FIzdaoDk5FD2NM0p](https://github.com/summahto/doordash-auth/assets/20516618/ca537f2e-c527-496f-9f3e-86f57d7f1937)
