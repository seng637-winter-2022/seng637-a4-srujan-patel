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
    }
}