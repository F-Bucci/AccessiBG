package it.unibg.accessibilita;

import com.vaadin.flow.component.page.AppShellConfigurator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"it.unibg.accessibilita",
	    "gestione_db",
	    "dao",
	    "struttura"
})
/**
 * Punto di ingresso principale dell'applicazione Spring Boot.
 */
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
