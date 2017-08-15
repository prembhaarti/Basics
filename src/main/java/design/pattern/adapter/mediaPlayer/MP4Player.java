package design.pattern.adapter.mediaPlayer;

public class MP4Player implements VideoMediaPlayer {

    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing mp4");
    }
}
