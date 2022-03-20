**SENG 637- Dependability and Reliability of Software Systems**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#: 08       |   |
|-----------------   |---|
|Student Names:      |   |
|Mit Patel           |   |
|Dishantkunar Patel  |   |
|Jairath Chopra      |   |
|Srujan Patel        |   |
# Introduction

# Link of demo video 

Make a video of the demo and put its link here.
All members must participate in the demo and the video should not be longer than 10 minutes.

# Analysis of 10 Mutants of the Range class 
In this section we will do analysis of least 10 mutants produced by Pitest for the Range class, and how they are killed or not by our original test suite. We are providing 5 instances where the mutant got killed and 5 where it didn't

1. Pitest replaced double return with 0.0d for org/jfree/data/Range::getLowerBound → KILLED
2. Pitest replaced double return with 0.0d for org/jfree/data/Range::getUpperBound → KILLED
3. Pitest replaced boolean return with true for org/jfree/data/Range::intersects → KILLED
4. Pitest replaced return value with null for org/jfree/data/Range::combineIgnoringNaN → KILLED
5. Pitest replaced double return with 0.0d for org/jfree/data/Range::min → KILLED
6. Pitest replaced double return with 0.0d for org/jfree/data/Range::min → NO_COVERAGE
7. Pitest removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted → SURVIVED
8. Pitest replaced boolean return with true for org/jfree/data/Range::equals → NO_COVERAGE
9. Pitest replaced int return with 0 for org/jfree/data/Range::hashCode → NO_COVERAGE
10. Pitest replaced boolean return with true for org/jfree/data/Range::intersects → SURVIVED
# Report all the statistics and the mutation score for each test class

Img1
![mution score](media/mutScore.png)

Mutation Score (Can be inferred from the above image) is 48% for the DataUtilities Class and 43% for the Range Class

Statistics can be inferred from the Img2 when pitclipse is run on the org.jfree.data.* package

Img2
![mution score](media/stats.png)


# Analysis drawn on the effectiveness of each of the test classes

Range Class
This class has a mutation coverage of 43%. 

Tests Examined:
- org.jfree.data.RangeTest.shiftTest(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.isNaNRangeTest(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.intersectsTest(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.combineIgnoringNaNTest(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.expandToIncludeTest(org.jfree.data.RangeTest) (0 ms)

Active Mutators Found:

- CONDITIONALS_BOUNDARY
- EMPTY_RETURNS
- FALSE_RETURNS
- INCREMENTS
- INVERT_NEGS
- MATH
- NEGATE_CONDITIONALS
- NULL_RETURNS
- PRIMITIVE_RETURNS
- TRUE_RETURNS
- VOID_METHOD_CALLS

Most mutants that did not get killed are because of no coverage. Since our code does not cover test cases for all the methods, this is expected.

DataUtilities Class

This class has a better mutation coverage thaan the Range class with 48% mutation coverage

Tests Examined:
- org.jfree.data.DataUtilitiesTest.testcalculateColumnTotal_1(org.jfree.data.DataUtilitiesTest) (0 ms)
- org.jfree.data.DataUtilitiesTest.testcalculateColumnTotal_2(org.jfree.data.DataUtilitiesTest) (16 ms)
- org.jfree.data.DataUtilitiesTest.getCumulativePercentages(org.jfree.data.DataUtilitiesTest) (516 ms)
- org.jfree.data.DataUtilitiesTest.testcalculateRowTotal_1(org.jfree.data.DataUtilitiesTest) (0 ms)
- org.jfree.data.DataUtilitiesTest.testcalculateRowTotal_2(org.jfree.data.DataUtilitiesTest) (0 ms)

Active Mutators Found:

- CONDITIONALS_BOUNDARY
- EMPTY_RETURNS
- FALSE_RETURNS
- INCREMENTS
- INVERT_NEGS
- MATH
- NEGATE_CONDITIONALS
- NULL_RETURNS
- PRIMITIVE_RETURNS
- TRUE_RETURNS
- VOID_METHOD_CALLS

In this case as well most of the mutants that did not get killed are because of no coverage. Since our code does not cover test cases for all the methods, this is expected.
# A discussion on the effect of equivalent mutants on mutation score accuracy



# A discussion of what could have been done to improve the mutation score of the test suites
An effective way to increase the mutation score by the required amount (10%) is by increasing the coverage through writing more test cases.

Img3
![mution score](media/mut.png)

We have added the following to improve the mutation score (as infered from img3):-
- org.jfree.data.RangeTest.testEquals(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.testConstrain(org.jfree.data.RangeTest) (0 ms)
- org.jfree.data.RangeTest.testToString(org.jfree.data.RangeTest) (16 ms)
- org.jfree.data.DataUtilitiesTest.testEqual(org.jfree.data.DataUtilitiesTest) (0 ms)


# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix


# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
