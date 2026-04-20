import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class CThree {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Map<String,String> Question = new HashMap<>();
        Question.put("Q1","Feeling feverish and/or having chills?");
        Question.put("Q2","Has there been any use of fever reducing medication within the last 24 hours not due to another health condition?");
        Question.put("Q3","A new cough that is not due to another health condition?");
        Question.put("Q4","New chills that are not due to another health condition?");
        Question.put("Q5","A new sore throat that is not due to another health condition?");
        Question.put("Q6","A new loss of taste or smell?");
        Question.put("Q7","Have you had a positive test for the virus that causes COVID-19 disease within the past 10 days?");
        Question.put("Q8","In the past 14 days, have you had close contact (within about 6 feet for 15 minutes or more) with someone with suspected or confirmed COVID-19?");
        Map<String,String> Answer = new HashMap<>();
        for(String key : Question.keySet()){
            System.out.print(key + " " + Question.get(key) + " : ");
            String Ans = sc.nextLine();
            Answer.put(key,Ans);
        }
        sc.close();
        System.out.println("=================================================");
        System.out.printf("| %-19s   |   %-19s |", "Question" , "Answers");
        System.out.println("\n=================================================");
        for(Map.Entry<String,String> Map : Answer.entrySet()){
            System.out.printf("| %-19s   |   %-19s |" , Map.getKey() , Map.getValue());
            System.out.println("");
            System.out.println("-------------------------------------------------");
        }

    }
}
