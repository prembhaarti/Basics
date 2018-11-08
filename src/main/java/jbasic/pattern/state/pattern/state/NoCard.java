package jbasic.pattern.state.pattern.state;

import jbasic.pattern.state.pattern.ATMState;
import jbasic.pattern.state.pattern.AtmMachine;

/**
 * Created by lovebharti on 12/1/17.
 */
public class NoCard implements ATMState {

  private AtmMachine machine;

  public NoCard(AtmMachine machine){
    this.machine=machine;
  }

  @Override
  public void insertCard() {

  }

  @Override
  public void ejectCard() {

  }

  @Override
  public void enterPin(int pin) {

  }

  @Override
  public void requestCash(long amount) {

  }
}
