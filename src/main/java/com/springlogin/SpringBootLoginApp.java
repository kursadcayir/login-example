package com.springlogin;

import com.springlogin.model.Role;
import com.springlogin.model.User;
import com.springlogin.repository.RoleRepository;
import com.springlogin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@SpringBootApplication
public class SpringBootLoginApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginApp.class, args);
	}
}

@Component
class Commands implements CommandLineRunner {

	private final UserRepository repository;

	private final RoleRepository roleRepository;

	public Commands(UserRepository repository, RoleRepository roleRepository) {
		this.repository = repository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		loadRole();
		loadUser();
	}

	private void loadUser() {
		User u = new User();
		u.setActive(1);
		u.setName("name");
		u.setLastName("lastName");
		u.setEmail("test@test.com");
		u.setUsername("testname");
		u.setPassword("qweqweqwe1234");
		u.setRoles(new HashSet<Role>(roleRepository.findAll()));
		repository.save(u);
		System.out.println("User Loaded: " + repository.count());
	}
	private void loadRole() {
		Role admin = new Role();
		Role user = new Role();
		admin.setRole("ADMIN");
		roleRepository.save(admin);
		user.setRole("USER");
		roleRepository.save(user);
		System.out.println("Role Loaded: " + repository.count());
	}

}