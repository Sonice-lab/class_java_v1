package useful.ch14;

public class HashTableTest {
    public static void main(String[] args) {

        String[] names = {"사 과", "바나나", "포도", "딸기", "수박"};
        for (String n :  names){
            System.out.println(n + "->" + n.hashCode());
        }
        //사과 -> 1573328, "사 과" -> 47445640 => hash함수 계산기, 공백 하나라도 다를 경우 주소값은 달라진다.
        System.out.println("---------------------------------");
        System.out.println("사과".hashCode());
    }//end of main
}
