package mau.project.sharepool.config;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccountID {
    public static String get() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
