## Unit Tests
- Unit tests are provided to ensure the correctness of the new toJSONObject methods.
- These tests cover both obtaining correct results and testing error conditions to ensure robustness. Find the test cases in json-java/src/main/M2test.java
- These tests cover both obtaining correct results and testing error conditions to ensure robustness. Find the test cases in json-java/src/test/java/org.json/junit/data/M2test.java

## Running instructions for Milestone 2
On Intellij: \

## Running instructions for Milestone 3
- Same as Milestone 2 but run M3Test.java instead of M2Test.java

## Unit Tests
- These tests cover both obtaining correct results and testing error conditions to ensure robustness. Find the test cases in json-java/src/test/java/org.json/junit/data/M3test.java

## Milestone 3: Task implementation in Library vs. Client code
- We imporved in milestone 3 by shifting the same task from client code to library.
- The benefits from doing this change is enhanced Performance, promotes reusability by optimizing the library level. Instead of increased complexity and potential code duplication across the project due to implementing the Milestone 1 code within client code.
- We can now by transitioning certain tasks into the library in Milestone 3, we achieved performance optimizations and streamlined maintenance efforts.
- This architectural shift enhances code reusability, promotes consistency, and simplifies dependency management for client applications.
- Last but not least, centralizing task implementations within the library offers numerous advantages over distributing them across client codebases as seen in Milestone 1.

## Running instructions for Milestone 4
- Same as previous milestones but run M4Test.java

## Milestone 4: Streams
- We processed the data using Streams which gave us multiple benefits like having low space usage unlike lists.
- It also gave us lots of benefits like the usage of all the methods that are available to

## Unit Tests
- These tests cover both obtaining correct results and testing error conditions to ensure robustness. Find the test cases in json-java/src/test/java/org.json/junit/data/M4test.java