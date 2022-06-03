package mau.project.sharepool.config;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccountID {
    public static Long get() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
