package inheritance;

/**
 * 회사에서 고객 정보를 활용한 맞춤 서비스를 하기 위해 일반고객(Customer)과
 * 이보다 충성도가 높은 우수고객(VIPCustomer)에 따른 서비스를 제공하고자 함
 *
 * 고객의 속성 : 고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립비율
 *  * 일반 고객의 경우 물품 구매시 1%의 보너스 포인트 적립
 */
public class Main {
    public static void main(String[] args) {
    VIPCustomer vip1 = new VIPCustomer();
        vip1.getAgentID(1);
    }//end of main
}//end of class
