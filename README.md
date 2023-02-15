# README #

Project name - <b><i>Serenity BDD & Cucumber Shop project</b></i>

#### How do I get set up? ####

1. Clone this project on your local machine using git bash
2. Launch project in Intellij IDEA
3. Reload Maven framework (be sure that all Dependencies have the corresponding version) 
4. Test - run automation scenario (from Runner file)
5. Use Maven command in Terminal to aggregate the report
6. Navigate to the following directory target/site/serenity/index.html
7. Open 'index.html' in Chrome browser for viewing the generated report

Note: In order to add more Scenarios one has to write them in feature 
file and add the corresponding steps SearchStepDefinition file (plus the necessary logic). 

____

##### Maven commands: #####

* mvn serenity:aggregate - build automation report 
* mvn clean - delete created report

----

##### Elements Refactored #####
1. Renamed and Reorganized project structure (packages, files, classes, variables)into the relevant ones for the project type
2. Updated Maven Dependencies in order to maintain an up and running framework
3. Wrote support class, step definition class and a feature file with gherkin scenarios
4. Configured Serenity properties file
5. Added instructions in ReadMe file
