
import java.util.Scanner;


public class Source {

    public static Scanner skaner = new Scanner(System.in);



    public static void main(String[] args) {


        char[] operatory = {'(',')','!','`','^','*','/','%','+','-','<','>','?','&','|','=' } ;
        char[] lacznosc_operatorow = {'l', 'l', 'p', 'p','p','l','l','l','l','l','l','l','l','l','l','p',} ;
        char[] priorytet_operatorow = {'9','9','8','8','7','6','6','6','5','5','4','4' , '3' , '2' , '1' , '0' };



        System.out.println("Hello world!");
        String wejscie = "";
        String wyjscie = "";
        int ile_testow = skaner.nextInt();;
        skaner.nextInt();
        skaner.next();
        int i = 0;
        int j = 0;
        int k = 0;

        boolean czy_input_to_operator =  false ;

        char[] stos = new char[1000] ;
        int dlg_stosu = 0;

        while ( i < ile_testow)
        {
            wejscie = skaner.next();
            wyjscie = "";
            j = 5;

            if ( wejscie.charAt(0) == 'I'  )
            {

                wyjscie += "ONP: ";

                while ( j < wejscie.length() ) {

                    k = 0;
                    czy_input_to_operator = false;
                    while ((k < 16) && (czy_input_to_operator == false)) {
                        if (operatory[k] == wejscie.charAt(j)) {
                            czy_input_to_operator = true;
                        }
                        k++;
                    }


                    if (czy_input_to_operator == false )
                    {
                        wyjscie += wejscie.charAt(j);

                    } else if ( wejscie.charAt(j) == '(' )
                    {
                        stos[dlg_stosu] = '(' ;
                    } else if ( wejscie.charAt(j) == ')' )
                    {
                        while ( stos[dlg_stosu-1] != '(' )
                        {
                            wyjscie+= stos[dlg_stosu-1];
                            stos[dlg_stosu-1] = '_';
                            dlg_stosu -= 1 ;
                        }
                        stos[dlg_stosu-1] = '_' ;
                    } else if ( czy_input_to_operator == true )
                    {
//                        while ( true )
//                        {
//
//                        }


                    }







                    j++;

                }

            } else if ( wejscie.charAt(0) == 'O' ) {
                while (j < wejscie.length()) {

                    j++;
                }
            }

            i++;
        }


    }

}