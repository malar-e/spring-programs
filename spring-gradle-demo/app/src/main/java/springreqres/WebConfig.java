package springreqres;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("springreqres")
public class WebConfig {
    // Can add ViewResolvers, etc. if needed
}
