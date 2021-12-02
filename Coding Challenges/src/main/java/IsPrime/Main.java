package IsPrime;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPrime(2887));
        System.out.println(isPrime(3723));
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
        System.out.println(isPrime(6));
        System.out.println(isPrime(9));
        System.out.println(isPrime(2));
        System.out.println(isPrime(169));


    }

    static boolean isPrime(int number){

        for (int x = number/2; x != 1; x-- ){

            if (number%x == 0) return false;

        }

        return true;

    }

}
