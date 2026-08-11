package useful.ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//sorted -  중간 연산, 정렬해주는 녀석!
public class StreamDemo6 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5,3,1,4,2);

        //오름차순
        List<Integer> asc = numbers.stream()
                .sorted()
                .toList();

        System.out.println(asc);  //[1, 2, 3, 4, 5]

        //내림차순
        List<Integer> desc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(desc); //[5, 4, 3, 2, 1]



    }//end of main
}//end of class
