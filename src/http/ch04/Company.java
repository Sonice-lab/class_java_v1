package http.ch04;

import lombok.Data;

/**
 * "company": {
 *  * "name": "Romaguera-Crona",
 *  * "catchPhrase": "Multi-layered client-server neural-net",
 *  * "bs": "harness real-time e-markets"
 *  * }
 */
@Data
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
