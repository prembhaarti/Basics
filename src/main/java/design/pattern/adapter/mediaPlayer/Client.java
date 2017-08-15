package design.pattern.adapter.mediaPlayer;

public class Client {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3");
        audioPlayer.play("vlc");
    }
}
