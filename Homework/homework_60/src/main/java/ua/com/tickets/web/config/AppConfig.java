package ua.com.tickets.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by java on 04.07.2017.
 */
@Configuration
@ImportResource("WEB-INF/applicationContext.xml")
@ComponentScan(basePackages = "ua.com.tickets")
public class AppConfig  extends WebMvcConfigurerAdapter {

}
