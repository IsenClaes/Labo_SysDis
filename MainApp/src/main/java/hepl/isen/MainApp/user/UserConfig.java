package hepl.isen.MainApp.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

//    private final PasswordEncoder passwordEncoder;
//
//    public UserConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository) {
//        return args -> {
//            User isen = new User(
//                    "Isen",
//                    passwordEncoder.encode("123"),
//                    "Rue aaa",
//                    true,
//                    "USER",
//                    50000
//            );
//            User claes = new User(
//                    "Claes",
//                    passwordEncoder.encode("123"),
//                    "Rue aaa",
//                    true,
//                    "USER",
//                    20000
//            );
//            User madani = new User(
//                    "Madani",
//                    passwordEncoder.encode("123"),
//                    "Rue aaa",
//                    true,
//                    "USER",
//                    10000
//            );
//            User peter = new User(
//                    "Peter",
//                    passwordEncoder.encode("123"),
//                    "Rue aaa",
//                    true,
//                    "USER",
//                    100
//            );
//            User harry = new User(
//                    "Harry",
//                    passwordEncoder.encode("123"),
//                    "Rue aaa",
//                    true,
//                    "USER",
//                    100
//            );
//
//            repository.saveAll(List.of(isen, claes, madani, peter, harry));
//        };
//    }

/*
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        Collection<Commande> emptyListCommande = new ArrayList<>();
        return args -> {
            User isen = new User(
                    "Isen",
                    "123",
                    "Rue aaa",
                    true,
                    "USER",
                    emptyListCommande,
                    50000
            );
            User claes = new User(
                    "Claes",
                    "123",
                    "Rue aaa",
                    true,
                    "USER",
                    emptyListCommande,
                    20000
            );
            User madani = new User(
                    "Madani",
                    "123",
                    "Rue aaa",
                    true,
                    "USER",
                    emptyListCommande,
                    10000
            );
            User peter = new User(
                    "Peter",
                    "123",
                    "Rue aaa",
                    true,
                    "USER",
                    emptyListCommande,
                    100
            );
            User harry = new User(
                    "Harry",
                    "123",
                    "Rue aaa",
                    true,
                    "USER",
                    emptyListCommande,
                    100
            );

            repository.saveAll(List.of(isen, claes, madani, peter, harry));
        };
    }*/

}
