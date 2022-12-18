# Spotify-Api

## Introduction
The goal of this challenge is to demonstrate knowledge and skills in interfacing with external APIs and databases

## Idea
Fetch a few artists (about 10) and their albums from the spotify API. Those fetched data is stored in a Database.
An API should then allow CRUD-Capability on those fetched artists and albums.
Kotlin and Spring Boot with Hibernate has to be used.

## Acceptance Criteria
- Fetch data from Api at the startup of the app
- Use an In-Memory Database
- Provide CRUD-Endpoints

## Tech Stack
- Programming Language [Kotlin](https://kotlinlang.org/docs/getting-started.html)
- Frameworks [Spring](https://spring.io/), [Hibernate](https://hibernate.org/)
- Tools [Spotify-Web-API](https://github.com/spotify-web-api-java/spotify-web-api-java), [Dozer](https://github.com/DozerMapper/dozer)
- Memory-Database [H2](https://www.h2database.com/html/main.html)
- Build Tool [Gradle](https://gradle.org/)

## Prerequisites
- [Open JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)

## Setup IntelliJ
You can download IntelliJ from [here](https://www.jetbrains.com/de-de/idea/download/#section=windows) The Community Edition is free to use.

1. Open IntelliJ and import this project using VCS or import this project to your local hard drive and open it.
2. This Project comes with the gradle wrapper, you don´t have to install a local Gradle on your computer in order to run this application.
3. Check if you have the Gradle Task Symbol on the right side.
4. Open the Gradle Task Symbol and enter `Tasks` -> `application` -> `bootRun`
5. When The Application runs you can use Postman or another preferred tool of your choice to perform CRUD Operations on the H2 Database.

## Future improvements:
- Mapping upgrade from Dozer to mapstruct
- Split API Layer from Persistence Layer with help of DTOs
- Constructor Injection instead of Property Injection 
- Add Mapping with foreign key and add JPA Relation between Album and Artist
