package jbasic.pattern.command.pattern.commands;

import jbasic.pattern.command.pattern.Command;
import jbasic.pattern.command.pattern.Device;

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
