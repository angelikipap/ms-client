# ms-client
This a Spring Boot microservice client that loads configuration properties for a config server.

You may find the code for the spring cloud config server here: https://github.com/angelikipap/ms-config-server

Instructions on how to execute:
1. Exeute the sript init.sql in the database of the spring cloud configuration server. The script contains two entries.
2. Upate the bootstrap.properties file with the correct endpoint of the configuratio server (spring.cloud.config.uri)
3. Build with mvn package
4. Execute with java -jar ms-client-0.0.1-SNAPSHOT.jar (under target directory)
5. Exeute a GET request to http://localhost:8882/api/hello in order to see the result. You should see Hello! 
6. Uncomment spring.profiles.active=fr on bootstrap.properties file in order to execute the client with profile fr. Build and run the application and exeute the GET request. You should see Salut!

Notes:
1. If you have something wrong in the configuration the application will fail to start because on value will be bound to key "hellomessage"
2. The annotation @RefreshScope should be present to every bean that we should refresh the config parameters
3. When a value is changed in the database and we want to refresh it we should exexute a POST request to http://localhost:8882/actuator/refresh and then we will get the new value.
