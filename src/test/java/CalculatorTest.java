import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    Calculator sut;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
        sut = new Calculator();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
        sut = null;
    }

    @ParameterizedTest
    @MethodSource("plusSourse")
    public void testPlusWithParametrs(int a, int b, int expected) {
        System.out.println("Test plus with parameters");

        int result = sut.plus.apply(a, b);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> plusSourse() {
        return Stream.of(Arguments.of(1, 5, 6),
                Arguments.of(7, 9, 16),
                Arguments.of(13, 25, 38)
        );
    }

    @ParameterizedTest
    @MethodSource("minusSourse")
    public void testMinusWithParametrs(int a, int b, int expected) {
        System.out.println("Test minus with parameters");

        int result = sut.minus.apply(a, b);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> minusSourse() {
        return Stream.of(Arguments.of(9, 9, 0),
                Arguments.of(125, 13, 112),
                Arguments.of(1524, 524, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplaySourse")
    public void testMultiplayWithParametrs(int a, int b, int expected) {
        System.out.println("Test multiplay with parameters");

        int result = sut.multiply.apply(a, b);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> multiplaySourse() {
        return Stream.of(Arguments.of(9, 0, 0),
                Arguments.of(45, 10, 450),
                Arguments.of(11, 11, 121)
        );
    }

    @ParameterizedTest
    @MethodSource("devideSourse")
    public void testDevideWithParametrs(int a, int b, int expected) {
        System.out.println("Test devide with parameters");

        int result = sut.devide.apply(a, b);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> devideSourse() {
        return Stream.of(Arguments.of(9, 0, 0),
                Arguments.of(45, 10, 4),
                Arguments.of(11, 11, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("powSourse")
    public void testPowWithParametrs(int a, int expected) {
        System.out.println("Test pow with parameters");

        int result = sut.pow.apply(a);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> powSourse() {
        return Stream.of(Arguments.of(3, 9),
                Arguments.of(11, 121),
                Arguments.of(5, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("absSourse")
    public void testAbsWithParametrs(int a, int expected) {
        System.out.println("Test pow with parameters");

        int result = sut.abs.apply(a);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> absSourse() {
        return Stream.of(Arguments.of(3, 3),
                Arguments.of(-11, 11),
                Arguments.of(5, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("isPositiveSourse")
    public void testIsPositiveWithParametrs(int a, boolean expected) {
        System.out.println("Test isPositive with parameters");

        boolean result = sut.isPositive.test(a);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> isPositiveSourse() {
        return Stream.of(Arguments.of(3, true),
                Arguments.of(-11, false),
                Arguments.of(5, true)
        );
    }

    @ParameterizedTest
    @MethodSource("isNegativeSourse")
    public void testIsNegativeWithParametrs(int a, boolean expected) {
        System.out.println("Test isNegative with parameters");

        boolean result = sut.isNegative.test(a);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> isNegativeSourse() {
        return Stream.of(Arguments.of(3, false),
                Arguments.of(-11, true),
                Arguments.of(5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("cubeSourse")
    public void testCubeWithParametrs(int a, int expected) {
        System.out.println("Test cube with parameters");

        int result = sut.cube.apply(a);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> cubeSourse() {
        return Stream.of(Arguments.of(3, 27),
                Arguments.of(1, 1),
                Arguments.of(0, 0)
        );
    }
}
