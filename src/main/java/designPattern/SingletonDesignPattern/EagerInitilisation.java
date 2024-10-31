package designPattern.SingletonDesignPattern;

public class EagerInitilisation {
    private static EagerInitilisation eagerInitilisation= new EagerInitilisation();

    private EagerInitilisation(){

    }

    public static EagerInitilisation getInstance(){
        return eagerInitilisation;
    }
}
