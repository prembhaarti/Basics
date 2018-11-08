package jbasic.pattern.decorator.pizza;

public class PlainPizza implements Pizza {
  @Override
  public String getDescription() {
    return "Plain Dough";
  }

  @Override
  public double getCost() {
    return 100.0;
  }
}
