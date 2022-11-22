
import java.util.Scanner;


public class Source {

    public static Scanner skaner = new Scanner(System.in);

    char[] operatory = {'(',')','!','`','^','*','/','%','+','-','<','>','?','&','|','=' } ;
    char[] lacznosc_operatorow = {'l', 'l', 'p', 'p','p','l','l','l','l','l','l','l','l','l','l','p',} ;
    char[] priorytet_operatorow = {'9','9','8','8','7','6','6','6','5','5','4','4' , '3' , '2' , '1' , '0' };

    public static void main(String[] args) {

        System.out.println("Hello world!");
        String wejscie = "";
        String wyjscie = "";
        int ile_testow = skaner.nextInt();;
        skaner.nextInt();
        skaner.next();
        int i = 0;
        int j = 0;

        while ( i < ile_testow)
        {
            wejscie = skaner.next();
            wyjscie = "";
            j = 5;

            if ( wejscie.charAt(0) == 'O'  )
            {

                while ( j < wejscie.length() )
                {

                    j++;
                }



            } else if ( wejscie.charAt(0) == 'I' ) {
                while (j < wejscie.length()) {

                    j++;
                }
            }

            i++;
        }


    }

}