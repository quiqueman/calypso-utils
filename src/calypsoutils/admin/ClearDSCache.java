package calypsoutils.admin;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.calypso.apps.startup.AppStarter;
import com.calypso.tk.core.CacheLimit;
import com.calypso.tk.core.SerializationException;
import com.calypso.tk.event.PSException;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteAccess;
import com.calypso.tk.util.ConnectException;
import com.calypso.tk.util.ConnectionUtil;

/**
 * This is a simple client application which clear the dataserver cache without
 * start the Admin window.
 * 
 */
public class ClearDSCache {

    private static final String USAGE_TEXT = "Usage: java ClearDSCache -env <environment>"
            + " -user <user> -password <password> [-noaudit] [-nogui]";

    /**
     * @param args
     * @throws ConnectException
     * @throws PSException
     * @throws RemoteException
     * @throws SerializationException
     */
    public static void main(final String[] args) throws ConnectException,
            PSException, RemoteException, SerializationException {
        final ClearDSCache app = new ClearDSCache();
        if (app.checkParams(args)) {
            app.connect(args);
            app.changeLogLevel(false);
            app.clearCache();
            app.changeLogLevel(true);
            app.disconnect();
        } else {
            app.printUsage();
        }
    }

    protected String env;

    protected String user;

    protected String passwd;

    protected DSConnection ds;

    private boolean noAudit = true;

    private Vector<String> logLevels;

    private boolean noGui = true;

    @SuppressWarnings("unchecked")
    boolean clearCache() {
        final RemoteAccess remote = this.ds.getRemoteAccess();

        final Hashtable<String, CacheLimit> caches;
        try {
            caches = remote.getCacheLimits();
            final StringBuilder sb = new StringBuilder("Caches cleared:\n");
            for (final CacheLimit limit : caches.values()) {
                remote.clearCache(limit.getName());
                sb.append(limit.getName());
                sb.append(", ");
            }
            info(sb.toString());
        } catch (final RemoteException e) {
            error("Exception during clear cache", e.getMessage());
        }

        return true;
    }

    boolean check(final String title, final String message) {
        final int result = JOptionPane.showConfirmDialog(null, message, title,
                JOptionPane.OK_CANCEL_OPTION);
        return (result == JOptionPane.OK_OPTION);
    }

    boolean checkParams(final String[] args) {
        this.env = AppStarter.getOption(args, "-env");
        this.user = AppStarter.getOption(args, "-user");
        this.passwd = AppStarter.getOption(args, "-password");
        this.noAudit = AppStarter.isOption(args, "-noaudit");
        this.noGui = AppStarter.isOption(args, "-nogui");
        return (this.env != null) && (this.user != null)
                && (this.passwd != null);
    }

    void connect(final String[] args) throws ConnectException, PSException,
            RemoteException {
        this.ds = ConnectionUtil.connect(this.user, this.passwd, "MainEntry",
                this.env);
    }

    @SuppressWarnings({ "unchecked" })
    void changeLogLevel(final boolean enable) throws RemoteException {
        if (this.noAudit) {
            if (enable) {
                this.ds.getRemoteAccess().changeLogFilterSettings(
                        this.logLevels.get(0), this.logLevels.get(1));
            } else {
                this.logLevels = this.ds.getRemoteAccess()
                        .getLogFilterSettings();
                this.ds.getRemoteAccess().changeLogFilterSettings(
                        "WARN,ERROR,FATAL", this.logLevels.get(1));
            }
        }
    }

    void disconnect() throws PSException {
        this.ds.disconnect();
    }

    void error(final String title, final String message) {
        if (this.noGui) {
            System.out.println(title + ": " + message);
        } else {
            JOptionPane.showMessageDialog(null, message, title,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    void info(final String message) {
        if (this.noGui) {
            System.out.println(message);
        } else {
            JOptionPane.showMessageDialog(null, message, "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void printUsage() {
        error("Bad arguments", USAGE_TEXT);
    }

}
