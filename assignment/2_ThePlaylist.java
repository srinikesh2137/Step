import java.util.Arrays;

public class ThePlaylist {
    static class Playlist {
        private final String[] songs;
        private int songCount;

        Playlist(int maxSize) {
            songs = new String[maxSize];
            songCount = 0;
        }

        void addSong(String song) {
            if (song != null && songCount < songs.length) {
                songs[songCount++] = song;
            }
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}