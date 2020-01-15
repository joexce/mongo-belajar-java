package Home;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.kafka.annotation.KafkaListener;
@SpringBootApplication
public class MainApp {
    public static void main(String[] args){
            SpringApplication.run(MainApp.class, args);
        }


    @KafkaListener(id = "kafka", topics = "pesan-saya")
    public void dltListen(String in) {
        System.out.println("Data yang ditarik : " + in);
    }
}
