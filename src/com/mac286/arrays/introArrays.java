package com.mac286.arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
An array is a collection of variables of the same type that are accessible using index

To define an array, we use:
type[] arrayName = new type[size];

ex:
int myAr[] = new int[10];
the first variable is: myAr[0] its index is 0;
Assign -4 to the third va
 */
public class introArrays {
    public static void main(String[] args){
        int[] myAr = new int[10];
        myAr[2] = -4;
        Scanner sc = new Scanner((System.in));
        //To read numbers into an array, we use loops
        //When you have an array think about a for loop
        for(int i = 0; i < myAr.length; i++)
        {
            System.out.println("Ar[" + i + "] : ");
            myAr[i] = sc.nextInt();
        }
        System.out.println("Here is your array");
        for(int i = 0; i < myAr.length; i ++) {
            System.out.println("Ar[" + i + "] : ");
        }

        //You can also create an array with specific value at teh declaration time.
        //create an array that contains teh names of months of the year
        String[] monthOfYear = {"None", "Jan"};

        //there is a big library of static methods that allow you to work with arrays
        //Example to make array bigger, increase size of myAr to 20
        myAr = Arrays.copyOf(myAr, 20);
        //fill myar forom index 10 to index 19(use 20) with -1 value
        Arrays.fill(myAr,10,20,-1);
    }
}
