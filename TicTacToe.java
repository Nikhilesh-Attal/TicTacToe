import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Random;

class TicTacToe{

    static Scanner s =new Scanner(System.in);
    static HashSet<Integer> you = new HashSet<Integer>();           //adding position in game so that no postion is repeated by using hashset like in hash table
    static HashSet<Integer> oop = new HashSet<Integer>(); 
    static Random ran = new Random();

    public static void main(String args[]){
        String res= null;
        int pos1,pos2;

        String[][] board={{"  "," | ","  "," | ","  "},
                          {"--"," | ","--"," | ","--"},
                          {"  "," | ","  "," | ","  "},
                          {"--"," | ","--"," | ","--"},
                          {"  "," | ","  "," | ","  "},
                        };
                        
        print_board(board);      //calling a function to println dashboard of the game
        
        while(true){
            System.out.println("Enter values between 1 to 9");
            pos1 = s.nextInt();
           
            while(oop.contains(pos1) || you.contains(pos1) ){
                System.out.println("Please enter vaild number between 0 to 9");
                pos1=s.nextInt();
            }
            play_game(board,pos1,"You");

            System.out.print("\n\n");

            res = check_winner();
            if(res.length()>0){
                System.out.println(res);
                break;
            }

            pos2 = ran.nextInt(10);
            while(oop.contains(pos2) || you.contains(pos2)){
                pos2 = ran.nextInt(10);
            }
            play_game(board,pos2,"Computer");

            res = check_winner();
            if(res.length()>0){
                System.out.println(res);
                break;
            }
        }
    }

    static void print_board(String[][] board){
        int i,j;
        for(i=0; i<board.length; i++){
            for(j=0; j<board.length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void play_game(String[][] board, int position, String user){
        String sym = "X";
        int pos;
        pos = position;
        
        if(user.equals("You")){
            sym = "X";
            you.add(pos);           //adding position in game so that no postion is repeated
        }
        else if(user.equals("Computer")){
            sym = "0";
            oop.add(pos);           //adding position in game so that no postion is repeated
        }
        
        switch(pos){
            case 1:
                board[0][0] = " " + sym;
                break;
            case 2:
                board[0][2] = " " + sym;
                break;
            case 3:
                board[0][4] = " " + sym;
                break;
            case 4:
                board[2][0] = " " + sym;
                break;
            case 5:
                board[2][2] = " " + sym;
                break;
            case 6:
                board[2][4] = " " + sym;
                break;
            case 7:
                board[4][0] = " " + sym;
                break;
            case 8:
                board[4][2] = " " + sym;
                break;
            case 9:
                board[4][4] = " " + sym;
                break;
            default:
                System.out.println("Please enter a valid input");
        }
        print_board(board);
    }

    static String check_winner(){
        
        HashSet<Integer> r1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> r2 = new HashSet<>(Arrays.asList(4, 5, 6));
        HashSet<Integer> r3 = new HashSet<>(Arrays.asList(7, 8, 9));
        HashSet<Integer> c1 = new HashSet<>(Arrays.asList(1, 4, 7));
        HashSet<Integer> c2 = new HashSet<>(Arrays.asList(2, 5, 8));
        HashSet<Integer> c3 = new HashSet<>(Arrays.asList(3, 6, 9));
        HashSet<Integer> d1 = new HashSet<>(Arrays.asList(1, 5, 9));
        HashSet<Integer> d2 = new HashSet<>(Arrays.asList(3, 5, 7));
        
        HashSet<HashSet> set = new HashSet<HashSet>();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(c1);set.add(c2);set.add(c3);
        set.add(d1);set.add(d2);

        for(HashSet h:set){
            if(you.containsAll(h)){
                System.out.println("Hurray! You won the match");
                System.exit(0);
            }
            else if(oop.containsAll(h)){
                System.out.println("Better luck next time");
                System.exit(0);
            }
        }
        if(you.size()+oop.size()==9){
            System.out.println("Draw");
            System.exit(0);
        }
            return "";
    }
}