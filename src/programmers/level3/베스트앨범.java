package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 28.
 */
@SuppressWarnings("NonAsciiCharacters")
public class 베스트앨범 {

    static class Song implements Comparable<Song> {
        private int index;
        private int streamingCount;
        private String genreName;

        public Song() {
        }

        public Song(int index, int streamingCount, String genreName) {
            this.index = index;
            this.streamingCount = streamingCount;
            this.genreName = genreName;
        }

        @Override
        public int compareTo(Song o) {
            if (this.streamingCount == o.streamingCount) return this.index - o.index;
            return -(this.streamingCount - o.streamingCount);
        }

        public int getIndex() {
            return index;
        }

        public String getGenreName() {
            return genreName;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Song> songList = new ArrayList<>();
        Map<String, Integer> genreStreamingCountMap = new HashMap<>();
        Map<String, Integer> albumCountMap = new HashMap<>();
        List<Integer> songIdList = new ArrayList<>();

        for (int i = 0; i < genres.length; ++i) {
            genreStreamingCountMap.put(genres[i], genreStreamingCountMap.getOrDefault(genres[i], 0) + plays[i]);
            songList.add(new Song(i, plays[i], genres[i]));
        }

        songList.sort((o1, o2) -> {
            if (o1.getGenreName().equals(o2.getGenreName())) {
                return o1.compareTo(o2);
            }
            return -1 * (genreStreamingCountMap.get(o1.getGenreName()) - genreStreamingCountMap.get(o2.getGenreName()));
        });

        for (Song song : songList) {
            String genre = song.getGenreName();
            if (albumCountMap.get(genre) == null) {
                albumCountMap.put(genre, 1);
                songIdList.add(song.getIndex());
                continue;
            }

            if (albumCountMap.get(genre) < 2) {
                albumCountMap.put(genre, 2);
                songIdList.add(song.getIndex());
            }
        }

        int[] result = new int[songIdList.size()];
        for (int i = 0; i < songIdList.size(); ++i) {
            result[i] = songIdList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

}
