/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lz78;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 *
 * @author PlaixHax0r
 */
public class Encoder {
    public static void main(String[] args){
        //Dictionary
        ArrayList<String> dictionary = new ArrayList<String>();
        
        //input string converted to array to allow indexed reach
        String[] input = "dabbacdabbacdabbacdabbacdeecdeecdee".split("");
        
        //our code word with a structure (a=b:c) a is index, b is index of match
        //0 if not in the dictionary, c is next character in the input sequesnce
        HashMap<Integer, String> codeWord = new HashMap<Integer, String>();
        
        
        int index = 1;//current index, initialized to 1
        String current ="";// Current string in which we are coding
        
        int key = 0;
        dictionary.add(null);
        
        //while we still have input
        while(index < input.length-1){
            current = input[index];//initializing current to first input word
            
            //checking if word is contained in dictionary
            if(dictionary.contains(current)){
                String previous="";//maximum matched string found in dictionary
                
                //calling the function add which find the maximum matched string + next
                current = add(current, dictionary, input, index);
                
                int j = index;
                for(int i=0; i<current.length()-1;i++){
                    previous += input[j];
                    j+=1;
                }
                
                //adding our new code word to the codeWord hash map
                codeWord.put(key++, (dictionary.indexOf(previous)+":"+append(current)));
                
                //incrementing our index by length of our current to show actual next.
                index = index+current.length();
                
                //System.out.println((Arrays.asList(input).indexOf(current)));
                dictionary.add(current);//appending to our dictionary coded input
                
               
            }
            
            //else when input string not in dictionary
            else {
                codeWord.put(key++, "0:"+current);//add to codeWord with 0
                dictionary.add(current);//add to dictionary new coded string
                index++;
            }
            
            System.out.println(codeWord.entrySet()+" "+dictionary);
            //System.out.println(current+next);
            //new Scanner(System.in).next();
        }
        System.out.println(codeWord);
        
    }
    
    //method to finding matching characters that are found in the dictionary then + next
    public static String add(String current, ArrayList<String> dictionary, String[] in, int index){
        for(int i=index; i<in.length;i++){
            if(dictionary.contains(current)){
                current = current+in[i+1];
            }
        }
        return current;
    }
    
    //method for finding next character in the input string
    public static String append(String current){
         String [] name = current.split("");
         return name[name.length - 1];
    }
}
