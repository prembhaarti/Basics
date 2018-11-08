package jbasic.pattern.command.pattern.commands;

import jbasic.pattern.command.pattern.Command;
import jbasic.pattern.command.pattern.Device;

/**
 * Created by lovebharti on 12/1/17.
 */
public class TVOnCommand implements Command {
  private Device device;

  public TVOnCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.deviceOn();
  }
}
