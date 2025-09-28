#!/bin/bash
set -e
mvn clean install
java -jar target/backend-engineer-coding-challenge-1.0.0.jar
