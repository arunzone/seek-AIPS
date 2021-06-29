## Traffic analyser

### Prerequisite

* Java 11,
* IDE (optional)
* gradle (depends)

### Setup

* Intellij
    * File > New > Project from Existing Sources... > navigate & choose settings.gradle

### Run Test and code coverage check

* Navigate inside project directory
* Simple
  > `./gradlew clean build` or `./gradlew clean test jacocoTestReport`
* generate jacoco report
  > ./gradlew jacocoTestReport
