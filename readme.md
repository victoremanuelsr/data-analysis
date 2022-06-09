# Data Analysis - Technical Challenge
## Requirements to run:
 - Git
 - Java 11+

##  Steps to run:
- Clone this repository
- in the project folder run: `./gradlew run`
##  Explaining how it works:
- The application will create a folder called data and inside it will create two folders, input and output inside your %HOMEPATH%. During its operation, the application will be monitoring the input folder waiting for some data file with the end `.dat` to be added.
- The `.dat` files must have the following template:
	- 001çCPFçNameçSalary
	- 002çCNPJçNameçBusiness Area
	- 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
- **Example**:
	- 001ç1234567891234çDiegoç50000 
001ç3245678865434çRenatoç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardoPereiraçRural
003ç5ç[1-10-100,2-30-2.50,3-40-3.10]çDiego
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato
- The system will analyze the input file data and generate an output file with the following information:
	•Amount of clients in the input file
	• Amount of salesman in the input file
	• ID of the most expensive sale
	• Worst salesman ever

