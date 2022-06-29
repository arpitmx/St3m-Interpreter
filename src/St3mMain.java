import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class St3mMain {

    StemPreter stemPreter;
    St3mEditor stemEditor;
    static final String stm = "St3m> ";
    public static void main(String args[]) throws IOException {

        St3mLexer lexer = new St3mLexer();
        St3mParser parser = new St3mParser();
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------ << ST3M INTERPRETER >> ------------------");
        while(true) {

           System.out.print(stm + "Select Mode : \n 1. Stem Editor\n 2. Source file \n"+stm);
           int choice = sc.nextInt();
           if (choice == 1) {

               St3mEditor stemEditor = new St3mEditor();
               stemEditor.initEditor();
               break;

           } else if (choice == 2) {
               System.out.print(stm + "File path: ");
               String path = sc.next();
               //stemPreter.stemInitSource(path);
               lexer.init_lexer(openSource(path).toString());
               parser.setClassifications(lexer.returnClass());
               break;

           } else {
               System.out.println(stm + "Invalid input");
           }
       }


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

