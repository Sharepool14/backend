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

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(
			AccountRepository accountRepository,
			ItemRepository itemRepository,
			CategoryRepository categoryRepository,
			CommunityRepository communityRepository,
			CommunityAccountRepository communityAccountRepository) {

		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Account> accounts = new ArrayList<>();
				accounts.add(new Account("hugo@outlook.com","$2a$10$RVY94awLCW2zv6VVYxtu3.yN.93p7pLyEslv.VloRavZJ/vAkcmNC",new UserInformation("Hugo","Lindstedt","0123-1240","Eslöv","41231","Gata 1")));
				accounts.add(new Account("anton@outlook.com","$2a$10$RVY94awLCW2zv6VVYxtu3.yN.93p7pLyEslv.VloRavZJ/vAkcmNC",new UserInformation("anton","Lindstedt","0123-1240","Eslöv","41231","Gata 1")));
				accounts.add(new Account("lisa@outlook.com","$2a$10$RVY94awLCW2zv6VVYxtu3.yN.93p7pLyEslv.VloRavZJ/vAkcmNC",new UserInformation("lisa","Lindstedt","0123-1240","Eslöv","41231","Gata 1")));
				accounts.add(new Account("theo@outlook.com","$2a$10$RVY94awLCW2zv6VVYxtu3.yN.93p7pLyEslv.VloRavZJ/vAkcmNC",new UserInformation("theo","Lindstedt","0123-1240","Eslöv","41231","Gata 1")));

				Category category = categoryRepository.save(new Category("Category 1"));
				Community c1 = communityRepository.save(new Community("Community 1"));
				Community c2 = communityRepository.save(new Community("Community 2"));

				accounts.stream().forEach(account -> {
					Account a = accountRepository.save(account);
					itemRepository.save(new Item(a,a.getUserInformation().getFirstname()+ " Item","Description",category));
				});

				communityAccountRepository.save(new CommunityAccount(accounts.get(1),c1,3));
				communityAccountRepository.save(new CommunityAccount(accounts.get(2),c2,3));

			}
		};
	}
}
