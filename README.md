# Yep
## About
With Yep you become the ultimate Jepoardy host for your friends. You can create a game with your own set of questions, or choose from a predefined set of real Jeopardy questions (from the JService API). Your friends can connect to your game using their phone, which then acts as a buzzer, or you can handle everything manually using the UI controls.

Built with the service based approach using React JS, Redux, CSS modules and postcss on the frontend, all bundled with Webpack, which also gives us hot reloading. The backend is built using Java Spring with Spring Boot, JPA and Hibernate with a MySQL database that is run either locally or by using [DB4Free](http://www.db4free.net) as database host.

## Authors
Yep was developed during the course Web applications (DAT076) at Chalmers University of Technology, during early 2016. Below you can find the authors.


* [David Bergström](https://github.com/davidbergstrom)
* [Marcus Trigell](https://github.com/marcustrigell)
* [Tobias Andersen](https://github.com/tobiasandersen)
* [Axel Niklasson](https://github.com/axelniklasson)

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
Make sure you've started the backend server (see above) and that node and npm is installed, then cd into /app and:

1. Run: `npm install` (this might take a while)
2. Run: `npm start`

This will create two files:
- bundle.js
- style.css

both served on http://localhost:9000. To use the app, go to: http://localhost:8080.

### Libraries, Middleware & Tools
All npm packages that are being used are listed in `app/package.json`. What follows is a short list of those playing a big part of our application:
- React
- Redux
- React Router
- React Motion
- CSSModules

These are of great help when developing the app:
- Babel
- ESlint
- Express

#### React
- react-dom

A declarative, efficient, and flexible JavaScript library for building user interfaces. This is the core part of our client app. All view components are written in React and it is responsible for updating the DOM.


#### Redux
- react-redux
- redux-thunk
- redux-multi
- redux-devtools

Redux is a predictable state container for JavaScript apps. It helps us write an application that behaves consistently and it work great together with React, especially using the bindings in the `react-redux` lib. By using thunks we can do async requests in an easy way. Multi lets us dispatch mulitple actions.


#### React Router
- react-router-redux

A complete routing solution for React, which also keeps our UI in sync with the URL. To stay in sync with the server, it starts by checking the path with the one the server has provided on load.

#### React Motion
A spring animation library used to create smooth animations (e.g. the card flip)

#### CSSModules
- css-loader
- postcss-loader
- autoprefixer
- react-css-modules

A CSS Module is a CSS file in which all class names and animation names are scoped locally by default. This lets us write regular css, without worrying about naming conflicts and global selectors overwriting each other. Autoprefixer is used with the postcss-loader to give the built css file browser prefixes.

#### Babel
- babel-core
- babel-loader
- babel-react-transform
- babel-preset-es2015
- babel-preset-react
- babel-preset-stage-0
- babel-eslint

Babel is a compiler for writing next generation JavaScript. By using it we can use some of the newer features of React and javascript and let babel and webpack compile it into javascript that the browsers understand.

#### ESlint
- eslint
- eslint-loader
- eslint-plugin-react
- eslint-plugin-import
- eslint-plugin-babel
- eslint-import-resolver-webpack


ESlint is a linter that helps us write better and more consistent code. Used together with babel and webpack it's an essential tool in our development workflow as it contantly checks our files for errors.


#### Express
Express is really a web framework of its own. But since it's so small and flexible, we use it together with webpack to serve our bundles while developing.


### Folder structure
 
-app

---src

-----scripts

-------actions | Communicates with the server, dispatches actions to the client store

-------components | React components rendering the UI

-------constants | Action types

-------containers | Anonymus React components that connects Redux state and actions to React components

-------reducers | Copies current state and returns a new desired state depending on the action

-------store | Configures the Redux store object with middleware and the root reducer

-------utils | Wrappers for web socket functionality

-----styles | Holds all stylesheets for all components

-----index.js | Attaches the application to the DOM. Sets up router configuration. Creates the Redux store.

---devServer.js | Configuration for client development server.

---webpack.config.js  

-server

### Functionality
A list of working Use Cases can be found in the *docs* folder.
