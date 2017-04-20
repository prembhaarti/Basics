package design.pattern.command.pattern.commands;

import design.pattern.command.pattern.Command;
import design.pattern.command.pattern.Device;

public class TVOffCommand implements Command {
  private Device device;

  public TVOffCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.deviceOff();
  }
}
