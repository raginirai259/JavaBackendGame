package com.king.backend.manager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SessionCleanerScheduler implements Runnable {

    
    private final SessionManager sessionManager;

    
    public SessionCleanerScheduler(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    //Method to start the Thread to clean all the Invalid Sessions
    
    public void startService() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this, SessionManager.TIME_TO_LIVE, SessionManager.TIME_TO_LIVE, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        sessionManager.removeInvalidSessions();
    }
}

