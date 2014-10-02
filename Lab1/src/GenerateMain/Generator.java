package GenerateMain;

import java.util.ArrayList;

/**
 * Created by andrewbudy on 02.10.14.
 */
public  class Generator {

    public static ArrayList<Double> Generate(int n, double l, int k){

        ArrayList<Double> res= new ArrayList<Double>();
        for (int i = 0; i < n  ; i++) {
            double t = 0;
            for (int j = 0; j < k ; j++) {
                t += -(1.0/l)*Math.log(Math.random());
            }
            res.add(t);
        }

        return res;
    }

}
