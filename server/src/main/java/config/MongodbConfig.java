package config;

import document.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import repository.UserRepo;

@EnableReactiveMongoRepositories(basePackageClasses = UserRepo.class)
@Configuration
public class MongodbConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepo userRepo){
        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepo.save(new User(1, "Sami", "sami@gmail.com", "123456"));
                userRepo.save(new User(2, "marvel", "marvel@gmail.com", "123456"));
                userRepo.save(new User(3, "oury", "oury@gmail.com", "123456"));
            }
        };
    }
}
