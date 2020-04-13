# JMS Demo
A demo application that demonstrates an integration scenario in which a source application notifies consumers about changes it made to its data.

The application pulls data from JMS Queue (Apache Artemis ActiveMQ), creates new or updates current entities using Spring Data (MySQL DB).

Logging is implemented using Spring AOP.

The application publishes REST API to make it possible to update date even from Web browser. Swagger is integrated too.