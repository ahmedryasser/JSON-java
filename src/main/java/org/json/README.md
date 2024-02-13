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
