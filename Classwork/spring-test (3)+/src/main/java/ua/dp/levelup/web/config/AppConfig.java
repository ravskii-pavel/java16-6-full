package ua.dp.levelup.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by java on 04.07.2017.
 */
@EnableWebMvc
@Configuration
@ImportResource(locations = "WEB-INF/applicationContext.xml")
public class AppConfig {

}
