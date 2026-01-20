package it.unibg.accessibilita;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Theme(value = "default")
@ComponentScan(basePackages = {
	    "it.unibg.accessibilita",       
	    "Accessibilita.AccessiBG_sqlite" 
	})
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
