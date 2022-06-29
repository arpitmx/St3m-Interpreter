import java.util.ArrayList;
import java.util.Map;

public class MethodsFK {


    static StringBuffer sourceCode;

    MethodsFK(StringBuffer sourceCode){
        this.sourceCode = sourceCode;
    }

    public static int Moan(int k, Map<String,String> map){


        for (int i = k ; i < sourceCode.length(); i++) {
            if (sourceCode.charAt(i) == '\"') {

                StringBuffer str = new StringBuffer();
                int count = 1;


                for (int j = i + 1; j < sourceCode.length(); j++) {
                    if (sourceCode.charAt(j) == '\"') {
                        count++;
                        str.append(sourceCode.substring(i + 1, j));
                        i = j;
                        k = j;
                    }
                }


                if (count % 2 != 0) {
                    //System.out.print("> Error : Brackets not closed.");
                    map.put("moan", "-2");
                    k = -2;
                } else {
                    map.put("moan", str.toString().trim());
                }
            }

        }
        return k;
    }




}

