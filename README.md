# BDD Framework using the Cucumber+Selenium+TestNG

# Drivers : 
Browser driver needs to be placed under the folders respectively 

* src/test/resources/mac/chromedriver
* src/test/resources/win/geckodriver

#Tags : Cucumber Uses the Tags for the execution 
* @google : This tag is present in this framework template and it contains google.com related scenarios

Note :
user can create tags like smoke , sanity and regression based on his needs

#Intellij Run Configs
* Main class: cucumber.api.cli.Main

* Glue: www.com.stepdefinations <Folder where step definations placed> 

* Expected Classpath of Module: BDDFramework <folderName>

* VM Options: All run timr variables needs to be configured.

# Run Time Variables

-Dcucumber.tags     : Tags which you want to run

-Dbrowser.instances : Number of instances you want to run

-DplatformName=mac  : mac/win based on the platform where the test cases executed.

-DappURL            : application URL of AUT( Application Under Test)

#Supported browsers:
* Google Chrome
* Safari
* Firefox

#Execution commands 
```bash
mvn clean verify -Dcucumber.tags=@google,~@ignore,-Dbrowser.instances=2  -DplatformName=mac  -DappURL=https://www.google.com/ -Dbrowser=firefox
mvn clean verify -Dcucumber.tags=@google,~@ignore,-Dbrowser.instances=2  -DplatformName=mac  -DappURL=https://www.google.com/ -Dbrowser=chrome
mvn clean verify -Dcucumber.tags=@google,~@ignore,-Dbrowser.instances=2  -DplatformName=mac  -DappURL=https://www.google.com/ -Dbrowser=safari

```
#Reporting : 
It uses donut plugin and gives beautiful reports 

-target/donut/cucumber-reports/donut-report.html
