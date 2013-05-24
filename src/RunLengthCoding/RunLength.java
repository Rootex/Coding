
package RunLengthCoding;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PlaixHax0r A.K.A Sotaya
 * 
 */
public class RunLength {
    
    //pass our source into our encoder
    public static String encoder(String sourc) {
        StringBuilder sb = new StringBuilder();
        //boolean change = true;
        //iterate through each of the elements of our source
        for (int i = 0; i < sourc.length(); i++) {
            int lengthRun = 1;
            
            //while there is next character and current character equals next
            //we increment the length
            while (i+1 < sourc.length() && sourc.charAt(i) == sourc.charAt(i+1)) {
                lengthRun++;
                i++;
            }
            
            //after getting all occurencies of our character, we append to the 
            //end of the string builder followed by the character
            /*
            if(sourc.charAt(0) == '1' && change){
                sb.append("0");
                change=false;
            }*/
            sb.append(lengthRun).append(sourc.charAt(i));
            //sb.append(lengthRun);
        }
        return sb.toString();//we all know what this means
    }
    
    // Our decoder here gets the code which here means encoded source
    public static String decoder(String code) {
        
        //String builder for decoding
        StringBuilder sb = new StringBuilder();
        
        //our pattern contains all possible source alphabet that can occur
        Pattern pat = Pattern.compile("[0-9]+|[a-zA-Z]+|[_]");
        
        //our matcher takes the code and if the source letters are in our 
        //source alphabet, it ma
        Matcher match = pat.matcher(code);
        while (match.find()) {
            int number = Integer.parseInt(match.group());
            match.find();
            
            //we append our match to string builder the number of times it occurs
            for(int i=number;i>0;i--)
                sb.append(match.group());
            
        }
        return sb.toString();//the obvious :)
    }
 
    //Main method for testing our coding and decoding
    public static void main(String[] args) {
        String source = "hallgatoora";
        String code = "2h3l13k";
        System.out.println(encoder(source));
        System.out.println(decoder(code));
    }
}
    

