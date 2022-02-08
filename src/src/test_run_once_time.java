import java.util.Scanner;
public class test_run_once_time {
    public static int sum(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        while (true) {


            System.out.println("Hello World!");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.format("You typed: %s", s);


            Scanner sc2 = new Scanner(System.in);
            int in1 = sc2.nextInt();
            int in2 = sc2.nextInt();
            // sum(1,2);
            System.out.println(sum(in1, in2));


        }
    }
}
