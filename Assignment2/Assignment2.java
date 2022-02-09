import java.util.ArrayList; 
import java.util.*;

class Main {
  static Scanner scan = new Scanner(System.in);


  public static void main(String[] args) {
    Encryption encryption = new Encryption();
    boolean quit = false;
    while(!quit){
      System.out.println("1 Encrypt a message\n2 Decrypt a message\n3 Quit\n\nEnter Choice:");
      int choice = scan.nextInt();
      switch(choice){
        case 1:
          System.out.println("Enter the plain text message:");
          System.out.println("\nEncrypted Msg: " + encryption.encrypt_message(scan.next()) + "\n");
          break;
        case 2:
          System.out.println("Enter the encrypted text message:");
          System.out.println("\nDecrypted Msg: " + encryption.decrypt_message(scan.next()) + "\n");
          break;
        case 3:
          quit = true;
          break;
        default:
          System.out.println("Error: please enter vaild input");
          break;
      }
    }
  }
}


class Encryption
{
  ArrayList<Character> symbols = new ArrayList<Character>();
  
  ArrayList<Character> alphabets = new ArrayList<Character>();

  public Encryption(){
    symbols.add('!');
    symbols.add('@');
    symbols.add('#');
    symbols.add('$');
    symbols.add('^');
    symbols.add('&');
    symbols.add('*');
    symbols.add('(');
    symbols.add(')');
    symbols.add('_');
    symbols.add('-');
    symbols.add('+');
    symbols.add('=');
    symbols.add('?');
    symbols.add(',');
    symbols.add('{');
    symbols.add('}');
    symbols.add('[');
    symbols.add(']');
    symbols.add('/');
    symbols.add('|');
    symbols.add(';');
    symbols.add(':');
    symbols.add('.');
    symbols.add('<');
    symbols.add('>');

    for(char letter='a';letter<='z';letter++){
      alphabets.add(letter);
    }
  }

  public Character return_alphabet(int num){
    return alphabets.get(num);
  }

  public int return_alphabet_index(char cha){
    for (int i = 0; i < alphabets.size(); i++){
      if(alphabets.get(i) == cha)
       return i;
    }
    return 0;
  }

  public Character return_symbol(int num){
    return symbols.get(num);
  }

  public int return_symbol_index(char cha){
    for (int i = 0; i < symbols.size(); i++){
      if(symbols.get(i) == cha)
       return i;
    }
    return 0;
  }

  public String encrypt_message(String str){
    String newStr = "";
    str = str.toLowerCase();
    for (int i = 0; i < str.length(); i++) {
      char character = str.charAt(i);
      newStr += return_symbol(return_alphabet_index(character));
    }
    return newStr;
  }

  public String decrypt_message(String str){
    String newStr = "";
    str = str.toLowerCase();
    for (int i = 0; i < str.length(); i++) {
      char character = str.charAt(i);
      newStr += return_alphabet(return_symbol_index(character));
    }
    return newStr;  }
}