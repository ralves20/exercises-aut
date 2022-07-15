## Task 3 - There are 10 pages in same window, an image is present in 
any page out of ten pages in same window. How will you validate this 
scenario with example?

# ANSWER
There are many possibilities, e.g.

1. Creating a code logic to verify when there is a image extension visible,
and then interact with it
2. Using layout-testing-specific frameworks to validating only the image and make specific assertions
3. Create a code logic in the test to see when a image is showed
4. Try to interact with every page and see what differs in the image page
5. Make assertions specific for the image when it is showed up in the pages