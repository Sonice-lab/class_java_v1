package oop_test.ch03;

public class Main {

    public static void main(String[] args) {
    ProductService productService = new ProductService();
    productService.registerProduct("기계식 키보드", 150000);


    }
}

//# 실습 문제 3: 상품 등록 흐름 구현하기
//
//## 안내 사항
//
//이 문제는 객체 생성과 메서드 호출 흐름을 연습하기 위한 실습입니다. 실제 데이터베이스(JDBC) 연결이나 SQL 동작 코드는 구현할 필요가 없으며, 요구사항에 적힌 대로 화면 출력(System.out.println)으로만 흐름이 이어지는지 확인하면 됩니다.
//
//새로운 자바 프로젝트를 만들고, 아래의 역할에 맞춰 총 4개의 클래스를 설계해 보세요.
//
//        ### 1. Product 클래스 (데이터 객체)
//
//- 필드: name (문자열), price (정수)
//        - 기능: 필드값을 초기화하는 생성자를 만들고, 값을 가져올 수 있는 Getter 메서드를 작성하세요.
//
//        ### 2. ProductDao 클래스 (데이터 처리 객체)
//
//- 메서드: insertProduct
//- 파라미터: Product 객체
//- 기능: 파라미터로 전달받은 Product 객체에서 상품명과 가격을 꺼내어 "상품명: [상품명], 가격: [가격]원 - 상품이 DB에 등록되었습니다." 라고 화면에 출력하세요.
//
//### 3. ProductService 클래스 (비즈니스 로직 객체)
//
//- 필드: ProductDao dao (객체를 생성해서 초기화해 두세요.)
//- 메서드: registerProduct
//- 파라미터: name (문자열), price (정수)
//        - 기능:
//        1. 파라미터로 받은 name과 price를 이용해 새로운 Product 객체를 생성하세요.
//2. 생성한 Product 객체를 dao 객체의 insertProduct 메서드 파라미터로 전달하여 호출하세요.
//
//        ### 4. Main 클래스 (실행)
//
//- 기능: main 메서드 내부에서 ProductService 객체를 생성하고, registerProduct("기계식 키보드", 150000) 메서드를 호출하여 전체 실행 흐름이 정상적으로 동작하는지 확인하세요.
//
//        ### 5. 클래스 다이어 그램을 도구를 활용해서 직접  그려 보세요
