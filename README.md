# 🍏 Apple Website Automation Framework

This is a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven** with support for:
- ✅ Page Object Model (POM)
- ✅ Cross-Browser Testing (Chrome, Firefox, Safari, Edge)
- ✅ Parallel Test Execution
- ✅ JSON-driven Test Data & Locators
- ✅ Extent Reports for Reporting
- ✅ Jenkins Integration for CI/CD

---

## 📂 Project Structure

apple-automation-framework
│── src
│ ├── main
│ │ ├── java
│ │ │ └── org.example.base # Base classes (BaseTest, BasePage, DriverFactory)
│ │ │ └── org.example.pages # Page Object Model classes (AppleHomePage etc.)
│ │ │ └── org.example.utils # Utilities (JsonDataReader, ReportManager etc.)
│ │ └── resources
│ │ └── locators # JSON files for UI locators
│ │ └── testdata # JSON files for test data
│ └── test
│ └── java
│ └── UITests # UI Test classes (AppleSearchTest etc.)
│ └── APITests # API Test classes (if added later)
│
│── pom.xml # Maven dependencies
│── testng.xml # TestNG suite configuration
│── README.md # Project documentation

yaml
Copy code



---

## ⚙️ Tech Stack

- **Language:** Java 11  
- **Automation Tool:** Selenium 4.x  
- **Testing Framework:** TestNG  
- **Build Tool:** Maven  
- **Reporting:** ExtentReports  
- **JSON Parsing:** Jackson / org.json  
- **CI/CD:** Jenkins / GitHub Actions  

---

## 🚀 How to Run Tests

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/apple-automation-framework.git
cd apple-automation-framework


**##  Reports**

After execution, ExtentReports HTML report will be generated under:

/test-output/ExtentReports/ExtentReport.html


Open the report in a browser to see detailed test results with screenshots (on failure).

