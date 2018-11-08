package jbasic.pattern.decorator.pizza;

public class SaucePizza extends PizzaDecorator {

  public SaucePizza(Pizza pizza){
    super(pizza);
  }

  @Override
  public String getDescription() {
    return pizza.getDescription()+", sauce";
  }

  @Override
  public double getCost() {
    return pizza.getCost()+30.0;
  }
}
