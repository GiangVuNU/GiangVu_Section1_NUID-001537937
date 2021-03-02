package main;

import java.util.Random;

public class UF_main {

    static int count_1(int n){
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

    static int count_2(int n){
        int pair = 0;
        Random random = new Random();
        WQUPC test2 = new WQUPC(n);
        while(test2.count() > 1){
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            pair++;
            if(test2.connected(p, q) == false) {
                //connect if two site is not already connected
                test2.union(p, q);
            }
        }
        return pair;
    }

    public static void main(String []args){
        int [] obj =  {100, 200, 400, 800, 1600,3200,6400,12800};
        int repeat = 20;
        System.out.println("Running the experiment " + repeat + " times: ....");
        System.out.println("Apply Weighted Union using Depth method:");
        for (int i =0; i < obj.length; i++){
            int res =0;
            int sum = 0;
            for (int j = 0; j <repeat; j++){
                sum += count_1(obj[i]);
            }
            res = sum/repeat;
            System.out.println("With number of objects(n): " + obj[i] + ", the average number of pairs generated is: "+ res);
        }
        System.out.println("--------------------------------------");
        System.out.println("Apply Weighted Union w/ Path Compression pointing to root method:");
        for (int i =0; i < obj.length; i++){
            int res =0;
            int sum = 0;
            for (int j = 0; j <repeat; j++){
                sum += count_2(obj[i]);
            }
            res = sum/repeat;
            System.out.println("With number of objects(n): " + obj[i] + ", the average number of pairs generated is: "+ res);
        }
    }
}