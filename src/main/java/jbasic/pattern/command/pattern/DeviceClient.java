package jbasic.pattern.command.pattern;

import jbasic.pattern.command.pattern.commands.TVOffCommand;
import jbasic.pattern.command.pattern.commands.TVOnCommand;
import jbasic.pattern.command.pattern.commands.VolumeDownCommand;
import jbasic.pattern.command.pattern.commands.VolumeUpCommand;
import jbasic.pattern.command.pattern.devices.Television;

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
