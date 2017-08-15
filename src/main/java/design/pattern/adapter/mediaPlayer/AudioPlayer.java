package design.pattern.adapter.mediaPlayer;

public class AudioPlayer implements MediaPlayer{

    MediaAdapter videoAdapter;



    @Override
    public void play(String fileName) {
        if(fileName.endsWith("mp3")){
            System.out.println(fileName+" is playing");
        }
        if(fileName.endsWith("vlc")){
            videoAdapter= new MediaAdapter("vlc");
            videoAdapter.play(fileName);
        }
        if(fileName.endsWith("mp4")){
            videoAdapter= new MediaAdapter("mp4");
            videoAdapter.play(fileName);
        }

    }
}
