import java.util.Scanner;
//
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 1;
        while (number!=0) {
                System.out.println("Введите количество раз для выполнения методов коллекции");
                int count = scanner.nextInt();
                Test test = new Test(count);
                System.out.println(test.getResult());
            }
        }
    }

