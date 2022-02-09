import java.util.ArrayList; // import the ArrayList class
import java.util.*;

class Quiz {
  static ArrayList<Question> questions = new ArrayList<Question>();
  static Scanner scan = new Scanner(System.in);


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean quit = false;
    while(!quit){
      System.out.println("What would you like to do?\n1. Add a question to the quiz\n2. Remove a question from the quiz\n3. Modify a question in the quiz\n4. Take the quiz\n5. Quit");
      int response = scan.nextInt();
      switch(response){
        case 1:
          add_question();
          break;
        case 2:
          remove_question();
          break;
        case 3:
          modify_question();
          break;
        case 4: 
          give_quiz();
          break;
        case 5:
          quit = true;
          break;
      }
    }
  }

  public static void add_question(){
    System.out.println("What is the question Text?");
    String tempQuestion = scan.next(); 
    System.out.println("What is the answer?");
    String tempAnswer = scan.next(); 
    System.out.println("How Difficult (1-3)?");
    int tempDifficulty = scan.nextInt();     
    questions.add(new Question(tempQuestion,tempAnswer,tempDifficulty));
  }

  public static void remove_question(){
    System.out.println("Chosse the question to remove?");
    for (int i =0; i <questions.size();i++){
      System.out.println(i + ". " + questions.get(i).getQuestion());
    }
    int tempQuestion = scan.nextInt(); 
    questions.remove(tempQuestion);
  }

  public static void modify_question(){
    System.out.println("Chosse the question to substitute?");
    for (int i =0; i <questions.size();i++){
      System.out.println(i + ". " + questions.get(i).getQuestion());
    }
    int tempQuestionNum = scan.nextInt(); 
    
    System.out.println("What is the question Text?");
    String tempQuestion = scan.next(); 
    System.out.println("What is the answer?");
    String tempAnswer = scan.next(); 
    System.out.println("How Difficult (1-3)?");
    int tempDifficulty = scan.nextInt();     
    questions.remove(tempQuestionNum);
    questions.add(tempQuestionNum, new Question(tempQuestion,tempAnswer,tempDifficulty));  }

  public static void give_quiz(){
    int score = 0;
    for (int i =0; i <questions.size();i++){
      System.out.println(questions.get(i).getQuestion());
      String tempAnswer = scan.nextLine(); 
      if(tempAnswer.equals(questions.get(i).getAnswer())){
        System.out.println("Correct");
        score++;
      }
      else{
        System.out.println("Incorrect");
      }
    }
    System.out.println("You got " + score + " out of " + questions.size());
  }
}

class Question{
  private String question;
  private String answer;
  private int difficutly;


  public Question(String q, String a, int d){
    question = q;
    answer = a;
    difficutly = d;
  }

  public void setQuestion(String q){
    question = q;
  }

  public void setAnswer(String a){
    answer = a;
  }

  public void setDifficulty(int d){
    difficutly = d;
  }

  public String getQuestion(){
    return question;
  }

  public String getAnswer(){
    return answer;
  }

  public int getDifficulty(){
    return difficutly;
  }
}