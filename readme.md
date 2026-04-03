**SwiftCare API – Running the Application (IntelliJ IDEA)**


**Prerequisites**
 - Java 17 installed
 - Maven (or use IntelliJ’s built-in Maven support)

**Steps to Run**
 - Open swiftcare project folder in IntelliJ
 - IntelliJ will automatically detect the pom.xml and import dependencies
 - Navigate to SwiftCareApplication.java
 - Right-click the file and select Run 'SwiftCareApplication'

**Access the Application**
 - The app will start on: http://localhost:9000
 - Open: http://localhost:9000/swagger-ui.html


**Notes**
 - Ensure no other service is using port 9000
 - The application uses an in-memory data store (data resets on restart)