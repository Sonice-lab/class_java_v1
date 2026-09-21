package oop_test.ch02;

public class BoardService {
    // dao 객체 생성
    private BoardDao dao = new BoardDao();
    public void writePost(String title, String content) {
        Board board = new Board(title, content);
        dao.insertPost(board);

    }

}
