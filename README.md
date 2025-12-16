# SauceDemo Automation Framework

## Overview
This is a robust automated testing framework designed for the [SauceDemo](https://www.saucedemo.com) e-commerce platform. It demonstrates a scalable, maintainable architecture suitable for enterprise-level QA.

## Tech Stack
* **Language:** Java (JDK 17)
* **Core Library:** Selenium WebDriver
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** ExtentReports 5
* **Version Control:** Git

## Key Features
* **Page Object Model (POM):** Separates page locators from test logic for easy maintenance.
* **Data-Driven Configuration:** Uses `config.properties` for environment handling.
* **Robust Reporting:** Generates HTML dashboards with pie charts and logs via ExtentReports.
* **Cross-Browser Ready:** BaseTest architecture supports easy expansion to Firefox/Edge.
* **Implicit Waits:** Global synchronization handling.

## How to Run
1.  Clone the repository.
2.  Open in Eclipse or IntelliJ.
3.  Right-click `testng.xml` and select **Run As > TestNG Suite**.
4.  View results in `target/SparkReport.html`.

## Author
**Philip Barnell** - *Automation Engineer*