Project structure:
- Test folder in project is src/test/java
- basePages package is a folder that some Page Class are defined
   + MainPage (common Page): contains some common locators and common actions
   + LoginPage: contains locators and actions to inract on Login page
   + InventoryPage: contains locators and actions to inract on Inventory page
   + ManufacturingPage: contains locators and actions to inract on Manufacturing page
- testdata package is a folder that all test data are defined to use in test
- Testscript package is a folder that test case is defined and execute

How to run:
- Prerequisite: Jave and TestNG plugin are installed in IDE (i.e eclipse)
- Pull the code on github
- Select TestNG as default build path
- To run testcase.java, right click on Testscript or testcase.java and Run as TestNG
