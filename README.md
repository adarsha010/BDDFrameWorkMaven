# Test NG RUNNER CLASS will run the tags mentioned

# Drivers : 
Need to create a folder by Name drivers and subfolders mac and win under it.
Place the different drivers like chromedriver and geckodriver 

Note : we should avoid checkin of the browser drivers hence modified .gitignore file



#Intellij Run Configs
Main class: cucumber.api.cli.Main

Glue: com.ticketmaster.qa.cucumber <Folder where step definations placed> 

Environment Variables: SELENIUM_CHROME_DRIVER=/Users/<your_user>/chromedriver

Expected Classpath of Module: checkout2-automation-tests <folderName>

VM Options: <Any Run time arguments that need to be passed>
