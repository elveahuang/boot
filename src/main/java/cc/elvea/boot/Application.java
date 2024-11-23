package cc.elvea.boot;

import cc.elvea.boot.commons.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author elvea
 * @since 24.1.0
 */
@SpringBootApplication
@EntityScan(basePackages = {
        "cc.elvea.boot.**.entity",
})
@EnableJpaRepositories(basePackages = {
        "cc.elvea.boot.**.repository",
}, repositoryBaseClass = BaseRepositoryImpl.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
