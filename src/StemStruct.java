import java.util.ArrayList;

public class StemStruct {


    ArrayList<Method> dList= new ArrayList<Method>();

    class Method{

        String type,name,argument;
        int[] location= new int [2];

        Method(String type,String name, String argument , int[] location){
                    this.type = type;
                    this.name = name;
                    this.argument = argument;
                    this.location = location;

        }

    }

    public void append(String type,String name, String argument , int[] location){
        Method method = new Method(type,name,argument,location);
        dList.add(method);
    }

    public ArrayList<Method> returnToken(){
        return dList;
    }
    // dList has 'data' , each data packet contains two values : dir , mag
//    public void print(){
//        if (!dList.isEmpty()){
//            for (Data data : dList){
//                System.out.println("<<Tokens : [Dir: "+data.direction+" , Mag: "+data.magnitude.toString()+"]");
//            }
//        }else{
//            System.out.println("<<Token Holder is Empty!");
//        }
//    }

    public void clear(){
        dList.clear();
    }

}
