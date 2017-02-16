/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplecoding;

/**
 *
 * @author dpa50876
 */
public class SampleCoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //--- STAIRCASE problem
        //int n = 4;
        //drawStairCase(n);
        
        //--- multiplication by bit shifts
        //multiply(4,4);
        
        //-- time conversion
//        String time = "12:05:45AM";
//        convertTime(time);
        
        //-- Rotate array k times
//        int[] a = {1, 2, 3, 4};
//        int n = 4;
//        int k = 2;
////        rotateArray(a, k);
//        for (int i = 0; i < 4; i++) {
//            if (i >= k%n) {
//                System.out.println(a[i-k%n]);
//            } else {
//                System.out.println(a[i+n-k%n]);
//            }
//            
//        }
        
        //-- Left array rotation
//        int[] a = {1,2,3,4,5};
//        int d = 4;
//        int[] result = new int[a.length];
//        System.out.println(a.length);
//        result = rotateLeftArray(a, a.length, d);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//        System.out.println();
        
        //-- Cryptography
//        String a = "cde";
//        String b = "abc";
//        int ndiff = numberNeeded(a, b);
//        System.out.println(ndiff);
        
    
        //-- Given a tree, root node, & two nodes, find common ancestor
        // if either node is root, then return root, else traverse left,
        // then traverse right searching for nodes
    }
    
    // Cryptography
    public static int numberNeeded(String first, String second) {
        int n = 0;
        int[] all_letters = new int[36];
        
        char[] first_array = first.toCharArray();
        char[] second_array = second.toCharArray();
        
        for (int i=0; i<first_array.length; i++) {
            int idx = Character.getNumericValue(first_array[i]);
            all_letters[idx]++;
        }
        
        for (int j=0; j<second_array.length; j++) {
            int idx = Character.getNumericValue(second_array[j]);
            all_letters[idx]--;
        }
        
        int sum = 0;
        for (int letter : all_letters) {
            sum += Math.abs(letter);
        }
        
        return sum;
    }
    
    
    // Rotate array a left d times O(n) time complexity & O(n) space to store
    public static int[] rotateLeftArray(int[] a, int n, int d) {
        int[] result = new int[a.length];
        if (d == n) return result = a;
        int rot = d%n;
        System.out.println(rot);
        for (int idx=0; idx < n; idx++) {
            if (idx+rot < n) {
                result[idx] = a[idx+rot];
            } else {
                result[idx] = a[idx+rot-n];
            }
        }
        
        return result;
    }
    
    
    // Rotate array a, k times 
    public static void rotateArray(int[] a, int k) {
        int n = a.length;
        if (n == k) return;
        
        // this is O(n*k)
        // need only k%n rotations if k > n
        for (int i = 0; i < k%n; i++) {
            // rotate array once left to right
            int temp = a[a.length-1];
            for (int j = a.length-1; j > 0; j--) {
                a[j] = a[j-1];
            }
            a[0] = temp;
        }
        

    }
    
    
    
    public static void convertTime(String time) {
        char[] time_array = time.toCharArray();
        int n = time_array.length;
        
        // create modified time array which excludes the AM/PM designation
        char[] modified_time = new char[n-2];
        for (int i = 0; i < n-2; i++) {
            modified_time[i] = time_array[i];
        }
        
        char tod = time_array[n-2];
        int hour;
        if (time_array[0] == '0') {
            hour = Character.getNumericValue(time_array[1]);
        } else {
            hour = Character.getNumericValue(time_array[0] + time_array[1]);
        }
        System.out.println(hour);
        if (tod == 'A' & hour == 12) {
            modified_time[0] = '0';
            modified_time[1] = '0';
        } else if (tod == 'P' & hour != 12) {
            hour += 12;
            char h1 = Character.forDigit(hour/10, 10);
            char h2 = Character.forDigit(hour%10, 10);
            modified_time[0] = h1;
            modified_time[1] = h2;
        }
        System.out.println(modified_time);
    }
    
    
    
    public static void multiply(int a, int b) {
        // sample implementation
        int result = a;
        result <<= b/2;
        result += a*(b%2);
        
        // implementation without using any operators
        int new_result = 0;
        while (b != 0) {
            if ((b & 1) == 1) new_result += a;
            a <<= 1;
            b >>= 1;
        }

        System.out.println(result);
        System.out.println(new_result);    
    }
    
    public static void drawStairCase(int n) {
        
        for (int i = 0; i < n; i++) {
            String step = "";
            for (int j = n-1; j > i; j--) {
                step += " ";
            }
            for (int k = 0; k < i+1; k++) {
                step += "#";
            }
            
            System.out.println(step);
        }
        
    }
}
