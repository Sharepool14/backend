package mau.project.sharepool;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.category.Category;
import mau.project.sharepool.category.CategoryRepository;
import mau.project.sharepool.community.Community;
import mau.project.sharepool.community.CommunityRepository;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.item.ItemRepository;
import mau.project.sharepool.userinformation.UserInformation;
import org.hibernate.service.spi.InjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SharepoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharepoolApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}
}
