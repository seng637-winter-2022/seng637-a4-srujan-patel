package org.jfree.data;
import static org.junit.Assert.*;
import org.junit.Test;

public class RangeTest {

    @Test
    public void shiftTest() {

        //Checking at values closer to null
        Range base = new Range(-0.00000001,0.00000001);
        double delta = 0.00000002;
        boolean allowZeroCrossing = true;
        Range exp_output = new Range(0.00000001,3.0000000000000004E-8);
        Range act_output = Range.shift(base, delta, allowZeroCrossing);

        //Checking at larger values at large displacements
        Range base1 = new Range(-99999.99999,99999.99999);
        double delta1 = 88888.88888;
        boolean allowZeroCrossing1 = false;
        Range exp_output1 = new Range(-11111.111109999998,188888.88887);
        Range act_output1 = Range.shift(base1, delta1, allowZeroCrossing1);



        assertEquals(exp_output, act_output);
        assertEquals(exp_output1, act_output1);

        // No Changes Required to the tests

    }

    @Test
    public void isNaNRangeTest() {

        double upper;
        double lower;
        Range range = new Range(-3.25, 3.25);
        boolean act_output = range.isNaNRange();

        double upper1;
        double lower1;
        Range range1 = new Range(Double.NaN, Double.NaN);
        boolean act_output1 = range.isNaNRange();

        double upper2;
        double lower2;
        Range range2 = new Range(Double.NaN, 3.25);
        boolean act_output2 = range.isNaNRange();

        double upper3;
        double lower3;
        Range range3 = new Range(-3.25, Double.NaN);
        boolean act_output3 = range.isNaNRange();

        assertEquals(false,act_output);
        assertEquals(false,act_output1);
        assertEquals(false,act_output2);
        assertEquals(false,act_output3);

    }

    @Test
    public void expandToIncludeTest() {

        //Checking at large values
        Range range = new Range(-99999.99999,99999.99999);
        double value = 999999999.0;
        Range act_output = Range.expandToInclude(range, value);
        Range exp_output = new Range(-99999.99999,999999999.0);

        //Checking at null values
        Range range1 = new Range(0.0000000,0.0000000);
        double value1 = 0.0000000;
        Range act_output1 = Range.expandToInclude(range1, value1);
        Range exp_output1 = new Range(0,0);

        // MC/DC Testing
        Range range2 = new Range(-3.0,3.0);
        double value2 = -4.0;
        Range act_output2 = Range.expandToInclude(range2, value2);
        Range exp_output2 = new Range(-4,3);

        Range range3 = new Range(-3.0,3.0);
        double value3 = 4.0;
        Range act_output3 = Range.expandToInclude(range3, value3);
        Range exp_output3 = new Range(-3.0,4.0);

        Range range4 = new Range(-3.0,3.0);
        double value4 = 1.0;
        Range act_output4 = Range.expandToInclude(range4, value4);
        Range exp_output4 = new Range(-3.0,3.0);

        Range range5 = null;
        double value5 = 1.0;
        Range act_output5 = Range.expandToInclude(range5, value5);
        Range exp_output5 = new Range(1.0,1.0);

        assertEquals(exp_output,act_output);
        assertEquals(exp_output1,act_output1);
        assertEquals(exp_output2,act_output2);
        assertEquals(exp_output3,act_output3);
        assertEquals(exp_output4,act_output4);
        assertEquals(exp_output5,act_output5);
    }

    @Test
    public void combineIgnoringNaNTest() {

        Range range1 = new Range(-99999.99999, Double.NaN);
        Range range2 = new Range(Double.NaN, 99999.99999);
        Range exp_output = new Range(-99999.99999, 99999.99999);
        Range act_output = Range.combineIgnoringNaN(range1, range2);

        Range range11 = new Range(Double.NaN, Double.NaN);
        Range range22 = new Range(-0.00000001, 1.0);
        Range exp_output1 = range22;
        Range act_output1 = Range.combineIgnoringNaN(range11, range22);

        Range range13 = new Range(-99999.99999, 1.0);
        Range range23 = new Range(Double.NaN, Double.NaN);
        Range exp_output3 = range13;
        Range act_output3 = Range.combineIgnoringNaN(range13, range23);

        Range range14 = new Range(Double.NaN, Double.NaN);
        Range range24 = new Range(Double.NaN, Double.NaN);
        Range exp_output4 = null;
        Range act_output4 = Range.combineIgnoringNaN(range14, range24);


        // MC/DC Testing

        Range range1_1 = null;
        Range range2_1 = new Range(-3.0,3.0);
        Range exp_output_1 = range2_1;
        Range act_output_1 = Range.combineIgnoringNaN(range1_1, range2_1);

        Range range1_2 = null;
        Range range2_2 = new Range(Double.NaN, Double.NaN);
        Range exp_output_2 = null;
        Range act_output_2 = Range.combineIgnoringNaN(range1_2, range2_2);

        Range range1_3 = null;
        Range range2_3 = null;
        Range exp_output_3 = range2_3;
        Range act_output_3 = Range.combineIgnoringNaN(range1_3, range2_3);

        Range range1_4 = new Range(-3.0,3.0);
        Range range2_4 = null;
        Range exp_output_4 = range1_4;
        Range act_output_4 = Range.combineIgnoringNaN(range1_4, range2_4);

        Range range1_5 = new Range(Double.NaN, Double.NaN);
        Range range2_5 = null;
        Range exp_output_5 = null;
        Range act_output_5 = Range.combineIgnoringNaN(range1_5, range2_5);

        assertEquals(exp_output,act_output);
        assertEquals(exp_output1,act_output1);
        assertEquals(exp_output3,act_output3);
        assertEquals(exp_output4,act_output4);
        assertEquals(exp_output_1,act_output_1);
        assertEquals(exp_output_2,act_output_2);
        assertEquals(exp_output_3,act_output_3);
        assertEquals(exp_output_4,act_output_4);
        assertEquals(exp_output_5,act_output_5);

    }

