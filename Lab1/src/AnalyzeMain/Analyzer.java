package AnalyzeMain;

import java.util.ArrayList;

public class Analyzer {

    public static double[] analyze(ArrayList<Double> arr){

        double[] res = new double[2];
        double sum = 0;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            sum += arr.get(i);
        }
        double m = sum/size;  // mat expect
        double sumd = 0;
        for (int i = 0; i < size; i++) {
            sumd +=(arr.get(i) - m)*(arr.get(i) - m);
        }

        double d = sumd/(size-1);

        double l = m/d;
        double k = m*l;
        res[0] = l;
        res[1] = k;

        return res;
    }

    public static double calcAC(ArrayList<Double> arr,int p){
        double ac;
        int N = arr.size();
        double sum = 0;
        //1-st MathExp
        for (int i = p; i < N; i++) {
            sum += arr.get(i);
        }
        double m1 = sum /(N-p);

        //2-nd MathExp
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr.get(i);
        }
        double m2 = sum /(N-p);

        //AC calculation
        sum = 0;
        double suml1 = 0;
        double suml2 = 0;

        for (int i = p; i < N; i++) {
            sum += (arr.get(1) -m1 )*(arr.get(i-p)-m2);
            suml1 += (arr.get(i)-m1)*(arr.get(i)-m1);
            suml2 += (arr.get(i-p)-m2)*(arr.get(i-p)-m2);
        }
        ac = sum/Math.sqrt(suml1*suml2);



        return ac;
    }
}
