package design.pattern.adapter.mediaPlayer;

public class MediaAdapter implements MediaPlayer{

    VideoMediaPlayer videoMediaPlayer;

    public MediaAdapter(String fileName) {
        if(fileName.endsWith("vlc")){
            videoMediaPlayer= new VlcPlayer();
        }
        if (fileName.endsWith("mp4")) {
            videoMediaPlayer= new MP4Player();
        }
    }

    @Override
    public void play(String fileName) {
        videoMediaPlayer.playVideo(fileName);
    }
}