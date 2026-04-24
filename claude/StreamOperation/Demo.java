package claude.StreamOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * public class Demo {
 * 
 * public void countCharacter(String str) { int strlenght=str.length();
 * 
 * char Arr[]=str.toCharArray(); char Brr[]=str.toCharArray(); int i,j,count=0;
 * 
 * for(i=0;i<=Arr.length-1;i++)
 * 
 * { for(j=0;j<=Brr.length-1;j++) {
 * 
 * if(Arr[i]==Brr[j]) { count ++; //System.out.println(Arr[i]+" "+count); }
 * //System.out.println(Arr[i]+" "+count); }
 * 
 * System.out.println(Arr[i]+" "+count); count=0; } }
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * 
 * Scanner sc=new Scanner(System.in);
 * System.out.println("Enter the String you want to Count character"); String
 * str=sc.nextLine(); Demo m=new Demo();
 * 
 * m.countCharacter(str);
 * 
 * 
 * 
 * }
 * 
 * }
 */


public class Demo {

    public void countCharacter(String str) {
    	
        char[] arr = str.toCharArray();
        int count;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue; // already counted

            count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = 0; // mark as counted
                }
            }
            System.out.println(arr[i] + " = " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String you want to count characters:");
        //String str = sc.nextLine();

        Demo demo = new Demo();
        demo.countCharacter("PpPrPaaPsr5558777grfff5   ippp555");
    }
}