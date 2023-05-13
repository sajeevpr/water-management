# Pre-requisites
* Java 1.8/1.11/1.15
* Maven

# How to run the code

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.
Both the files run the commands silently and prints only output from the input file `sample_input/input1.txt`.

Internally both the scripts run the following commands 

 * `mvn clean install -DskipTests assembly:single -q` - This will create a jar file `geektrust.jar` in the `target` folder.
 * `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 # How to execute the unit tests

 `mvn clean test` will execute the unit test cases.

# How to execute the jacoco report

`mvn clean jacoco:report` will generate the jacoco report

# Project structure
  ```
       a. com.waterbill.watermanagement.constants - Constant classes
       b. com.waterbill.watermanagement.exception - Exception classes
       c. com.waterbill.watermanagement.bill - Bill calculator classes
       d. com.waterbill.watermanagement.residence - Residence classes
       e. com.waterbill.watermanagement.supplier - Water supplier classes
       f. com.waterbill.watermanagement.util - Utility classes
       g. com.waterbill.watermanagement.validation - Validator classes for the input
       i. com.waterbill.watermanagement.WaterBillManager - Main class
  ```