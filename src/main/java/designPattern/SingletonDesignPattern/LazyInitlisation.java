package designPattern.SingletonDesignPattern;

public class LazyInitlisation {
    private static LazyInitlisation lazyInitlisation;

    private LazyInitlisation(){

    }

    public static LazyInitlisation getInstance(){
        if(lazyInitlisation==null){
            lazyInitlisation=new LazyInitlisation();
        }
        return lazyInitlisation;
    }
}
