# employee_jdbc
basic JDBC program in a Maven Java project that connects to a MySQL database and performs basic CRUD (Create, Read, Update, Delete) operations.
Explanation of CRUD Operations
Create: Inserts a new record in the users table with the specified name and age.
Read: Retrieves all records from the users table and prints them.
Update: Updates the name of a specific user by their id.
Delete: Deletes a specific user by their id.
Set up the Maven Project
Create a new Maven project in your IDE (e.g Eclipse).
In the pom.xml file, add the dependency for the MySQL Connector
Configure Database Connection
In your project, create a properties file (e.g., db.properties) to store your database configuration.
 Write the JDBC Utility Class
Create a utility class to handle the database connection. This class will load the properties file and connect to the database.
Create a Main class with methods for each CRUD operation:
The project includes:

DatabaseConfig: Contains database connection details
Employee: Model class representing an employee
EmployeeDAO: Data Access Object with CRUD operations
Main: Example usage of the DAO methods

 Run the Program
Execute the Main class to see each operation in action. The main method demonstrates how to call each CRUD method sequentially. This setup provides a straightforward demonstration of JDBC with MySQL connectivity in a Maven Java project.
