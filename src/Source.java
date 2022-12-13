
import java.util.Scanner;

public class Source {
    public static Scanner skaner = new Scanner(System.in);

    static public char[][] operatory_data = {   {'*','l','6'} ,{'/','l','6'} ,{'%','l','6'} ,{'+','l','5'} ,{'-','l','5'} ,{'<','l','4'} ,{'>','l','4'} ,{'?','l','3'} ,{'&','l','2'} ,{'|','l','1'}    } ;
    static public char[][] operatory_data_2 = {  {'!','p','8'} ,{'~','p','8'}  ,{'^','p','7'} ,{'*','l','6'} ,{'/','l','6'} ,{'%','l','6'} ,{'+','l','5'} ,{'-','l','5'} ,{'<','l','4'} ,{'>','l','4'} ,{'?','l','3'} ,{'&','l','2'} ,{'|','l','1'} ,{'=','p','0'}   } ;



    public static char jaki_priorytet_opa(char x)
    {

        char priorytet_x = 0;

        for ( int i = 0 ; i < operatory_data.length ; i++ )
        {
            if ( operatory_data[i][0] == x )
            {
                priorytet_x = operatory_data[i][2];
            }
        }

        return priorytet_x ;

    }

    public static char jaki_priorytet_opa_2(char x)
    {

        int char_int_value = x ;
        char priorytet_x = 'X' ;

        if ( (char_int_value >= 97) && ( char_int_value <= 122 ) )
        {
            priorytet_x = '9';
        }

        if ( priorytet_x != '9' ) {
            for (int i = 0; i < operatory_data_2.length; i++) {
                if (operatory_data_2[i][0] == x) {
                    priorytet_x = operatory_data_2[i][2];
                }
            }
        }


        return priorytet_x ;

    }

    public static boolean czy_to_operator( char in_char )
    {
        boolean czy_op = false ;
        int i = 0;
        while ( i < 10 )
        {
            if ( in_char == operatory_data[i][0] )
            {
                czy_op = true;
            }
            i++;
        }

        return czy_op ;
    }

    public static class Stos
    {
        char[] stoss = new char[50];

        int dlg_stossu = 0;


        Stos()
        {
            stoss[0] = '_';
        }

        char pop()
        {
            char temp = '_';
            if ( dlg_stossu > 0  )
            {
                temp = stoss[dlg_stossu-1];
                stoss[dlg_stossu-1] = '_';
                dlg_stossu--;
            }
            return temp;
        }

        void insert(char x)
        {
            if ( dlg_stossu < 50 )
            {
                stoss[dlg_stossu] = x;
                dlg_stossu++;
            }
        }

        int len()
        {
            return dlg_stossu;
        }

        char top_return()
        {
            if ( dlg_stossu > 0 )
            {
                return stoss[dlg_stossu-1];
            } else
            {
                return '_';
            }


        }

        void top_delete()
        {
            if ( dlg_stossu > 0 )
            {
                stoss[dlg_stossu-1] = '_';
                dlg_stossu--;
            }
        }

        boolean is_empty()
        {

            if ( dlg_stossu == 0 )
            {
                return true ;
            } else
            {
                return false ;
            }

        }
        void show_stack()
        {
            String wy = "" ;
            for ( int j = 0 ; j < dlg_stossu ; j++ )
            {
                wy += stoss[j];
                wy +=", ";
            }

            System.out.println(wy);
        }

        void clear_stack()
        {
            for (int i = 0 ; i < dlg_stossu ; i++)
            {
                stoss[i] = '_';
            }
        }

    }



