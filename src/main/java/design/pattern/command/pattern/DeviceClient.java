package design.pattern.command.pattern;

import design.pattern.command.pattern.commands.TVOffCommand;
import design.pattern.command.pattern.commands.TVOnCommand;
import design.pattern.command.pattern.commands.VolumeDownCommand;
import design.pattern.command.pattern.commands.VolumeUpCommand;
import design.pattern.command.pattern.devices.Television;

/**
 * Created by lovebharti on 12/1/17.
 */
public class DeviceClient {

  public static void main(String[] args) {
    Device device= new Television();

    Command command = new TVOnCommand(device);
    command.execute();

    command = new TVOffCommand(device);
    command.execute();

    command = new VolumeUpCommand(device);
    command.execute();

    command = new VolumeDownCommand(device);
    command.execute();

  }

}
