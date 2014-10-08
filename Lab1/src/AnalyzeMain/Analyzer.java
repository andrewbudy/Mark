package AnalyzeMain;

import java.util.ArrayList;

public class Analyzer {

    public static double[] Analyze(ArrayList<Double> arr){

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
}
