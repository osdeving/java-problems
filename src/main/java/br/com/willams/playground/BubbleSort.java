package br.com.willams.playground;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        var v = new int[]{5,6,2, 323, 3, 43, 0, 10, 1,8};

        boolean sorted = false;

        while(sorted == false) {
            sorted = true;

            for (int i = 0; i < v.length - 1; i++) {
                
                if(v[i] > v[i+1]) {
                    var tmp = v[i];
                    v[i] = v[i+1];
                    v[i+1] = tmp;

                    sorted = false;
                }
            }
        }
 
        System.out.println(Arrays.toString(v));
    }    
}
