package startcraft.ver_4;

//공통된 부분은 상속 처리
public class Marine extends Unit {

    public Marine(String name) {
        super.name = name;
        super.power = 4;
        super.hp = 70;
    }
}//end of class

