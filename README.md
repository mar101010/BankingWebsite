"# Banking-website"

## Testing of Car Leasing Calculator application
website: https://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator

### Test plan
##### Abbriviations: P1, P2, P3 - priorities, M - manual, A - automation
#### Accessing the app
- #1. Access to the app from web site main page (M)(P1)
- #2. General view of the app and both sections: design is correct, informative messages on the bottom, no overlaps etc (M)(P1)
- #3. App view have all required elements: tab, sections (the one is expanded) and elements names texts are correct (A)(P2)
---
#### Both sections:
- #4. i-icons show correct messages, text is correct (M)(A also ok)(P3)
- #5. all elements are present and texts are correct: textboxes, buttons, checkboxes, radio buttons and informative texts (bottom) (A)(P1)
- #6. all elements are present and texts are correct: textboxes, buttons, checkboxes, radio buttons and informative texts (bottom) (A)(P1)
- #7. editable text boxes have correct default values and radio buttons selections (A)(P3)
---
#### Maximum lease calculator section:
- #8. income field is mandatory and marked red when it is empty (M)(P3)
- #9. it is not able to enter non-numeric data in any field (M)(P3)
- #10. there is a minimum income for apply for a lease (A)(P3)
- #11. increasing liability max lease amount decreases dynamically (M)(P2)
- #12. increasing income max lease amount increases dynamically (M)(P2)
- #13. increasing dependents max lease amount decreases dynamically (M)(P2) (a bug: the same output for first few dependents, usually for 0 and 1)
- #14. max lease is calculated correctly (A)(P1)
- #15. getting max lease amount increased right subsection view is changed accordingly: lease is allowed with no rstrictions, lease is allowed (max amount), lease is not allowed, allowed lease is less than 5000 (A)(P2)
- #16. checking/uncehcking surety right subsection text  is changed accordingly (here is also probably bug: I am not sure how the logic should work, but in some cases checking surety, text option is changed from "allowed lease is less thank 5000" to "lease is not allowed" (A)(P2)
- #17. reaching "allowed lease is less than 5000" scenario and clicking "Car leasing" link user is directed to relevant web page (A)(P1)
- #18. reaching "lease is allowed (max amount)" scenario and clicking "Fill leasing application" link anonymous user gets dialog message with a relevant text, and clicking "Submit application from website" is directed to relevant web page on expected language (it is enough to check title) (A)(P1) (here is a bug: the text is in Estonian instead of English)
- #19. reaching "lease is allowed (max amount)" scenario and clicking "Fill leasing application" link logged user is directed to relevant web page on expected language (it is enough to check title) (M)(P1)
- #20. reaching "lease is allowed (max amount)" scenario and clicking "Fill leasingapplication" link anonymous user gets dialog message, and logging in he is directed to relevant web page on expected language (it is enough here to check title) (M)(P1) 
---
#### Car leasing calculator section:
- #21. opening a section default values are selected available (A)(P3)
- #22. entering non-numeric data the field is highlighted red in any field (M)(P3)
- #23. entering non-numeric data in any field monthly payment amount is not calculated (A)(P3)
- #24. monthly payment amount is not calculated if mandatory field data is missing (M)(P2)
- #25. monthly payment amount is calculated correctly with all fields filled (A)(P1)
- #26. monthly payment amount is recalculated according to selected Type of lease (A)(P1)
- #27. informative text is changed according to selected Type of lease (A)(P2) 
- #28. Downpayment amount is correctly calculated automatically (A)(P2) 
- #29. clicking on Comparison button in the section, calculation is added to a table (find by comparing Price and Price of vehicle) (A)(P2)
- #30. clicking on Comparison button in the section, calculation is deleted from the table (find by comparing Price and Price of vehicle) (A)(P2)
- #31. the next Comparison is added under previous one, maximum 5 items are allowed (M)(A also ok)(P3)
- #32. clicking on Schedule button in the section, Schedule table is drawn below (can be found by comparing Amount To Be Paid and (Price of vehicle + lease type) (A)(P1) 
- #33. clicking on Schedule button in Comparisons table, Schedule table is drawn below (can be found by Total Lease compared with (can be found by comparing Amount To Be Paid and (Price of vehicle + lease type)) (A)(P2) 
- #34. print Schedule (M)(P2)
- #35. verify Schedule calculation (M)(A is also ok)(P1)

### Defing which testcase should (or should not) be automated I referred to certain principles. Test scenatious: 
##### 1. which include a plenty of basic routines of clicks and typings, should be automated to save manual testing time 
##### 2. where exact values have to be strictly compated (for examle for banking website text messages must be strictly as expected), should be automated to avoid "human" mistakes 
##### 3. where is known a specific calculation formula, should be automated to avoid "human" mistakes

##### The scenarios, where we:
##### 1. mostly deal with user experience, seeing a "big picture" and visual aspects,
##### 2. have to use 3rd party devices (PIN calculator, smartphone, Id card and card reader, printer etc),
##### 3. have a complex calculation, but they don't seem to be tested very often, 
##### I suggest to execute manually. 

---
#### Following three automated test cases are designed: #15, #18, #29
#### Java (frameworks: Selenide and TestNG), Chrome web browser
