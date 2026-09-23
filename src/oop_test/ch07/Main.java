package oop_test.ch07;

public class Main {

    public static void main(String[] args) {
        // 1.사용할 부품(dao) 먼저 생성
        MusicDao musicDao = new MusicDao();

        // 2. 서비스 객체를 생성할 때 부분(Dao)을 주입받도록 설계
        // 의존성 주입
        MusicService service = new MusicService(musicDao);

        // 3. 동작 확인
        service.addMusic("김경호", "금지된 사랑");
        service.addMusic("조성모", "to heaven");
        service.addMusic("클라잉넛", "말달리자.");

        service.printPlaylist();
    }
}
