package it.unibg.accessibilita;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Theme(value = "default")
@ComponentScan(basePackages = {
	    "it.unibg.accessibilita",       // Il package del tuo Frontend
	    "Accessibilita.AccessiBG_sqlite" // Il package del tuo Backend
	})
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
