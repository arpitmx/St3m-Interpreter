import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StemPreter {

    public static MethodsFK methodsFK;
    final String stm = "St3m> ";

    void stemInitSource(String path){
        try {
            System.out.println(stm+"Fetching source file ...");
            runSt3m(openSource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void runSt3m(StringBuffer sourceCode){

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
            case "P-1":  System.out.println("St3m> Error : what to 'moan' ? "); break;
            case "P-2":  System.out.println("St3m> Error : close the doors , if any one door is left out, anyone can hear us."); break;
            case "NS" :  System.out.println("St3m> Error : empty source"); break;

            default: System.out.println("St3m> Internal error , case(s) not found at key "+ key);
        }
    }

    static void checkMethods(Map<String, String> map){
        if (map.containsKey("moan")){

            switch (map.get("moan")){
                case "-1" :  throwShots("P-1");
                            break;
                case "-2" :  throwShots("P-2");
                            break;
                default:  System.out.println("St3m> "+ map.get("moan"));
            }
        }
        else {
            throwShots("MNF");
        }
    }



    static Map<String, String> lexer(StringBuffer sourceCode){


        ArrayList<String> tokens = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String token;

        for (int i = 0 ; i < sourceCode.length() ; i ++){

             token = sourceCode.substring(0,i+1);
             //System.out.println(token);

            if (token.contains("moan")){
                tokens.add("moan");
               // System.out.println("> Keyword : Print");
                map.put("moan", "-1");
                if (MethodsFK.Moan(i, map) == -2 ){
                    map.put("moan", "-2");
                }else {
                    i = MethodsFK.Moan(i, map)+1;
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

