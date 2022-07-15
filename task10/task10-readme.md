## Task 10 -While running script, you have observed "NoSuchElementException". 
But you have taken the correct locator(ID, XPATh or CSS). Still, 
you are facing the same issue. What might be the reason?
Deliverable

There could be some possibilities of what may be causing this issue, 
which we can highlight

1. You are not waiting properly for the element
2. The element could be inside an iframe and you may have not switched to 
the iframe in your test
3. Something has changed in the page and you were not informed about it
4. The test is flaky and needs refactor
5. The element is present on the DOM but is not visible