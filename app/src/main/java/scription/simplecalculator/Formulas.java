package scription.simplecalculator;

/**
 * Formulas
 *
 * Contains the formulas for a calculator to perform.
 */
public class Formulas {

    /**
     * quadraticEquation
     *
     * Calculates the roots of a quadratic equation and returns the roots to the user.
     *
     * @param theAValue is the first value from the quadratic function.
     * @param theBValue is the second value from the quadratic function.
     * @param theCValue is the third value from the quadratic function.
     * @return an array containing the two roots of the quadratic function.
     */
    public double[] quadraticEquation(double theAValue, double theBValue, double theCValue) {
        double firstX = (-theBValue + Math.sqrt((theBValue * theBValue) - (4 * theAValue *
                theCValue))) / (2 * theAValue);
        double secondX = (-theBValue - Math.sqrt((theBValue * theBValue) - (4 * theAValue *
                theCValue))) / (2 * theAValue);
        double[] result = {firstX, secondX};
        return result;
    }

    /**
     * factorial
     *
     * Performs the factorial function on the number passed in through the parameter. Returns -1
     * if invalid input to the function.
     *
     * @param theNumber is the number to perform factorial function on.
     * @return the result of the factorial function.
     */
    public double factorial(double theNumber) {
        double result = 1;
        if (theNumber < 0) {
            result = -1;
        }
        while (theNumber > 0) {
            result *= theNumber--;
        }
        return result;
    }

    /**
     * area
     *
     * Calculate the area of a given shape and returns the result.
     *
     * @param theShape is the shape to calculate the area for.
     * @param theValues is the lengths of the sides.
     * @return the calculated area of the given shape.
     */
    public double area(String theShape, double[] theValues) {
        double result = 0;
        double height;
        switch (theShape) {
            case "circle":
                double radius = theValues[0];
                result = Math.PI *  radius * radius;
                break;
            case "square":
                double length = theValues[0];
                double width = theValues[1];
                result = length * width;
                break;
            case "triangle":
                double base = theValues[0];
                height = theValues[1];
                result = .5 * (base * height);
                break;
            case "trapezoid":
                double base1 = theValues[0];
                double base2 = theValues[1];
                height = theValues[2];
                result = .5 * (base1 + base2) * height;
                break;
        }
        return result;
    }

    /**
     * pythagoreanTheorem
     *
     * Finds the missing side of a right triangle or determines if the values form a right triangle.
     *
     * @param theAValue is the value of the first side.
     * @param theBValue is the value of the second side.
     * @param theCValue is the value of the hypotenuse.
     * @param missingValue is an integer to determine which side to find or determine if triangle is
     *                     a right triangle.
     * @return the given side of the right triangle or determine if it's a right triangle based off
     * the user selection.
     */
    public double pythagoreanTheorem(double theAValue, double theBValue, double theCValue,
                                           int missingValue) {
        double result = -1;
        double calculation = 0;
        switch(missingValue) {
            case 0: // Find the value of A
                calculation = (theCValue * theCValue) - (theBValue * theBValue);
                result = Math.sqrt(calculation);
                break;
            case 1: // Find the value of B
                calculation = (theCValue * theCValue) - (theAValue * theAValue);
                result = Math.sqrt(calculation);
                break;
            case 2: // Find the value of C
                calculation = (theAValue * theAValue) + (theBValue * theBValue);
                result = Math.sqrt(calculation);
                break;
            case 3: // Determine if the sides form a right triangle
                calculation = (theAValue * theAValue) + (theBValue * theBValue);
                double rightSide = theCValue * theCValue;
                if (calculation == rightSide) {
                    result = 1; // Triangle is a right triangle
                } else {
                    result = -1; // Triangle is not a right triangle
                }
                break;
        }
        return result;
    }

}
