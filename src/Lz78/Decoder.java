/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lz78;

import java.util.ArrayList;

/**
 *
 * @author pl41x
 */
public class Decoder {
    public static void main(String[] args){
         String[] codeWord = "0:d 0:a 0:b 3:a 0:c 1:a 3:b 2:c 6:b 4:c 9:b".split(" ");
         ArrayList<String> dictionary = new ArrayList<String>();
         String first, last;
         for(String d : codeWord){
             //System.out.println(d);
             first = d.substring(0, 1);
             last = d.substring(2, d.length());
            //System.out.println(first+" "+last);
             if(Integer.parseInt(first) == 0){
                 dictionary.add(last);
             }else{
                 int index = Integer.parseInt(first);
                 System.out.println(dictionary);
                 dictionary.add(dictionary.get(index-1)+last);
             }
         }
         StringBuilder sb = new StringBuilder();
         for(String d : dictionary){
             sb.append(d);
         }
         
         System.out.println(sb.toString());
    }
    
}
