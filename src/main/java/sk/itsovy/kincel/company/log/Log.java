package sk.itsovy.kincel.company.log;

public class Log {
    public void error(String msg){
        System.out.println("[ERROR]   :  " +msg);
    }
    public void print(String msg){
        System.out.println("[OKAY]  : " +msg);
    }
}
