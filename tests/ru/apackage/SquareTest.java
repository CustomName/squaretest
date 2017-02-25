package ru.apackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Vladimir Bogodukhov
 **/
@RunWith(Parameterized.class)
public class SquareTest {

    public Square square;
    public double length;
    public double maxDelta;

    public SquareTest(Double length, Double maxDelta){
        this.length = length;
        this.maxDelta = maxDelta;
    }

    @Before
    public void initialize(){
        square = SquareFactory.newSquare(length);
        System.out.println("-------------------------------------------------------");
        System.out.println("Input data:");
        System.out.println("Length = " + length);
        System.out.println("Delta = " + maxDelta);
    }

    @Parameterized.Parameters
    public static Collection getTestData(){
        return Arrays.asList(new Object[][]{
                {-0.1, 0.01},
                {0.0, 0.01},
                {0.1, 0.01},
                {9.9, 0.01},
                {10.0, 0.01},
                {10.1, 0.01},
                {19.9, 0.01},
                {20.0, 0.01},
                {20.1, 0.01},
                {29.9, 0.01},
                {30.0, 0.01},
                {30.1, 0.01},
                {39.9, 0.01},
                {40.0, 0.01},
                {40.1, 0.01},
        });
    }

    @Test
    public void testSideLength() {
        System.out.format("expected length = %.2f, actual length = %.2f, delta = %.2f%n", length, square.sideLength(), (length - square.sideLength()));
        assertEquals("Actual length must be equals expected length", length, square.sideLength(), maxDelta);
        System.out.println("RESULT: OK");
    }

    @Test
    public void testPositiveSideLength(){
        System.out.format("Length must be positive%n");
        assertTrue("Length must be positive", square.sideLength() > 0);
        System.out.println("RESULT: OK");
    }

    @Test
    public void testSquare() {
        System.out.format("expected square = %.2f, actual square = %.2f, delta = %.2f%n", length * length, square.square(), (length * length - square.square()));
        assertEquals("Actual square must be equals expected square", length * length, square.square(), maxDelta);
        System.out.println("RESULT: OK");
    }

    @Test
    public void testEqualsSquare(){
        Square square2 = SquareFactory.newSquare(length);
        System.out.format("square1 with length = %.2f, square2 with length = %.2f: expected that squares equal%n", square.sideLength(), square2.sideLength());
        assertTrue("Squares must be equal", square.equalsSquare(square2));
        System.out.println("RESULT: OK");
    }

    @Test
    public void testNotEqualsSquare(){
        Square square2 = SquareFactory.newSquare(length + 1.0d);
        System.out.format("square1 with length = %.2f, square2 with length = %.2f: expected that squares not equal%n", square.sideLength(), square2.sideLength());
        assertFalse("Squares must not be equal", square.equalsSquare(square2));
        System.out.println("RESULT: OK");
    }

}
