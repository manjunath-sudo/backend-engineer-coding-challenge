#!/bin/bash
set -e
./mvnw clean package -DskipTests
java -jar target/backend-engineer-coding-challenge-1.0.0.jar
