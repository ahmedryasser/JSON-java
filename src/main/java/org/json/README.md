## Milestone 2

## Task 1: Parse XML Content Up to Specified JSONPointer Path
The XML content is recursively traversed until the specified JSONPointer path is reached. Once the target path is identified, parsing halts, optimizing resource usage. This approach avoids parsing the entire XML file, enhancing efficiency, especially for large files.By skipping the part of the file if it is not on the right path.

## Task 2: Replace Content at Specified JSONPointer Path
Similar to Task 1, the XML content is traversed until the target path is found.
Upon reaching the target path, the code checks if a replacement is necessary.
Parsing continues after replacement, ensuring complete processing of the XML content.

## Code Explanation:
The code verifies if the current XML tag matches the specified path.
If required, the code updates the JSON object with replacement content.
Parsing resumes after replacement, ensuring accurate processing.

## Milestone 1 vs. Milestone 2 Approach:
- Milestone 1: Involves parsing the entire XML file and iterating through resulting JSON objects to extract sub-objects.
- Milestone 2: Optimizes parsing by stopping as soon as the target sub-object is found, enhancing performance.

## Conclusion:
Tasks 1 and 2 are accomplished efficiently, ensuring accurate parsing and replacement of XML content while optimizing resource usage. These tasks demonstrate effective handling of XML data in the project.

## Unit Tests
- Unit tests are provided to ensure the correctness of the new toJSONObject methods.
- These tests cover both obtaining correct results and testing error conditions to ensure robustness. Find the test cases in json-java/src/main/M2test.java

## Running instructions for Milestone 2
On Intellij: \
- Navigate to the run configurations button and select the plus sign then application
- next select Java 21 as the SDK, and download it (click the download sdk button) if you don't have it.
- Then click on the paper icon in the field directly to its right and navigate to M2Test.java by going through LAB2-Code/ and click on M2Test \
- Click ok, then apply, and click on the green run button to run the project

Possible issues: SystemMain is not selectable in java. \
Fix: Click on the Lab2-Code directory in Lab2-Code and right click. Then click on mark directory as. Then click on sources root.

## Running instructions for Milestone 3
-Same as Milestone 2 but run M3Test.java instead of M2Test.java
## Milestone 3: Task implementation in Library vs. Client code
We imporved in milestone 3 by shifting the same task from client code to library. The benefits from doing this change is enhanced Performance, promotes reusability by optimizing the library level. Instead of increased complexity and potential code duplication across the project due to implementing the Milestone 1 code within client code. We can now by transitioning certain tasks into the library in Milestone 3, we achieved performance optimizations and streamlined maintenance efforts. This architectural shift enhances code reusability, promotes consistency, and simplifies dependency management for client applications. Last but not least, centralizing task implementations within the library offers numerous advantages over distributing them across client codebases as seen in Milestone 1.
