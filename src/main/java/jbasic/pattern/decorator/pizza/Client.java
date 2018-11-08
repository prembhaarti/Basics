package jbasic.pattern.decorator.pizza;

/**
 * Decorator Pattern - Structural
 *
 * Used when we need to modify object behaviour at runtime without
 * changing existing object.
 *
 *           Interface
 *             |     \
 *          Class     \
 *                    AbstractClass -->uses--> Interface
 *             \            |
 *              -requires-Type1Class*
 *
 * Type1Class - get simplepizza and sets into its super abstract class
 *              now in type1Class method get super pizza and alter it's value and return
 * Type2Class - it will get Type1Class sets in its super class and does same.
 *
 *
 */
public class Client {

  public static void main(String[] args) {
    Pizza pizza= new SaucePizza(new CheezePizza(new PlainPizza()));
    System.out.println(pizza.getDescription());
    System.out.println(pizza.getCost());
  }


}
