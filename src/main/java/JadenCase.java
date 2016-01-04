/**
 * Created by dovbysh on 23.10.2015.
 */
public class JadenCase {

    public static String toJadenCase(String phrase) {
        if (phrase==null || phrase.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = phrase.split(" ");
        for (String s : strings){
            char[] characters = s.toCharArray();
            characters[0] = Character.toUpperCase(characters[0]);
           sb.append(characters).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args){
        System.out.println(toJadenCase("toJadenCase doesn't return a valide JadenCase String! try again please"));
        int[] a = new int[]{2,3}  ;
    }
}