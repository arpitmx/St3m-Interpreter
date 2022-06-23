import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class St3mMain {

    public static MethodsFK methodsFK;

    public static void main(String[] args) throws IOException {

        String source = "prog.fck";

        StringBuffer sourceCode = openSource(source);
        if (!sourceCode.toString().equals("")){
            methodsFK = new MethodsFK(sourceCode);
            Map<String,String > map = lexer(sourceCode);
            checkMethods(map);
        }
        else {
            throwShots("NS");
        }
    }

    static void throwShots(String key){
        switch (key){
            case "MNF":  System.out.println("St3m> No compatible positions found."); break;
            case "P-1":  System.out.println("St3m> Error : what to 'print' ? "); break;
            case "P-2":  System.out.println("St3m> Error : close the doors , if any one door is left out, anyone can hear us."); break;
            case "NS" :  System.out.println("St3m> Error : empty source"); break;

            default: System.out.println("St3m> Internal error , case(s) not found at key "+ key);



        }
    }

    static void checkMethods(Map<String, String> map){
        if (map.containsKey("print")){

            switch (map.get("print")){
                case "-1" :  throwShots("P-1");
                            break;
                case "-2" :  throwShots("P-2");
                            break;
                default:  System.out.println("St3m> "+ map.get("print"));
            }
        }
        else {
            throwShots("MNF");
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
                MethodsFK.Print(i, map);
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

