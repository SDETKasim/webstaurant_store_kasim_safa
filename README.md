# Selenium Java Test Automation Architecture Webstaurant Store
by Kasim Safa

UI Test Automation Architecture using Java and Selenium WebDriver  



## Installation Steps / QuickStart Guide!⭐

In order to use the framework:

1. Fork the repository.

2. Clone, i.e, download your copy of the repository to your local machine.

3. Use IntelliJ IDEA to run your desired tests.

4. To see the report, go to the `target/allure-results` folder in the project root and then open using Allure Report: Generate or Generate On-The-Fly.
## Project Structure
```bash
├───.idea
└───src
    └───test
        ├───java
        │   └───com
        │       └───webstaurant_project
        │           ├───base
        │           ├───pages
        │           ├───runners
        │           ├───tests
        │           └───utilities
        └───resources
            ├───allure.properties
```
## Languages and Frameworks

The project uses the following:

- *[Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- *[Selenium WebDriver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- *[TestNG](https://mvnrepository.com/artifact/org.testng/testng)
- *[Bonigarcia WebdriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
- *[Maven-surefire-plugin](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin)
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)


## Basic Usage

- ### This project utilizes Maven⭐

  Dependency Management: Dependencies are defined in the `pom.xml` file.
  Build Automation: The build process is configured in the `pom.xml` file.
  Test Execution: Maven commands like `mvn clean test` can be used to run tests.

- ### Configuration⭐
  The project uses a [*config.properties*](config.properties) file to manage global configurations such as browser type and base url.

    To add a new property, register a new entry in this file:
      ```
      key=value
      ```

  use `getProperty()` method in [*ConfigurationReader*](src/test/java/com/webstaurant_project/utilities/ConfigurationReader.java) class to read [*config.properties*](config.properties)


- ### Page Objects and Page Component Objects⭐
  The project uses Page Object Model Design
  `src/test/java/com/webstaurant_project/pages`
  Page Objects represent individual web pages, encapsulating their elements and related behaviors. This design promotes code re-usability and easier maintenance.


- ###  Allure Reports⭐

    [Allure Reporting](https://allurereport.org/docs/junit5/) enhances test result visualization.

    Allure reports can be found and generated in the `target/allure-results` directory after test execution.

    

- ### Browsers⭐
  The project contains the implementation of the `Chrome`,`Edge` and `Firefox` browsers. 





