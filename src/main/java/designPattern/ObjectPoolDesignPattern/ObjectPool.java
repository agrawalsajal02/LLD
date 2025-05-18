//package designPattern.ObjectPoolDesignPattern;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.TimeUnit;
//
//class DBConnectionPoolManager {
//
//    // Define a blocking queue to manage connections in the pool
//    private final BlockingQueue<DBConnection> connectionPool;
//    private static final int INITIAL_POOL_SIZE = 3;
//    private static final int MAX_POOL_SIZE = 6;
//    private static DBConnectionPoolManager dbConnectionPoolManagerInstance = null;
//
//    // Private constructor to initialize the pool
//    private DBConnectionPoolManager() {
//        connectionPool = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
//
//        // Initialize the pool with the initial size
//        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
//            connectionPool.offer(new DBConnection());
//        }
//    }
//
//    // Singleton instance getter with double-checked locking
//    public static DBConnectionPoolManager getInstance() {
//        if (dbConnectionPoolManagerInstance == null) {
//            synchronized (DBConnectionPoolManager.class) {
//                if (dbConnectionPoolManagerInstance == null) {
//                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
//                }
//            }
//        }
//        return dbConnectionPoolManagerInstance;
//    }
//
//    // Method to get a connection from the pool, with waiting capability
//    public DBConnection getDBConnection() throws InterruptedException {
//        // Wait for a connection to become available, up to a timeout of 5 seconds
//        DBConnection connection = connectionPool.poll(5, TimeUnit.SECONDS);
//        if (connection == null) {
//            throw new RuntimeException("No available connections in the pool.");
//        }
//        return connection;
//    }
//
//    // Method to release a connection back to the pool
//    public void releaseDBConnection(DBConnection dbConnection) {
//        if (dbConnection != null) {
//            connectionPool.offer(dbConnection);  // Return the connection to the pool
//        }
//    }
//}
//
//// Simple DBConnection class to represent a database connection
//class DBConnection {
//    // Assume some fields and methods that manage the actual connection
//}
//
//// Client code to test the connection pool
//public class ObjectPool {
//    public static void main(String[] args) {
//        try {
//            DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();
//
//            DBConnection dbConnection1 = poolManager.getDBConnection();
//            DBConnection dbConnection2 = poolManager.getDBConnection();
//            DBConnection dbConnection3 = poolManager.getDBConnection();
//
//            // Release a connection back to the pool
//            poolManager.releaseDBConnection(dbConnection3);
//
//            // Get another connection
//            DBConnection dbConnection4 = poolManager.getDBConnection();
//
//            System.out.println("Connections successfully retrieved and released.");
//        } catch (InterruptedException e) {
//            System.out.println("Failed to get a connection: " + e.getMessage());
//        }
//    }
//}
