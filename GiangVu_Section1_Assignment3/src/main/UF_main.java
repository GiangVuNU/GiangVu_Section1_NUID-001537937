package main;

import java.util.Random;

public class UF_main {

    static int count(int n){
        int pair = 0;
        Random random = new Random();
        UF_HWQUPC test = new UF_HWQUPC(n,true);
        while(test.components() > 1){
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            pair++;
            if(test.connected(p, q) == false) {
                //connect if two site is not already connected
                test.connect(p, q);
            }
        }
        return pair;
    }

    public static void main(String []args){
        int [] obj =  {100, 200, 400, 800, 1600,3200,6400,12800};
        int repeat = 20;
        System.out.println("Running the experiment " + repeat + " times: ....");
        for (int i =0; i < obj.length; i++){
            int res =0;
            int sum = 0;
            for (int j = 0; j <repeat; j++){
                sum += count(obj[i]);
            }
            res = sum/repeat;
            System.out.println("With number of objects(n): " + obj[i] + ", the average number of pairs generated is: "+ res);
        }
    }
}
