package designPattern.SingletonDesignPattern;

// Issue with this approach
// 1.Reordering of instractuing innmultithreading might cause inconsistency
// 2. In multithreading , if 1st thread saved till in cache not in memory , and in the meanwhile if other thread comes , it checkes its own cache and then momory , it do not found the object , it will create the new object again
// fix is volatile keyword
    // it has two properties
    // it read and write from memory , DoubleLocking object will directly dumped in the momory itself , and T2 tread directly read from memory not cache
    // All the instructing before the volatile can be reordered ,  All the instructing after the volatile can be reordered , but they cannot be reordered themselves . Also all the incstcutions that are reordered before the volatile declared, they must be dumped into the memory .
            // Above is also known as Have Before , because it brings certain kind of reordering in instructions
public class DoubleLocking {
    private static DoubleLocking doubleLocking;

    private DoubleLocking(){

    }

      public static DoubleLocking getInstance(){
        if(doubleLocking==null){
            synchronized (DoubleLocking.class){
                if(doubleLocking==null){
                    doubleLocking=new DoubleLocking();
                }
            }
        }
        return doubleLocking;
    }
}