    public static int automat_spr_inf( int stan_poprzedni, char wejscie_token )
    {
        int stan_nastepny=0;

        char priorytet_tokenu = jaki_priorytet_opa_2(wejscie_token);


        if ( stan_poprzedni == 0 )
        {

            if ( wejscie_token == '(' )
            {
                stan_nastepny = 0;
            } else if ( priorytet_tokenu == '8' )
            {
                stan_nastepny = 2;
            } else if ( jaki_priorytet_opa_2(wejscie_token) == '9' )
            {
                stan_nastepny = 1 ;
            } else if ( wejscie_token == ')' )
            {
                stan_nastepny = 4;

            }else if ( (jaki_priorytet_opa_2(wejscie_token) >= '0' ) &&  (jaki_priorytet_opa_2(wejscie_token) <= '7' ) )
            {
                stan_nastepny = 4;


            }


        } else if ( stan_poprzedni == 1 )
        {

            if ( wejscie_token == '(' )
            {
                stan_nastepny = 4;
            } else if ( priorytet_tokenu == '8' )
            {
                stan_nastepny = 4;
            } else if ( jaki_priorytet_opa_2(wejscie_token) == '9' )
            {
                stan_nastepny = 4 ;
            } else if ( wejscie_token == ')' )
            {
                stan_nastepny = 1;

            }else if ( (jaki_priorytet_opa_2(wejscie_token) >= '0' ) &&  (jaki_priorytet_opa_2(wejscie_token) <= '7' ) )
            {
                stan_nastepny = 0 ;

            }

        } else if ( stan_poprzedni == 2 )
        {

            if ( wejscie_token == '(' )
            {
                stan_nastepny = 0;
            } else if ( priorytet_tokenu == '8' )
            {
                stan_nastepny = 2;
            } else if ( jaki_priorytet_opa_2(wejscie_token) == '9' )
            {
                stan_nastepny = 1 ;
            } else if ( wejscie_token == ')' )
            {
                stan_nastepny = 4;

            }else if ( (jaki_priorytet_opa_2(wejscie_token) >= '0' ) &&  (jaki_priorytet_opa_2(wejscie_token) <= '7' ) )
            {
                stan_nastepny = 4;

            }

        }


        return stan_nastepny ;
    }


