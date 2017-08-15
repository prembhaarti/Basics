package design.pattern.state.pattern;

public interface ATMState {

  public void insertCard();
  public void ejectCard();
  public void enterPin(int pin);
  public void requestCash(long amount);

}
