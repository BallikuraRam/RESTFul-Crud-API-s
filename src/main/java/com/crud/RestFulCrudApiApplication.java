package com.crud;

import com.crud.model.Users;
import com.crud.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.cert.Extension;

@SpringBootApplication
@RequiredArgsConstructor
public class RestFulCrudApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RestFulCrudApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting Run ....");
        Users users = new Users();

        users.setUserId(1L);
        users.setUserName("Ram");
        users.setPassword(passwordEncoder.encode("pwd"));
        users.setUserEmail("pwd@gmal.com");
        this.usersRepository.save(users);
    }
}
