package oop_test.ch01;

public class MemberService {
    //service와 dao는 무슨 관계일까? 컴포지션 관계
    private MemberDao dao = new MemberDao();
    public void registerMember (String id, String name) {
        Member member = new Member(id, name);
        dao.insert(member);

    }
}
