## Currency Converter - Java CLI

An object-oriented Command Line Interface (CLI) tool for real-time currency conversion. Built with Java, this application integrates with the ExchangeRate-API.

### Features

* **Real-time Data:** Fetches live exchange rates using the Java HttpClient.
* **Navigation Menu:** Features an interactive terminal menu for easy selection of currency pairs.
* **JSON Integration:** Utilizes Google Gson for parsing of external API responses.

### Tech Stack

* **Language:** Java 25+
* **External Library:** Google Gson (v2.13.2)
* **API Provider:** ExchangeRate-API

### Prerequisites

* Java Development Kit (JDK) 25 or higher.
* A valid API Key from ExchangeRate-API.
* The Gson library (jar file) accessible in the project's classpath.

### Installation and Usage

1. **Clone the repository:**
   ``` bash
   git clone https://github.com/Acheronp/currency-converter-java.git
   cd currency-converter-java
3. **API Configuration:**
Configure your API Key in the src/com/currencyconverter/services/APIQuery.java file.

### Architecture
The project is organized into distinct packages to adhere to the principle of separation of concerns:
* **models**: Contains data structures and Records used for API data mapping.
* **services**: Includes the business logic, API communication protocols, and conversion algorithms.
* **main**: Manages the application lifecycle and the Terminal User Interface (TUI).

### License
This project is intended for educational purposes under the Alura Latam - Oracle Next Education program.
