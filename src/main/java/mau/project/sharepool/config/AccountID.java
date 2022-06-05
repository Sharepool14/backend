package mau.project.sharepool.config;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Hugo Lindstedt
 * Utility class for retriving Security Context used for checking authentioncation.
 */
public class AccountID {
    public static Long get() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
