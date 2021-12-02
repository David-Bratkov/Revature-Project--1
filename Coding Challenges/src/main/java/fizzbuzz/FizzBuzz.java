package fizzbuzz;

public class FizzBuzz {

    public static String fizzBuzz(int input) {

        if (input < 1) return null;
        StringBuilder retstring = new StringBuilder();
        Boolean flag = false;

        for(int x = 1; x < input+1; x++) {

            flag = false;

            if ((x % 3) == 0 ) {
                retstring.append("Fizz");
                flag = true;
            }

            if ((x % 5) == 0 ) {
                retstring.append("Buzz");
                flag = true;
            }

            if (!flag) retstring.append(x + ", ");
            if (flag) retstring.append(", ");

        }

        return retstring.toString().substring(0,(retstring.length()-2));

    }

}
