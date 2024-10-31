package designPattern.SingletonDesignPattern;

public class SyncronisedMethod {
    private static SyncronisedMethod syncronisedMethod;

    private SyncronisedMethod(){

    }

    synchronized  public static SyncronisedMethod getInstance(){
        if(syncronisedMethod==null){
            syncronisedMethod=new SyncronisedMethod();
        }
        return syncronisedMethod;
    }
}
