Here is the **cleaned-up and correctly formatted README.md** file with all steps included, proper indentation, syntax highlighting, and markdown formatting:

---

markdown
# 🛒 Amazon Automation with Selenium (Java)

This project automates the process of:

1. Opening [Amazon.in](https://www.amazon.in)  
2. Searching for "boat headphones"  
3. Logging into a test Amazon account  
4. Repeating the search  
5. Selecting the first product  
6. Adding it to the cart  

---

## 🚀 Technologies Used

- Java 21  
- Selenium WebDriver 4.20.0  
- ChromeDriver  
- WebDriverManager (Bonigarcia)  
- Maven  

---

## 📦 Prerequisites

### ✅ Software Requirements

- Java JDK 17 or above — [Download Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- Apache Maven — [Download Maven](https://maven.apache.org/download.cgi)  
- Google Chrome browser installed  
- Internet connection  

### ✅ Optional Tools

- IntelliJ IDEA / Eclipse (for easier development)

---

## 📁 Project Structure



AmazonAutomation/
├── src/
│   └── test/
│       └── helloworld/
│           └── AmazonAutomation.java
├── pom.xml
└── README.md

`

---

## ▶ How to Set Up and Run the Project (Step-by-Step)

### 🔹 Step 1: Create a Folder and Navigate to It

bash
mkdir AmazonAutomation
cd AmazonAutomation
`

---

### 🔹 Step 2: Initialize a Maven Project

bash
mvn archetype:generate -DgroupId=test.helloworld -DartifactId=AmazonAutomation -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
cd AmazonAutomation


---


### 🔹 Step 3: Add Dependencies to `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>test.helloworld</groupId>
  <artifactId>AmazonAutomation</artifactId>
  <version>1.0</version>

  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.20.0</version>
    </dependency>
    <dependency>
      <groupId>io.github.bonigarcia</groupId>
      <artifactId>webdrivermanager</artifactId>
      <version>5.8.0</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <mainClass>test.helloworld.AmazonAutomation</mainClass>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

---

### 🔹 Step 4: Add Your Java Code

If it doesn’t already exist, create the required folder:

bash
mkdir -p src/test/java/test/helloworld


Then replace the contents of `src/test/java/test/helloworld/AppTest.java` with your `AmazonAutomation.java` file.

---

### 🔹 Step 5: Compile the Project

bash
mvn clean compile


---

### 🔹 Step 6: Run the Automation Script

bash
mvn exec:java

