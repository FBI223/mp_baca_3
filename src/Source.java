
import java.util.Scanner;


public class Source {

    public static Scanner skaner = new Scanner(System.in);
    public static Scanner skaner_2 = new Scanner(System.in);



    public static void main(String[] args) {


        char[] operatory = {'(',')','!','~','^','*','/','%','+','-','<','>','?','&','|','=' } ;
        char[] lacznosc_operatorow = {'l', 'l', 'p', 'p','p','l','l','l','l','l','l','l','l','l','l','p',} ;
        char[] priorytet_operatorow = {'9','9','8','8','7','6','6','6','5','5','4','4' , '3' , '2' , '1' , '0' };

        char[][] operatory_data = { {'(','l','9'} , {')','l','9'} ,{'!','p','8'} ,{'~','p','8'} ,{'^','p','7'} ,{'*','l','6'} ,{'/','l','6'} ,{'%','l','6'} ,{'+','l','5'} ,{'-','l','5'} ,{'<','l','4'} ,{'>','l','4'} ,{'?','l','3'} ,{'&','l','2'} ,{'|','l','1'} ,{'=','p','0'}   } ;

//
//        int temp_int = 0;
//        temp_int = skaner.nextInt();
//        System.out.println(temp_int);
//
//
//        String tmep_string = "";
//        tmep_string = skaner_2.nextLine();
//        System.out.println(tmep_string);
//        System.out.println(tmep_string.length());


        System.out.println("Hello world!");
        System.out.println("Podaj ilosc zestawow : ");
        String wejscie = "";
        String wyjscie = "";

        int ile_testow = skaner_2.nextInt();;
        int i = 0;
        int j = 0;
        int k = 0;
        int kk = 0;

        String temp_stringi = "";

        char temp_priorytet_token = '_';
        char temp_lacznosc_token = '_' ;

        char temp_priorytet_stos_token = '_';
        char temp_lacznosc_stos_token = '_' ;

        boolean czy_wejscie_token_mniejszy_ma_priorytet_od_stosu = false ;

        boolean czy_input_to_operator =  false ;

        char[] stos = new char[50] ;
        int dlg_stosu = 0;





        System.out.println(" flaga 0");

        while ( i < ile_testow)
        {

            System.out.println(" flaga 1") ;

            wejscie = "";
            wejscie += skaner.nextLine() ;
            wyjscie = "";
            j = 5;
            System.out.println(wejscie.length());

            if ( wejscie.charAt(0) == 'I'  )
            {


                wyjscie += "ONP: ";
                j=5;

                while ( j < wejscie.length() )
                {

                    k = 0;
                    czy_input_to_operator = false;
                    while ((k < 16) && (czy_input_to_operator == false)) {
                        if (operatory[k] == wejscie.charAt(j)) {
                            czy_input_to_operator = true;
                        }
                        k++;
                    }

                    System.out.println("to jest wejscie ");
                    System.out.println(wejscie);
                    System.out.println("czy to operator");
                    System.out.println(czy_input_to_operator);
                    System.out.println(wejscie.charAt(j));

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

                        if ( dlg_stosu != 0 )
                        {

                            czy_wejscie_token_mniejszy_ma_priorytet_od_stosu = true;

                            k = 0;
                            while (wejscie.charAt(j) != operatory_data[k][0]) {
                                k++;
                            }
                            temp_priorytet_token = operatory_data[k][1];
                            temp_lacznosc_token = operatory_data[k][2];

                            k = 0;

                            while (stos[dlg_stosu - 1] != operatory_data[k][0]) {
                                k++;
                            }
                            temp_priorytet_stos_token = operatory_data[k][1];
                            temp_lacznosc_stos_token = operatory_data[k][2];
                            k = 0;

                            if (temp_priorytet_token < temp_priorytet_stos_token) {
                                czy_wejscie_token_mniejszy_ma_priorytet_od_stosu = true;
                            } else {
                                czy_wejscie_token_mniejszy_ma_priorytet_od_stosu = false;
                            }

                            while (czy_wejscie_token_mniejszy_ma_priorytet_od_stosu == true) {
                                wyjscie += stos[dlg_stosu - 1];
                                stos[dlg_stosu - 1] = '_';
                                dlg_stosu -= 1;
                                czy_wejscie_token_mniejszy_ma_priorytet_od_stosu = false ;
                                System.out.println("usuwanie brudow ze stosu ");
                            }

                            stos[dlg_stosu] = wejscie.charAt(j);
                        }


                        k=0;
                        while ( k < stos.length )
                        {
                            temp_stringi += stos[k] ;
                            k++;
                        }
                        System.out.println("STOS : " +  temp_stringi + "     dlg stosu : " + dlg_stosu);
                        temp_stringi = "";


                        stos[dlg_stosu] = wejscie.charAt(j);
                        dlg_stosu+=1;


                    }






                    System.out.println(j);
                    j++;

                }

            } else if ( wejscie.charAt(0) == 'O' ) {
                while (j < wejscie.length()) {

                    j++;
                }
            }


            System.out.println(wyjscie);
            System.out.println();
            i++;
        }


    }

}