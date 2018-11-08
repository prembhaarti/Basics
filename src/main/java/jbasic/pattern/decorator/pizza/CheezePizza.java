package jbasic.pattern.decorator.pizza;

public class CheezePizza extends PizzaDecorator{

  public CheezePizza(Pizza pizza){
    super(pizza);
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() +", Cheeze";
  }

  @Override
  public double getCost() {
    return pizza.getCost()+ 50;
  }
}