FROM openjdk:8u191-jre-alpine3.8

#Workspace

WORKDIR /usr/share/SSDV1

#Add .jar files under target from host
#into this image

ADD target/selenium-scaffolding-docker-version1.jar  selenium-scaffolding-docker-version1.jar
ADD target/selenium-scaffolding-docker-version1-tests.jar  selenium-scaffolding-docker-version1-tests.jar
ADD target/libs libs

#Add TestNG Suite Files

ADD testng.xml testng.xml

#Add Other Utility Files
#Adding Excel File from excelfolder
#Adding config.properties file from src/test/resources/config folder
ADD excel/TestData.xlsx excel/TestData.xlsx
ADD src/test/resources/config/config.properties src/test/resources/config/config.properties


#Define Entrypoint
ENTRYPOINT java -cp selenium-scaffolding-docker-version1.jar:selenium-scaffolding-docker-version1-tests.jar:libs/* -DHUB_HOST=$HUB_HOST org.testng.TestNG testng.xml


