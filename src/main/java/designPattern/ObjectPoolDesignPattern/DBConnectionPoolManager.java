package designPattern.ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DBConnectionPoolManager {

    private List<DBConnection> freeConnInPool = new ArrayList<>();
    private List<DBConnection> connInUse = new ArrayList<>();

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;

    private static DBConnectionPoolManager instance = null;

    private DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnInPool.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if (instance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (instance == null) {
                    instance = new DBConnectionPoolManager();
                }
            }
        }
        return instance;
    }

    public synchronized DBConnection getDBConnection() {
        // check the free pool , if it emptry , create a ne connection
        if (freeConnInPool.isEmpty()) {
            if (connInUse.size() < MAX_POOL_SIZE) {
                DBConnection newConn = new DBConnection();
                connInUse.add(newConn);
                return newConn;
            } else {
                return null;
            }
            // else fetch it from freepoll and put in connin use
        } else {
            DBConnection dbConn = freeConnInPool.remove(freeConnInPool.size() - 1);
            connInUse.add(dbConn);
            return dbConn;
        }
    }

    public synchronized void releaseDBConnection(DBConnection dbConn) {
        if (dbConn != null) {
            connInUse.remove(dbConn);
            freeConnInPool.add(dbConn);
        }
    }
}

