package jbasic.pattern.adapter.mediaPlayer;

/**
 * -Adapter - Structural pattern
 * -Used when two different interfaces needs to work together
 * -One interface already exists and getting used. Another incompatible interface
 * comes and has to use with first existing interface.
 *
 *         Interface1
 *        /          \
 *       /           \
 *  Class1 --uses--> Adapter --uses->Interface2
 *                                      |
 *                                      |
 *                                    Class2
 *  Create an adapter implementing first interface
 *  adapter uses Interface2, now
 *  map first interface methods calls to second interface methods
 *
 *  Now keep this adapter in Class1 and call adapter first interface methods
 *  on condition
 *
 *  Benefits: we are not disrupting existing structure and incorporating new one.
 *
 */
public class Client {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3");
        audioPlayer.play("vlc");
    }
}
