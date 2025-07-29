# Web-Based SWOT Analyzer Mini Project

This is a simple web application developed as a mini-project to practice frontend-backend integration, form handling, and dynamic content rendering.

## Technologies Used

* **Backend:** Java 17, Spring Boot 3.x, Thymeleaf
* **Frontend:** HTML5, CSS3, Bootstrap 5
* **Build Tool:** Maven
* **IDE:** Spring Tool Suite (STS)

## How to Run the Project

1.  **Prerequisites:**
    * Java Development Kit (JDK) 17 or higher installed.
    * Spring Tool Suite (STS) installed.

2.  **Steps to Run:**
    * **Import into STS:**
        * Open STS.
        * Go to `File > Import...`.
        * Select `Maven > Existing Maven Projects`.
        * Click `Next`.
        * Browse to the root directory of this project (the folder containing `pom.xml`).
        * Click `Finish`. STS will import the project and download dependencies.
    * **Run Application:**
        * In the "Package Explorer" view, locate `src/main/java/com/example/swot/SwotAnalyzerApplication.java`.
        * Right-click on `SwotAnalyzerApplication.java` and select `Run As > Spring Boot App`.
    * **Access in Browser:** Once the application starts (you'll see "Started SwotAnalyzerApplication" in the STS Console view), open your web browser and navigate to `http://localhost:8080/`.

## Brief Explanation of Logic

* **Backend (Spring Boot):**
    * `SwotAnalysis.java`: A simple POJO (Plain Old Java Object) acting as the data model to hold lists of strengths, weaknesses, opportunities, and threats.
    * `SwotController.java`: A Spring MVC controller handling web requests:
        * The `/` GET endpoint displays the input form (`swot-form.html`).
        * The `/analyze` POST endpoint receives form data, parses the comma-separated strings into lists, creates a `SwotAnalysis` object, generates a simple strategic suggestion, and then renders the results page (`swot-result.html`).
        * `@RequestParam` is used to bind form fields to controller method parameters.
        * A basic `parseInput` helper method handles converting comma-separated strings to lists.
        * A `generateSuggestion` method provides a very basic, illustrative strategic suggestion.
* **Frontend (HTML, CSS, Bootstrap, Thymeleaf):**
    * `swot-form.html`: Contains the HTML form for input. It uses Bootstrap classes for styling and the `th:action` attribute from Thymeleaf to specify the form submission endpoint.
    * `swot-result.html`: Displays the submitted SWOT data in a formatted grid using Bootstrap cards and lists. Thymeleaf's `th:each` and `th:text` attributes are used to iterate over the lists and display the content dynamically.
    * `style.css`: Provides custom CSS to enhance the appearance of the SWOT cards with distinct colors.
    * Bootstrap is included via CDN for responsive design and pre-built components.

### Screenshots of Working App:
(Include your actual screenshots here)
* [Screenshot of Input Form](.\Images\Input_form.png)
* [Screenshot of Output Page](.\Images\Output_matrix.png)
