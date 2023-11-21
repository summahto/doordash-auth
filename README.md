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