    @Test
    public void intersectsTest() {

        double b0 = -0.00000001;
        double b1 = 0.00000001;
        Range range = new Range(0.00000002,0.00000003);
        Boolean act_output = range.intersects(b0, b1);

        double b01 = -99999.99999;
        double b11 = 99999.99999;
        Range range1 = new Range(-99999.9901,99999.9901);
        Boolean act_output1 = range1.intersects(b0, b1);

        // MC/DC Testing

        double b0_1 = -3;
        double b1_1 = 1.0;
        Range range_1 = new Range(-3.0, 3.0);
        Boolean act_output_1 = range_1.intersects(b0, b1);

        double b0_2 = -2.0;
        double b1_2 = 1.0;
        Range range_2 = new Range(-3.0,3.0);
        Boolean act_output_2 = range_2.intersects(b0, b1);


        assertEquals(false,act_output);
        assertEquals(true,act_output1);
        assertEquals(true,act_output_1);
        assertEquals(true,act_output_2);

        //we are adding test case for constrain method to increase mutattion score



    }

    @Test
    public void testConstrain() {
        Range exampleRange1 = new Range(10, 15); //positive range
        double actual1 = exampleRange1.constrain(13); //value in middle

        assertEquals(13, actual1, 0);

        Range   exampleRange2 = new Range(10, 15);//positive range
        double  expectedValue = 15;
        double actual2 = exampleRange2.constrain(18);//greater than upper bound
        assertEquals(expectedValue, actual2, 0);

        Range exampleRange3 = new Range(10, 15); //positive
        double expectedValue3 = 10; //less than the lower bound
        double actual3 = exampleRange3.constrain(7);

        assertEquals(expectedValue3, actual3, 0);

       Range exampleRange4 = new Range(-8, -4); //negative
        double expectedValue4 = -5;
        double actual4 = exampleRange4.constrain(-5); //middle value

        assertEquals(expectedValue4, actual4, 0);

        Range exampleRange5 = new Range(-8, -4); //negative
        double expectedValue5 = -4;
        double actual5 = exampleRange5.constrain(-2); //bigger than upper bound

        assertEquals(expectedValue5, actual5, 0);

        Range exampleRange6 = new Range(-8, -4); //negative range
        double expectedValue6 = -8;
        double actual6 = exampleRange6.constrain(-20); //less than lower bound

        assertEquals(expectedValue6, actual6, 0);

        Range exampleRange7 = new Range(10, 15);
        double expectedValue7 = 10;
        double expectedValue8 = 15;

        double actual7 = exampleRange7.constrain(10);
        double actual8 = exampleRange7.constrain(15);

        assertEquals(expectedValue7, actual7, 0); //equal to lower
        assertEquals(expectedValue8, actual8, 0); //equal to lower

        Range exampleRange8 = new Range(-10, -5);
        double expectedValue9 = -10;
        double expectedValue10 = -5;

        double actual9 = exampleRange8.constrain(-10);
        double actual10 = exampleRange8.constrain(-5);

        assertEquals(expectedValue9, actual9, 0); //equal to lower
        assertEquals(expectedValue10, actual10, 0); //equal to lower
    }

    @Test
    public void testContains(){
        Range exampleRange1 = new Range(1, 10);
        assertTrue(exampleRange1.contains(1)); //lower edge testing
        assertTrue(exampleRange1.contains(10));// upper edge testing
        assertTrue(exampleRange1.contains(5));// middle value
        assertFalse(exampleRange1.contains(20));// greater than
        assertFalse(exampleRange1.contains(0));// less than

        Range exampleRange2 = new Range(-10, -2);
        assertTrue(exampleRange2.contains(-2)); //upper edge testing
        assertTrue(exampleRange2.contains(-10));// lower edge testing
        assertTrue(exampleRange2.contains(-5));// middle value
        assertFalse(exampleRange2.contains(-20));// less than
        assertFalse(exampleRange2.contains(-1));// greater than


    }
    @Test
    public void testEquals(){

      Range exampleRange1 = new Range(4, 5);
      Range  exampleRange2 = new Range(4, 5);
        assertTrue(exampleRange1.equals(exampleRange2)); //equal values

       Range exampleRange3 = new Range(3, 5);
        Range exampleRange4 = new Range(7, 10);
        assertFalse(exampleRange3.equals(exampleRange4)); //diffrent values expect false

        Range exampleRange5 = new Range(12, 15);
        Range exampleRange6 = null;

        assertFalse(exampleRange5.equals(exampleRange6)); //null comparision returns false


        Range exampleRange7 = new Range(-6, -1); //negative same
        Range exampleRange8 = new Range(-6, -1);
        assertTrue(exampleRange7.equals(exampleRange8));

        Range exampleRange9 = new Range(-6, -1); //different negative
        Range exampleRange10 = new Range(-26, -17);
        assertFalse(exampleRange9.equals(exampleRange10));

        exampleRange1 = new Range(10, 12); //positive range
        exampleRange2 = new Range(-16, -7); //negative range
        assertFalse(exampleRange1.equals(exampleRange2)); //return false

    }

    @Test
    public void testToString(){
        Range exampleRange = new Range(-2000000, 2000000);
        assertEquals("Range[" + -2000000.0 + "," + 2000000.0 + "]", exampleRange.toString());

    }
}