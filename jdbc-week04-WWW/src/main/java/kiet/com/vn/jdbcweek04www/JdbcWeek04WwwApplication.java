package kiet.com.vn.jdbcweek04www;

import kiet.com.vn.jdbcweek04www.daos.EmployeeDAO;
import kiet.com.vn.jdbcweek04www.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcWeek04WwwApplication {
    private EmployeeDAO dao;

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(JdbcWeek04WwwApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo01(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                dao.insert(new Employee(1, "Duong Tuan Kiet"));
                dao.insert(new Employee(2, "Huynh Le Tam Nhu"));
                dao.getAll().forEach(System.out::println);
            }

        };
    }
}
