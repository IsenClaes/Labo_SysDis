package hepl.isen.TvaService.article;

import hepl.isen.TvaService.tva.TvaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ArticleConfig {
/*
    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository repository, TvaRepository tvaRepository) {
        return args -> {
            Article livre = new Article(
                    "Programmer pour les nuls",
                    20,
                    "Livres",
                    200,
                    tvaRepository.getById(Long.valueOf(1))
            );
            Article clavier = new Article(
                    "Clavier",
                    80,
                    "Informatique",
                    100,
                    tvaRepository.getById(Long.valueOf(2))
            );
            Article souris = new Article(
                    "Souris",
                    40,
                    "Informatique",
                    150,
                    tvaRepository.getById(Long.valueOf(2))
            );
            Article ecran = new Article(
                    "Ecran 144hz",
                    200,
                    "Informatique",
                    85,
                    tvaRepository.getById(Long.valueOf(2))
            );
            Article pc = new Article(
                    "PC Portable",
                    900,
                    "Informatique",
                    50,
                    tvaRepository.getById(Long.valueOf(2))
            );

            repository.saveAll(List.of(livre, clavier, souris, ecran, pc));
        };
    }
 */
}
