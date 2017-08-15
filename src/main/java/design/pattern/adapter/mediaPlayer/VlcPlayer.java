package design.pattern.adapter.mediaPlayer;

public class VlcPlayer implements VideoMediaPlayer {

    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing vlc player");
    }
}
