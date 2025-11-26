package Nov;

import java.util.Scanner;

public class 달팽이는올라가고싶다 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double A = sc.nextInt();
        double B = sc.nextInt();
        double V = sc.nextInt();

        V = V - A;

        double value = A - B;
        int result;

        if (V <= 0) {
            System.out.println(1);
        } else {

            if (V % 2 == 0 || value == 1) {
                result = (int) (V / value);
//                System.out.println("result1: "+result);

                double lValue = V / value;
//                System.out.println("lValue1: "+lValue);

//                System.out.println("lValue-result: "+(lValue - result));

                if (lValue - result > 0) {
                    result++;
                }

            } else {
                result = (int) ((V + 1) / value);
//                System.out.println("result2: "+result);

                double lValue = V / value;
//                System.out.println("lValue2: "+lValue);

//                System.out.println("lValue-result: "+(lValue - result));

                if (lValue - result > 0) {
                    result++;
                }
            }

            if (result < 1) {
                result = 1;
            }


            System.out.println(result + 1);
        }


    }

}
