package com.example.carspring;

import com.example.carspring.model.Car;
import com.example.carspring.model.Category;
import com.example.carspring.model.Role;
import com.example.carspring.model.User;
import com.example.carspring.repository.CategoryRepository;
import com.example.carspring.repository.RoleRepository;
import com.example.carspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSpringApplication.class, args);
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        return args -> {


            Role roleAdmin = new Role("ROLE_ADMIN");
            Role roleUser = new Role("ROLE_USER");
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);

            User userAdmin = new User("admin", bCryptPasswordEncoder.encode("admin"), roleAdmin);
            userRepository.save(userAdmin);

            User userSimple = new User("user", bCryptPasswordEncoder.encode("user"), roleUser);
            userRepository.save(userSimple);

            Category category = new Category("Default");
            Car car1 = new Car("Tesla", "En l'absence de moteur à combustion interne, la zone de déformation peut mieux réduire les risques de blessures pour les occupants.", 45000f);
            Car car2 = new Car("Mustang-mach-e", "Premier SUV 100 % électrique de Ford. Découvrez son design élégamment sculpté, ses technologies de pointe et son autonomie électrique de 610 km.", 70000.500f);
            Car car3 = new Car("Mustang-mach-e", "Premier SUV 100 % électrique de Ford. Découvrez son design élégamment sculpté, ses technologies de pointe et son autonomie électrique de 610 km.", 70000.500f);
            category.addCar(car1);
            category.addCar(car2);
            category.addCar(car3);

            categoryRepository.save(category);
        };

    }
}
