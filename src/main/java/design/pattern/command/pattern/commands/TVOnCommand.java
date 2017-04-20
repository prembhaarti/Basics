package design.pattern.command.pattern.commands;

import design.pattern.command.pattern.Command;
import design.pattern.command.pattern.Device;

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
