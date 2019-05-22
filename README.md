# [Binary Algebraic Structures](https://en.wikipedia.org/wiki/Algebraic_structure)

## Introduction:

Addition and multiplication on numbers are the prototypical example of an operation that combines two elements of a set to produce a third.

## Usage:

Implement this Class to your project and call the method that you would to use, see examples below.

### Import manually:

* Download [Jar File](BinaryAlgebraicStructure.jar).

* Using Intellij: File -> Project Structure -> Libraries -> (+) symbol -> From Jar ... Import just [downloaded file](BinaryAlgebraicStructure.jar).

## Examples:

````java
/*
    public static void main(String[] args) {
        System.out.println(BAS.Mult("101", "100", "111")); // output: 100
        System.out.println(BAS.Add("101", "100", "111")); // output: 110
    }
*/
````

## Notes:

>  Addition: BAS.Add would work as [`"XOR operator"`](https://en.wikipedia.org/wiki/XOR_gate) or (Z2, +) math-group.

````java
    /*
     * + | 0 | 1
     * ----------
     * 0 | 0 | 1
     * ----------
     * 1 | 1 | 0
     *
     */
````

>  Multiplication: BAS.Mult works as [`"and operator"`](https://en.wikipedia.org/wiki/Bitwise_operation#AND) (Z2, *) math-group.

````java
    /*
     * * | 0 | 1
     * ----------
     * 0 | 0 | 0
     * ----------
     * 1 | 0 | 1
     *
     */
````
