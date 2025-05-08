## Grocery List Application
This is a simple grocery list application built with Spring-Boot & React. The application allows users to add, remove, and view items in their grocery list. It also provides a feature to save the list to a file and load it back.

This is a good starter application for starting with Spring-Boot & React. It covers the basics of building a full-stack application with a RESTful API and a front-end interface.

## Tech Stack Used
- **Backend**: Spring-Boot, MongoDB
- **Frontend**: React, Axios

## Full Steps in creating the application

### Step1: Create Spring-Boot Application
1. Use the link [Spring Initializer](https://start.spring.io/) to create a new Spring-Boot app.
2. Add the following dependencies:
    - Spring Web
    - Spring Data MongoDB
3. Hit generate to download the project.
4. Make a new folder `Grocery-App` & extract the downloaded zip file into it.

### Step2: Initialize React Frontend
1. Open a new terminal and navigate to the `Grocery-App` folder.
2. Run the following command to create a new React app:
   ```bash
   npm create vite@latest
   ```
3. Follow the steps to create a React app.

With this now you've just setup the basic project. It's not even connected yet. Our next step is to connect MongoDB with Spring-Boot.

### Step3: Connect MongoDB with Spring-Boot (backend)
You can follow the official docs mentioned [here](https://www.mongodb.com/resources/products/compatibilities/spring-boot)

1. Go to mongoDB site (here)[https://cloud.mongodb.com/] & create a new cluster.
2. Copy the connection string uri and paste it in the `application.properties` file in the `src/main/resources` folder of `backend` dir as given below:
    ```java
    spring.data.mongodb.uri=mongodb+srv://<username>:<pwd>@<cluster>.mongodb.net/mygrocerylist
    spring.data.mongodb.database=mygrocerylist  // it creates the database if not exists
    ```


