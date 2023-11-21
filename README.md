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


