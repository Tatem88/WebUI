package Lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    @Test
    @DisplayName("Проверка метода isTriangle на равностороннем треугольнике")
    void isTriangleEquilateral() {
        boolean result = Triangle.isTriangle(7,7,7);
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка метода isTriangle на треугольнике")
    void isTriangle() {
        boolean result = Triangle.isTriangle(5,2,4);
        assertTrue(result);
    }

    @Test
    @DisplayName("Негативная проверка метода isTriangle")
    void isNotTriangleOne() {
        boolean result = Triangle.isTriangle(5,2,8);
        assertFalse(result);
    }

    @Test
    @DisplayName("Негативная проверка метода isTriangle, отрицательное число")
    void isNotTriangleTwo() {
        boolean result = Triangle.isTriangle(5,2,-4);
        assertFalse(result);
    }

    @Test
    @DisplayName("Негативная проверка метода isTriangle, нули")
    void isNotTriangleThree() {
        boolean result = Triangle.isTriangle(0,0,0);
        assertFalse(result);
    }
}



