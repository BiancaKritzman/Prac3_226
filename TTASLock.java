import java.util.concurrent.atomic.AtomicBoolean;

public class TTASLock 
{

    private final AtomicBoolean locked = new AtomicBoolean(false);

    /* Do not modify this method */
    private boolean testAndSet() 
    {
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
    
}


