package designPattern.ObjectPoolDesignPattern;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        DBConnectionPoolManager pm = DBConnectionPoolManager.getInstance();

        DBConnection d1 = pm.getDBConnection();
        DBConnection d2 = pm.getDBConnection();
        DBConnection d3 = pm.getDBConnection();

        // Use the connections...

        // Release one connection
        pm.releaseDBConnection(d1);
    }
}

