# Yep
With Yep you become the ultimate Jepoardy host for your friends. You can create a game with your own set of questions, or choose from a predefined set of real Jeopardy questions (from the JService API). Your friends can connect to your game using their phone, which then acts as a buzzer, or you can handle everything manually using the UI controls.

**Authors**
Axel Niklasson (axelni[at]student.chalmers.se), David Bergström (davbe[at]student.chalmers.se), Marcus Trigell (trigell[at]student.chalmers.se) and Tobias Andersen (tobiaa[at]student.chalmers.se).  
  
Built with the service based approach using React JS, Redux, CSS modules and postcss on the frontend, all bundled with Webpack, which also gives us hot reloading. The backend is built using Java Spring with Spring Boot, JPA and Hibernate with a MySQL database that is run either locally or by using [DB4Free](http://www.db4free.net) as database host.

## Documentation
This README serves as the main documentation of the application.
### UML
UML-diagrams and such is located in the *docs* folder.

## Backend
The backend runs as a separate app serving endpoints to the frontend according to a RESTful URI pattern. Categories and Cards are, aside from created by users in-game, fetched from [JService.io](http://www.jservice.io) which provides over 150,000 authentic trivia questions. The server also provides full-duplex communication between multiple clients using WebSockets. The actual web page that is being served uses the `index.html` template under `server/src/main/resources/templates/index.html`.

### Build/Run
Alt.1: To build and run from a jar (including cleaning the package and running the tests) run: 

1. `mvn clean package`
2. `java -jar target/gs-rest-service-0.1.0.jar`.  

Alt.2: To run the backend locally at port 8080 run `mvn spring-boot:run`.
### Packages
The backend is divided into several packages where each has it's own responsability:

1. Config – Spring configuration files.
2. Controllers - The classes serving the endpoints to the frontend.
3. Handlers – The WebSocket connection handlers.
4. JServices - The service that populates the database if not already populated.
5. Models - All the object oriented models of the Yep-game.
6. Repositories - The interfaces responsible for mapping the oo-model to the MySQL database.
8. Utils – Utility classes.

## Frontend
All client code lives inside the /app directory. During development, Webpack is used to serve javascript and css as separate bundles on port 9000. The javascript bundle essentially concist of a React.js app, that on load gets injected into `<div id="root"></div>`. This allows Webpack to automatically, and continuously, update the app with changes – which greatly improves the DX (developer experience).

### Running the app
Make you've started the backend server (see above) and that node and npm is installed, then cd into /app and:

1. Run: `npm install` (this might take a while)
2. Run: `npm start`

This will create two files:
- bundle.js
- style.css

both served on http://localhost:9000.




#### Build
Just run `npm run build` and webpack will bundle everything together into
bundle.js and style.css and place them in the dist folder. We'll have to update
the webpack build config to fix paths for index.html when going to production
(or just do it manually).

