import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class St3mMain {

    public static void main(String[] args) throws IOException {
        String source = "source.stm";
        StringBuffer sourceCode = openSource(source);
        Map<String,String > map = lexer(sourceCode);
        System.out.println("St3m output :");

        if (map.get("print").equals("-1")){
            System.out.println("Print function doesn't got strings");
        }else {
            System.out.println("> "+ map.get("print"));
        }



    }

    static Map<String, String> lexer(StringBuffer sourceCode){
        ArrayList<String> tokens = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0 ; i < sourceCode.length() ; i ++){
            String token = sourceCode.substring(0,i+1);
            // System.out.println(token);

            if (token.equals("print")){
                tokens.add("print");
               // System.out.println("> Keyword : Print");
                map.put("print", "-1");
            }

            if (sourceCode.charAt(i)=='\"'){
                StringBuffer str = new StringBuffer();
                int count = 1;
                for (int j = i+1 ; j < sourceCode.length() ; j ++){
                    if (sourceCode.charAt(j) == '\"'){
                        count ++;
                        str.append(sourceCode.substring(i+1,j));
                        i = j ;
                    }
                }
                if (count%2 != 0){
                    System.out.print("> Error : Brackets not closed.");
                }else {
                    map.put("print",str.toString());
                }
            }

        }
        return map;
    }

    static StringBuffer openSource(String source) throws IOException {
        StringBuffer s = new StringBuffer();
       // System.out.print("Source code : \n");
        try {
            FileInputStream file = new FileInputStream(new File("src//"+source));
            int byt;
            while ((byt = file.read()) != -1) {
                //System.out.print((char) byt);
                s.append((char)byt);
            }
          //  System.out.println("\n-----------");
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }


}

