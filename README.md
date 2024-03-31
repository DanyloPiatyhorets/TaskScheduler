# Task Scheduler Application 
> Version 2.0 (released 28/03/24)
## Intro
In a world filled with ever-increasing demands and responsibilities, 
staying organised is paramount <br> 

Task Scheduler is your go-to solution for managing daily activities efficiently. Whether you're
- a professional juggling work tasks
- a student with assignments and deadlines
- a parent managing household chores and family commitments
- an entrepreneur coordinating business tasks and priorities <br>

this tool is designed with you in mind
### Relevance
Life is complex, and so are the tasks that come with it <br>
Task Scheduler simplifies your daily routine by providing a centralised platform 
to keep your tasks updated and organised <br>
Stay on top of your game with a tool that adapts to your needs.
## Project
This project is a user-friendly website designed to streamline your task management. 
It empowers you to create, store, edit, complete, and delete tasks effortlessly<br>
The website is organized into different pages for better navigation
 - **Home** (all upcoming tasks are sorted and shown on this page)
 - **My Day** (upcoming tasks which have today's date as a deadline. Grouped by priorities for better visualisation)
 - **Done** (tasks that are marked as completed)
 - **Missed** (all tasks with a missed deadline relatively today's date)
 - **Add** (a page for creating new tasks)
## Updates
### New features
I have finished working on a basic security system for the projects<br>
Now the functionality of the app enables users to sign up, log in and log out from different accounts
### New experience
During the last update I have gained experience of how to work with the Spring Security, handle multiuser process and keep user's data secure

## How to Use

To run the project on your machine, follow these steps:

1. **Download the Files**: Clone or download all the files from the repository to your local machine.

2. **Set Database Preferences**:
    - Open the file `src/main/resources/application.properties`.
    - Set preferences for your database (local or cloud). The default preferences may be set for my local database, so ensure to adjust them according to your setup.

3. **Run the Application**:
    - Open the file `src/main/java/com/example/TaskScheduler/TaskSchedulerApplication.java` in your preferred IDE.
    - Make sure you have JDK installed.
    - Run the application.

4. **Access the Application**:
    - Once `TaskSchedulerApplication` is started, follow the link: [http://localhost:{your local host}/home]().
      For example, if your local host is set to 8080, the link will be [http://localhost:8080/home](http://localhost:8080/home).

<br>

[//]: # (You can also explore how Task Scheduler works by going through a provided presentation. Follow `TaskSchedulerFunctionality.pptx` for more information.)
## Technologies used
I utilized the following technologies to develop the application:
- Java
- The Spring Framework
- Fronted technologies such as HTML, CSS, and JavaScript
- mySQL database (powered by MAMP)

## Further improvements
Future development plans include:

- **Multiuser System Improvement**: Refining the system to handle simultaneous users activities in a smoother way

- **UI Enhancement**: Improving the user interface to create a more intuitive and visually appealing experience. This effort aims to deepen my knowledge in frontend technologies.

- **Localisation**: Implementing language localization features to enable a multilingual interface, providing a more inclusive experience for users.

- **Calendar Page**: Adding a dedicated calendar page for better visualization of tasks, offering users a more comprehensive view of their schedules.

## Outro
Thank you very much for checking out my project! I hope that has been an interesting experience for you<br>
Please feel free to reach me out for any questions, clarifications, objections or suggestions regarding this application
- Here via GitHub
- Or via email: [Danylo.Piatyhorets@city.ac.uk](mailto:Danylo.Piatyhorets@city.ac.uk)