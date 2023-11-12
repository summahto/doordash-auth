When working with a Spring Boot project using Gradle, you can use the following basic Gradle commands:

1. **To build the project:**

   gradle build

   This command compiles your Spring Boot application and produces a runnable JAR file.

2. **To run the Spring Boot application:**

   gradle bootRun

   The `bootRun` task starts your Spring Boot application. It's provided by the Spring Boot Gradle plugin, which is usually applied in your `build.gradle` file:

   plugins {
   id 'org.springframework.boot' version '2.5.5'
   id 'io.spring.dependency-management' version '1.0.11.RELEASE'
   }

   The `bootRun` task automatically detects your main application class and runs the application.

3. **To clean the build directory:**

   gradle clean

   This removes the `build` directory.

4. **To view available tasks:**

   gradle tasks

   Lists all the tasks available for your project.

5. **To get more information about a specific task:**

   gradle help --task <task-name>

   Replace `<task-name>` with the name of the task you want more information about.

6. **To create a distribution (ZIP or TAR file) of your application:**

   gradle build

   This will generate a distribution in the `build/distributions` directory.

7. **To run tests:**

   gradle test

   Executes the tests in your project.

8. **To build the project without running tests:**

   gradle build -x test

   This skips the test execution during the build.

9. In Gradle, dependencies are declared in the build.gradle file for your project. You can specify dependencies for your project by adding the necessary configuration in the dependencies block. Here's a basic example of how you can add dependencies to a Gradle project:

   // build.gradle
   
   plugins {
       id 'java'
   }
   
   repositories {
       // You can add additional repositories here
       jcenter()
   }
   
   dependencies {
       // Add dependencies for your project here
       implementation 'group:artifact:version'
       // Example:
       // implementation 'com.google.guava:guava:30.1-jre'
   }


These commands assume that you have a standard Spring Boot project structure and have applied the Spring Boot Gradle plugin in your `build.gradle` file. Customize your `build.gradle` as needed based on your project's requirements.
