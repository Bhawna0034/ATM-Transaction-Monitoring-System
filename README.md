# ATM Transaction Monitoring System
## Introduction

This Project is a simulation of an Automated Teller Machine (ATM ) system. It allows users to perform basic banking operations such as viewing their balance, depositing money, withdrawing money, and pin change. The project is built using Java and incorporated Java Swing and AWT for the graphical user interface (GUI), and JDBC with MySQL for database management.

## Features
- User Authentication
- View Account Balance
- Cash Deposit
- Cash Withdrawal
- Pin Change

## Technology Used
- Java: Core language for the application logic.
- Java Swing & AWT: For building the graphical user interface.
- JDBC: For database Connectivity.
- MySQL: As the database management system.

# Installation
## Prerequisites
- Java Development Kit (JDk) 8 or higher
- MySQL Server
- IDE (e.g., IntelliJ IDEA, Eclipse)
- MySQL Connector
- JCalendar

## Steps
### 1. Clone the repository:
        git clone https://github.com/Bhawna0034/ATM-Transaction-Monitoring-System.git
        cd ATM-Transaction-Monitoring-System
   
### 2. Set up the database:
   - Follow the Database Setup instructions to create the necessary database and tables.

### 3. Configure the project:
   - Ensure that the MySQL JDBC Driver is included in your project dependencies.
   - Update the database configuration in the [Conn.java](Conn.java) file with your MySQL server details.
  
### 4. Compile and run the project:
   - Open the project in your preferred IDE.
   - Compile and run the [Login.java](Login.java)


# Usage
### 1. Launch the Application: 
       Run the Login.java file.
       The ATM login screen will appear.

### 2. Login: 
       Enter your card number and PIN to log in.

### 3. Perform Transactions:
       Once logged in, you can choose from various options such as viewing your balance, cash withdrawal, cash deposit and pin change.


# Database Setup      

 ### 1. Create a database:
        CREATE DATABASE atm;
        USE atm;
      
 ### 2. Create our first Table in the selected database with name signup
        CREATE TABLE signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20),email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));

 ### 3. Create the second table to store more information of user
        CREATE TABLE signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20));

 ### 4. Create the third table to store the account information of user
        CREATE TABLE signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10); 

 ### 5. Create the Login table to store login information
        CREATE TABLE login(formno varchar(20), cardnumber varchar(25), pin varchar(10));

 ### 6. Now create bank table to store transactions related information 
        CREATE TABLE bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));


# License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

# Contact
Bhawna - bhawnaasharma0034@gmail.com
<br>
Project Link:  https://github.com/Bhawna0034/ATM-Transaction-Monitoring-System.git

   