    public static void main(String[] args) {


        String wejscie = "";
        String wyjscie = "";
        String ile_testow_STR = "";

        ile_testow_STR = skaner.nextLine() ;
        int ile_testow = 0;
        ile_testow = Integer.parseInt(ile_testow_STR) ;

        boolean czy_poprawne = true;
        int ile_operandow = 0;
        int ile_operatorow = 0;
        int stan = 0;


        int i = 0;
        int j = 0;
        int kk = 0;


        String temp_1 = "";
        String temp_2 = "";
        String temp_3 = "";

        int dlg_temp_string_1 = 0;


        char temp_priorytet_wejscia = '_';
        int gdzie_split_string_1 = 0;
        int gdzie_split_string_2 = 0;

        int ascii_int = 0;

        boolean czy_token_to_op = false;
        Stos Stoss = new Stos();
        Stos Stoss_priorytetow = new Stos();
        int dlg_wyjscia = 0;


        while ( i < ile_testow)
        {

            czy_poprawne = true ;
            ile_operandow = 0;
            ile_operatorow = 0;

            dlg_wyjscia = 5;
            wejscie = "";
            wejscie += skaner.nextLine() ;
            wyjscie = "";
            j = 5;

            if (  wejscie.charAt(0) == 'I' )
            {
                wyjscie +="ONP: ";
                while ( (j < wejscie.length()) && (czy_poprawne == true ))
                {
                    czy_token_to_op = czy_to_operator(wejscie.charAt(j)) ;
                    ascii_int = wejscie.charAt(j);



                    if ( ( ( ascii_int >=97 ) && (ascii_int <= 122) ) || ( czy_to_operator(wejscie.charAt(j)) == true ) || ( ( wejscie.charAt(j) == '~' ) || ( wejscie.charAt(j) == '=' ) || ( wejscie.charAt(j) == '^' ) || ( wejscie.charAt(j) == '(' ) || ( wejscie.charAt(j) == ')' ) || ( wejscie.charAt(j) == '!' ) ) )
                    {

                        stan = automat_spr_inf(stan, wejscie.charAt(j)) ;
                        if ( stan == 4 )
                        {
                            czy_poprawne = false ;
                            wyjscie = "ONP: error" ;
                        }

                        if ( ( (czy_token_to_op == true ) ||  ( wejscie.charAt(j) == '(' )  ||  ( wejscie.charAt(j) ==  ')' )  || ( wejscie.charAt(j) == '=' ) || ( wejscie.charAt(j) == '^' ) ) && (czy_poprawne == true) )
                        {


                            if ( wejscie.charAt(j) == '(' )
                            {
                                Stoss.insert('(');
                            } else if ( wejscie.charAt(j) ==  ')' )
                            {
                                while ( Stoss.top_return() != '(' )
                                {
                                    wyjscie += Stoss.pop();

                                }
                                Stoss.top_delete();

                            } else
                            {

                                if ( Stoss.is_empty() == false )
                                {

                                    if ( (wejscie.charAt(j) != '=') && ( wejscie.charAt(j) != '^' ) )
                                    {
                                        while ( (jaki_priorytet_opa_2(Stoss.top_return()) >= jaki_priorytet_opa_2(wejscie.charAt(j)) ) && (jaki_priorytet_opa_2(Stoss.top_return()) != 'X' ))
                                        {

                                            wyjscie += Stoss.pop();

                                        }
                                    } else if ( (wejscie.charAt(j) == '=') || ( wejscie.charAt(j) == '^' ))
                                    {
                                        while ( (jaki_priorytet_opa_2(Stoss.top_return()) > jaki_priorytet_opa_2(wejscie.charAt(j)) ) && (jaki_priorytet_opa_2(Stoss.top_return()) != 'X' ))
                                        {
                                            wyjscie += Stoss.pop();

                                        }

                                    }


                                }
                                Stoss.insert( wejscie.charAt(j) );
                            }



                        } else if ( ( ( wejscie.charAt(j) == '~' ) || ( wejscie.charAt(j) == '!' ) ) && (czy_poprawne == true ) )
                        {

                            if ( wejscie.charAt(j) == '~' )
                            {
                                Stoss.insert('~');
                            } else if ( wejscie.charAt(j) == '!' )
                            {
                                Stoss.insert('!');
                            }


                        }
                        else if ( czy_poprawne == true  )
                        {
                            if ( ( wejscie.charAt(j) != '(' ) && ( wejscie.charAt(j) != ')'  )  )
                            {
                                wyjscie += wejscie.charAt(j);
                                dlg_wyjscia++;
                            }

                            while ( Stoss.top_return() == '~' )
                            {
                                wyjscie += Stoss.pop();
                                dlg_wyjscia++;
                            }

                        }

                    }
                    j++;


                }

                if ( czy_poprawne == true  )
                {
                    while (Stoss.is_empty() == false )
                    {
                        if ( Stoss.top_return() != '_' )
                        {
                            wyjscie += Stoss.pop();
                        } else
                        {
                            Stoss.pop();
                        }

                    }
                }


            } else if ( wejscie.charAt(0) == 'O' )
            {

                temp_1 = "ONP: ";
                kk = 5;
                while ( kk < wejscie.length() )
                {
                    ascii_int = jaki_priorytet_opa_2(wejscie.charAt(kk))  ;

                    if ( ( ascii_int >= 48 ) && ( ascii_int <= 57  ) )
                    {
                        temp_1 += wejscie.charAt(kk);


                        if ( ascii_int == 57 )
                        {
                            ile_operandow += 1;
                        } else if ( ascii_int <= 55 )
                        {
                            ile_operatorow +=1;
                        }

                    }
                    kk++;
                }

                wejscie = temp_1;
                temp_1 = "";
                wyjscie = "INF: ";

                if ( (ile_operandow-1 ) != (ile_operatorow) )
                {
                    czy_poprawne = false;
                    wyjscie = "INF: error";
                }



                j = 5;
                dlg_wyjscia = 5 ;
                while ( (j < wejscie.length() ) && ( czy_poprawne == true  ) )
                {
                    temp_priorytet_wejscia = jaki_priorytet_opa_2(wejscie.charAt(j)) ;

                    if ( temp_priorytet_wejscia != 'X' )
                    {
                        if ( temp_priorytet_wejscia != '9' )
                        {
                            if ( wejscie.charAt(j) == '~' || wejscie.charAt(j) == '!'  )
                            {
                                gdzie_split_string_1 = dlg_wyjscia - 1 ;
                                dlg_temp_string_1 = 0;
                                kk = dlg_wyjscia - 1 ;
                                temp_1 = "" ;

                                while ( (wyjscie.charAt(kk) != ' ') && (wyjscie.charAt(kk) != ',' )  )
                                {
                                    temp_1 += wyjscie.charAt(kk);
                                    dlg_temp_string_1 += 1;
                                    gdzie_split_string_1 -= 1 ;
                                    kk--;

                                }
                                temp_2 = "";
                                kk=dlg_temp_string_1-1  ;
                                while ( kk > -1  )
                                {
                                    temp_2 += temp_1.charAt(kk);
                                    kk--;
                                }

                                temp_1 = "";
                                kk=0;

                                while ( kk <= gdzie_split_string_1  )
                                {
                                    temp_1 += wyjscie.charAt(kk);
                                    kk++;
                                }
                                if ( temp_priorytet_wejscia > Stoss_priorytetow.top_return() )
                                {
                                    temp_2 = '(' + temp_2 + ')' ;
                                    dlg_wyjscia += 2 ;
                                }

                                Stoss_priorytetow.pop() ;
                                wyjscie = temp_1 + wejscie.charAt(j) + temp_2 ;
                                Stoss_priorytetow.insert( temp_priorytet_wejscia );
                                dlg_wyjscia += 1;

                            } else
                            {

                                gdzie_split_string_1 = dlg_wyjscia - 1 ;

                                dlg_temp_string_1 = 0;
                                kk = dlg_wyjscia - 1 ;
                                temp_1 = "" ;
                                while (  wyjscie.charAt(kk) != ','   )
                                {
                                    temp_1 += wyjscie.charAt(kk);
                                    dlg_temp_string_1 += 1;
                                    gdzie_split_string_1 -= 1 ;
                                    kk--;
                                }

                                temp_3 = "";
                                temp_2 = "";

                                kk=temp_1.length() - 1 ;
                                while ( kk > -1   )
                                {
                                    temp_3 += temp_1.charAt(kk);
                                    kk--;
                                }
                                temp_1 = "";
                                gdzie_split_string_1 -= 1 ;


                                temp_2 = "";
                                kk= gdzie_split_string_1 ;
                                gdzie_split_string_2 = gdzie_split_string_1 ;

                                while ( wyjscie.charAt(kk) != ' ' && wyjscie.charAt(kk) != ',' ) {

                                    gdzie_split_string_2 -= 1;
                                    temp_1 += wyjscie.charAt(kk);
                                    kk--;
                                }

                                kk = temp_1.length() - 1;
                                while ( kk > -1   )
                                {
                                    temp_2 += temp_1.charAt(kk);
                                    kk--;
                                }

                                temp_1 = "";
                                kk=0;
                                while ( kk <= gdzie_split_string_2 )
                                {
                                    temp_1 += wyjscie.charAt(kk);
                                    kk++;

                                }
                                if ( (wejscie.charAt(j) != '=') &&  ( wejscie.charAt(j) != '^' ) )
                                {
                                    if (  temp_priorytet_wejscia  >= Stoss_priorytetow.top_return()  )
                                    {
                                        temp_3 = '(' + temp_3 + ')' ;
                                        dlg_wyjscia += 2 ;
                                    }
                                    Stoss_priorytetow.pop() ;
                                    if ( temp_priorytet_wejscia > Stoss_priorytetow.top_return() )
                                    {
                                        temp_2 = '(' + temp_2 + ')' ;
                                        dlg_wyjscia += 2 ;
                                    }
                                    Stoss_priorytetow.pop() ;
                                } else
                                {
                                    if (  temp_priorytet_wejscia  > Stoss_priorytetow.top_return()  )
                                    {
                                        temp_3 = '(' + temp_3 + ')' ;
                                        dlg_wyjscia += 2 ;
                                    }
                                    Stoss_priorytetow.pop() ;
                                    if ( temp_priorytet_wejscia >= Stoss_priorytetow.top_return() )
                                    {
                                        temp_2 = '(' + temp_2 + ')' ;
                                        dlg_wyjscia += 2 ;
                                    }
                                    Stoss_priorytetow.pop() ;
                                }
                                ;
                                wyjscie = temp_1 + temp_2 + wejscie.charAt(j) + temp_3 ;
                                Stoss_priorytetow.insert( temp_priorytet_wejscia );
                            }
                        } else
                        {
                            if ( dlg_wyjscia > 5  )
                            {
                                wyjscie += ',' ;
                                wyjscie += wejscie.charAt(j);
                                dlg_wyjscia += 2 ;
                                Stoss_priorytetow.insert(temp_priorytet_wejscia);

                            } else
                            {
                                wyjscie += wejscie.charAt(j);
                                dlg_wyjscia += 1 ;
                                Stoss_priorytetow.insert(temp_priorytet_wejscia);
                            }
                        }
                    } else
                    {
                        wyjscie += wejscie.charAt(j);
                        wyjscie+= ',';
                        dlg_wyjscia += 2;
                        Stoss_priorytetow.insert( temp_priorytet_wejscia );
                    }
                    j++;
                }
            }

            System.out.println(wyjscie);

            Stoss.clear_stack();
            Stoss_priorytetow.clear_stack();
            i++;
        }
    }

}


