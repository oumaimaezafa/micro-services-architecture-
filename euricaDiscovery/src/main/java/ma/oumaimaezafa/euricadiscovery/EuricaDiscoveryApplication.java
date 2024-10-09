package ma.oumaimaezafa.euricadiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EuricaDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EuricaDiscoveryApplication.class, args);
    }

}
