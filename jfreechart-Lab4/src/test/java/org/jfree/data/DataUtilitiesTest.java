package org.jfree.data;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataUtilitiesTest {

    private Values2D mockValues2D;
    private KeyedValues mockKeyedValues;
    private int[] a = null;
    private int[] b = null;


    @Test
    public void testcalculateColumnTotal_1() {

        //Checking at large values
        Values2D mockValues2D = mock(Values2D.class);
        when(mockValues2D.getColumnCount()).thenReturn(2);
        when(mockValues2D.getRowCount()).thenReturn(2);
        when(mockValues2D.getValue(0, 0)).thenReturn(99999.99999);
        when(mockValues2D.getValue(1, 0)).thenReturn(99999.99999);


        // Checking at values closer to null
        Values2D mockValues2D1 = mock(Values2D.class);
        when(mockValues2D1.getColumnCount()).thenReturn(2);
        when(mockValues2D1.getRowCount()).thenReturn(2);
        when(mockValues2D1.getValue(0, 0)).thenReturn(0.000000001);
        when(mockValues2D1.getValue(1, 0)).thenReturn(0.000000001);

        // MC/DC testing

        Values2D mockValues2D2 = mock(Values2D.class);
        when(mockValues2D2.getColumnCount()).thenReturn(2);
        when(mockValues2D2.getRowCount()).thenReturn(0);

        Values2D mockValues2D3 = mock(Values2D.class);
        when(mockValues2D3.getColumnCount()).thenReturn(2);
        when(mockValues2D3.getRowCount()).thenReturn(2);
        when(mockValues2D3.getValue(0, 0)).thenReturn(0);
        when(mockValues2D3.getValue(1, 0)).thenReturn(0);


        double result_1 = DataUtilities.calculateColumnTotal(mockValues2D, 0);
        double result_11 = DataUtilities.calculateColumnTotal(mockValues2D1, 0);
        double result3_1 = DataUtilities.calculateColumnTotal(mockValues2D2, 0);
        double result3_2 = DataUtilities.calculateColumnTotal(mockValues2D3, 0);


        assertEquals(199999.99998, result_1, 0.000000001d);
        assertEquals(0.000000002, result_11, 0.000000001d);
        assertEquals(0, result3_1, 0.000000001d);
        assertEquals(0, result3_2, 0.000000001d);
    }

    @Test
    public void testcalculateRowTotal_1() {

        //Checking at large values
        Values2D mockValues2D = mock(Values2D.class);
        when(mockValues2D.getColumnCount()).thenReturn(2);
        when(mockValues2D.getRowCount()).thenReturn(2);
        when(mockValues2D.getValue(1, 0)).thenReturn(99999.99999);
        when(mockValues2D.getValue(1, 1)).thenReturn(99999.99999);

        // Checking at values closer to null
        Values2D mockValues2D1 = mock(Values2D.class);
        when(mockValues2D1.getColumnCount()).thenReturn(2);
        when(mockValues2D1.getRowCount()).thenReturn(2);
        when(mockValues2D1.getValue(1, 0)).thenReturn(0.000000001);
        when(mockValues2D1.getValue(1, 1)).thenReturn(0.000000001);

        // MC/DC testing
        Values2D mockValues2D2 = mock(Values2D.class);
        when(mockValues2D2.getColumnCount()).thenReturn(0);
        when(mockValues2D2.getRowCount()).thenReturn(2);

        Values2D mockValues2D3 = mock(Values2D.class);
        when(mockValues2D3.getColumnCount()).thenReturn(2);
        when(mockValues2D3.getRowCount()).thenReturn(2);
        when(mockValues2D3.getValue(1, 0)).thenReturn(0);
        when(mockValues2D3.getValue(1, 1)).thenReturn(0);


        double result_2 = DataUtilities.calculateRowTotal(mockValues2D, 1);
        double result_22 = DataUtilities.calculateRowTotal(mockValues2D1, 1);
        double result3_1 = DataUtilities.calculateRowTotal(mockValues2D2, 1);
        double result3_2 = DataUtilities.calculateRowTotal(mockValues2D3, 1);


        assertEquals(199999.99998, result_2, 0.000000001d);
        assertEquals(0.000000002, result_22, 0.000000001d);
        assertEquals(0, result3_1, 0.000000001d);
        assertEquals(0, result3_2, 0.000000001d);

    }

    @Test
    public void testcalculateColumnTotal_2() {

        Values2D mockValues2D = mock(Values2D.class);
        when(mockValues2D.getColumnCount()).thenReturn(4);
        when(mockValues2D.getRowCount()).thenReturn(4);
        when(mockValues2D.getValue(0, 0)).thenReturn(-99999.99999);
        when(mockValues2D.getValue(1, 0)).thenReturn(-0.000000001);
        when(mockValues2D.getValue(2, 0)).thenReturn(-99999.99999);
        when(mockValues2D.getValue(3, 0)).thenReturn(0.000000001);

        int a[] = {0, 2};
        int b[] = {1, 3};

        //Checking at large negative values(magnitude wise)
        double result_3 = DataUtilities.calculateColumnTotal(mockValues2D, 0, a);

        //Checking at values close to null
        double result_33 = DataUtilities.calculateColumnTotal(mockValues2D, 0, b);

        // MC/DC Testing

        Values2D mockValues2D1 = mock(Values2D.class);
        when(mockValues2D1.getColumnCount()).thenReturn(4);
        when(mockValues2D1.getRowCount()).thenReturn(4);
        when(mockValues2D1.getValue(0, 0)).thenReturn(0);
        when(mockValues2D1.getValue(1, 0)).thenReturn(9);
        when(mockValues2D1.getValue(2, 0)).thenReturn(0);
        when(mockValues2D1.getValue(3, 0)).thenReturn(9);

        int a1[] = {0, 2};
        //int b1[] = {1,3};
        int c[] = {0, 4};
        int d[] = new int[2];

        double result3_1 = DataUtilities.calculateColumnTotal(mockValues2D1, 0, c);
        double result3_2 = DataUtilities.calculateColumnTotal(mockValues2D1, 0, a1);
        //double result3_3 = DataUtilities.calculateColumnTotal(mockValues2D1, 0, b1);
        double result3_4 = DataUtilities.calculateColumnTotal(mockValues2D, 0, d);


        assertEquals(-199999.99998, result_3, 0.000000001d);
        assertEquals(0.000000000, result_33, 0.000000001d);
        assertEquals(0, result3_1, 0.000000001d);
        assertEquals(0, result3_2, 0.000000001d);
        assertEquals(-199999.99998, result3_4, 0.000000001d);

    }

    @Test
    public void testcalculateRowTotal_2() {

        Values2D mockValues2D = mock(Values2D.class);
        when(mockValues2D.getColumnCount()).thenReturn(4);
        when(mockValues2D.getRowCount()).thenReturn(4);
        when(mockValues2D.getValue(0, 0)).thenReturn(-99999.99999);
        when(mockValues2D.getValue(0, 1)).thenReturn(-0.000000001);
        when(mockValues2D.getValue(0, 2)).thenReturn(-99999.99999);
        when(mockValues2D.getValue(0, 3)).thenReturn(0.000000001);

        int a[] = {0, 2};
        int b[] = {1, 3};

        //Checking at large negative values(magnitude wise)
        double result_3 = DataUtilities.calculateColumnTotal(mockValues2D, 0, a);

        //Checking at values close to null
        double result_33 = DataUtilities.calculateColumnTotal(mockValues2D, 0, b);

        // MC/DC Testing
        Values2D mockValues2D1 = mock(Values2D.class);
        when(mockValues2D1.getColumnCount()).thenReturn(4);
        when(mockValues2D1.getRowCount()).thenReturn(4);
        when(mockValues2D1.getValue(0, 0)).thenReturn(0);
        when(mockValues2D1.getValue(0, 1)).thenReturn(9);
        when(mockValues2D1.getValue(0, 2)).thenReturn(0);
        when(mockValues2D1.getValue(0, 3)).thenReturn(9);

        int a1[] = {0, 2};
        //int b1[] = {1,3};
        int c[] = {0, 4};
        int d[] = new int[2];

        double result3_1 = DataUtilities.calculateRowTotal(mockValues2D1, 0, c);
        double result3_2 = DataUtilities.calculateRowTotal(mockValues2D1, 0, a1);
        //double result3_3 = DataUtilities.calculateRowTotal(mockValues2D1, 0, b1);
        double result3_4 = DataUtilities.calculateRowTotal(mockValues2D, 0, d);


        assertEquals(-99999.99999, result_3, 0.000000001d);
        assertEquals(0.000000000, result_33, 0.000000001d);
        assertEquals(0, result3_1, 0.000000001d);
        assertEquals(0, result3_2, 0.000000001d);
        assertEquals(-199999.99998, result3_4, 0.000000001d);

    }

    @Test
    public void getCumulativePercentages() {

        KeyedValues mockKeyedValues = mock(KeyedValues.class);
        List<Integer> keyList = Arrays.asList(0, 1, 2);

        when(mockKeyedValues.getItemCount()).thenReturn(3);

        when(mockKeyedValues.getValue(0) ).thenReturn(-5);
        when(mockKeyedValues.getValue(1) ).thenReturn(10);
        when(mockKeyedValues.getValue(2) ).thenReturn(20);

        when(mockKeyedValues.getKey(0)).thenReturn(0);
        when(mockKeyedValues.getKey(1)).thenReturn(1);
        when(mockKeyedValues.getKey(2)).thenReturn(2);

        when(mockKeyedValues.getIndex(0)).thenReturn(0);
        when(mockKeyedValues.getIndex(1)).thenReturn(1);
        when(mockKeyedValues.getIndex(2)).thenReturn(2);

        when(mockKeyedValues.getKeys()).thenReturn(keyList) ;
        double expected1 = -0.2;
        double expected2=0.2;
        int a = 0;
        int b=1;
        KeyedValues actual = DataUtilities.getCumulativePercentages(mockKeyedValues);
        assertEquals(expected1, actual.getValue(a).doubleValue(), 0.01d); //index 0 negative test
        assertEquals(expected2, actual.getValue(b).doubleValue(), 0.01d); //index 1 positive test

    }
    @Test
    public void testEqual(){

        double[][] a1 = new double[][]{{1, 2, 3}, {4, 5, 6}};
        double[][] a2 = new double[][]{{1, 2, 3}, {4, 5, 6}};
        assertTrue(DataUtilities.equal(a1, a2));

        double[][] a3 = null;
        double[][] a4 = null;
        assertFalse(DataUtilities.equal(a3, a1)); //first parameter null
        assertFalse(DataUtilities.equal(a1, a3)); //second paramenter null

        assertTrue(DataUtilities.equal(a4, a3)); //both are null

        double[][] a5 = new double[][]{{1, 2, 3, 4,6,8}, {5, 6, 7}, {1, 1, 7}}; //different length compare
        assertFalse(DataUtilities.equal(a1, a5));

        double[][] a6 = new double[][]{{1, 2, 3}, {5, 5, 6}};
        assertFalse(DataUtilities.equal(a1, a6)); //same length but not same value
    }
}