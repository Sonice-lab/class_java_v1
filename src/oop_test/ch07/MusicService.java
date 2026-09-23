package oop_test.ch07;

import java.util.List;

public class MusicService {
    // 1. 직접 생성하지 않고 선언만 하기
    private MusicDao dao;

    // 2. 외부에서 생성된 객체를 파라미터로 주입받도록 설계(DI)
    public MusicService (MusicDao dao) {
        this.dao = dao;
        // 여기서 객체를 생성할 경우, 마름모는 채워진다.
    }

    public void addMusic(String title, String artist) {
        Music music = new Music(title, artist);
        dao.insert(music);
    }

    public void printPlaylist() {
        // 자신의 플레이리스트 목록 출력
        List<Music> musicList = dao.findAll();
        System.out.println("---전체 뮤직 플레이리스트 목록---");
        for(Music music : musicList) {
            System.out.println("곡명: " + music.getTitle() + "| 아티스트: " + music.getArtist());
        }
    }
}
