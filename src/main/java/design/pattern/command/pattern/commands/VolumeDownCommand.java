package design.pattern.command.pattern.commands;

import design.pattern.command.pattern.Command;
import design.pattern.command.pattern.Device;

public class VolumeDownCommand implements Command {

  private Device device;

  public VolumeDownCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.volumeDown();
  }
}
