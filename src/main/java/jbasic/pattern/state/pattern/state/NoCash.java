package jbasic.pattern.state.pattern.state;

import jbasic.pattern.state.pattern.ATMState;
import jbasic.pattern.state.pattern.AtmMachine;

/**
 * Created by lovebharti on 12/1/17.
 */
public class NoCash implements ATMState {

  private AtmMachine machine;

  public NoCash(AtmMachine machine){
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
