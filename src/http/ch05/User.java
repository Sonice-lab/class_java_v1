package http.ch05;


import lombok.Data;

@Data
public class User {
    //받을 JSON의 형식을 확인하여 그릇(클래스) 만들기
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @Data
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Data
        public static class Geo {
            private String lat;
            private String lng;
        }

    }

    @Data
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

}

/**
 * {
 * "id": 1,
 * "name": "Leanne Graham",
 * "username": "Bret",
 * "email": "Sincere@april.biz",
 * "address": {
 * "street": "Kulas Light",
 * "suite": "Apt. 556",
 * "city": "Gwenborough",
 * "zipcode": "92998-3874",
 * "geo": {
 * "lat": "-37.3159",
 * "lng": "81.1496"
 * }
 * },
 * "phone": "1-770-736-8031 x56442",
 * "website": "hildegard.org",
 * "company": {
 * "name": "Romaguera-Crona",
 * "catchPhrase": "Multi-layered client-server neural-net",
 * "bs": "harness real-time e-markets"
 * }
 * }
 */







