package design.pattern.command.pattern.commands;

import design.pattern.command.pattern.Command;
import design.pattern.command.pattern.Device;

public class VolumeUpCommand implements Command {

  private Device device;

  public VolumeUpCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.volumeUp();
  }
}
