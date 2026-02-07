package com.valentino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
@StyleSheet("styles.css")
public class ValentinoApplication implements AppShellConfigurator {

    void main() {
        SpringApplication.run(ValentinoApplication.class);
    }
}
