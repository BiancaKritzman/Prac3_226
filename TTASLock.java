import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class TTASLock 
{

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final AtomicLong tasCalls = new AtomicLong(0);

    /* Do not modify this method */
    private boolean testAndSet() 
    {
        tasCalls.incrementAndGet();
        return locked.getAndSet(true);
    }

    public void lock() {
    while (true) {
        while (locked.get()) {};
            if (!testAndSet())
                return;
    }

    }
    public void unlock() {
        locked.set(false);
    }
    
    public long getTestAndSetCount() {
        return tasCalls.get();
    }
    
}


