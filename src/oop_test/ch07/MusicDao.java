package oop_test.ch07;

import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    private List<Music> musicList = new ArrayList<>();

    public void insert(Music music) {
        musicList.add(music);
        System.out.println(music.getTitle() + ("를 재생합니다."));
    }

    public List<Music> findAll() {
        return musicList;
    }

}
