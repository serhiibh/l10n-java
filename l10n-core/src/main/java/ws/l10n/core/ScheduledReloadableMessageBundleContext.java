package ws.l10n.core;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Anton Mokshyn
 */
public class ScheduledReloadableMessageBundleContext extends ReloadableMessageBundleContext {

    private static final int ONE_MINUTE = 60 * 1000;
    private static final int ONE_HOUR = 60 * 60 * 1000;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private long period = ONE_HOUR;

    public ScheduledReloadableMessageBundleContext(MessageBundleService messageBundleService, String bundleKey, String bundleVersion) {
        super(messageBundleService, bundleKey, bundleVersion);
    }

    public ScheduledReloadableMessageBundleContext(MessageBundleService messageBundleService, String bundleKey, String bundleVersion,
                                                   long period) {
        super(messageBundleService, bundleKey, bundleVersion);
        if(period < ONE_MINUTE) {
            throw new IllegalArgumentException("scheduler period cannot be less that 1 minute");
        }
        this.period = period;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(new Runnable() {

            public void run() {
                reload();
            }
        }, 0, period, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }

}
