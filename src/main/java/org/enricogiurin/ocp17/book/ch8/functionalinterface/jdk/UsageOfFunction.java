package org.enricogiurin.ocp17.book.ch8.functionalinterface.jdk;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class UsageOfFunction {

  public static void main(String[] args) {
    new UsageOfFunction().andThen();
  }

  void compose() {
    Function<Integer, Integer> f1 = n -> n * 2;
    Function<Integer, Integer> f2 = n -> n + 3;
    Function<Integer, Integer> compose = f1.compose(f2);

    //Returns a composed function that first applies the before function to its input, and then applies this function to the result.
    Integer result = compose.apply(4);  //(4+3) * 2
    System.out.println(result);
  }

  void biFunction() {
    //Cannot mix 'var' and explicitly typed parameters in lambda expression
    //BiFunction<Integer, Integer, Integer> bf = (Integer x, var y)->5;

    BiFunction<Integer, Integer, Integer> bf1 = (var x, var y) -> 5;
    BiFunction<Integer, Integer, Integer> bf2 = (Integer x, Integer y) -> 5;
    IntBinaryOperator intBinaryOperator = (int x, int y) -> 5;
  }

  void biFunctionWithDouble() {
    //this does not compile
    //while an int(primitive) can be assigned to a double, an int cannot be assigned to a Double (wrapper)
    //BiFunction<Integer, Integer, Double> biFunction = (s, p)->s+p;  //does not compile

    BiFunction<Integer, Double, Double> biFunction = (s, p) -> s + p;  //this compiles!
  }

  //CGPT
  void andThen() {
    Function<String, String> toUpperCase = String::toUpperCase;

    // Define the second function: Add a prefix
    Function<String, String> addPrefix = s -> "Mr. " + s;

    // Compose the functions using andThen
    Function<String, String> composedFunction = addPrefix.andThen(toUpperCase);

    // Apply the composed function
    String result = composedFunction.apply("hello");

    // Output the result
    System.out.println(result);  // Output: MR. HELLO
  }
}
