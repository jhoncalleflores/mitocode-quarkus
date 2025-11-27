package org.mitocode.platform.infrastructure.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Slf4j
@ApplicationScoped
public class StartUpLogger {
    @Inject
    AppConfigProperties configProperties;

    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8080")
    int port;

    @ConfigProperty(name = "quarkus.application.name", defaultValue = "jhon-platform")
    String appName;

    void onStart(@Observes StartupEvent event) {
        log.info("\uD83D\uDE80 Aplicacion Quarkus {} iniciada correctamente en el puerto {}!", port, appName);
        log.info("Cargando modulos: Kafka, Panache Reactive, REST, etc...");
        log.info("Saludos, les entrego la notificacion cuyo titulo es {} y descripcion es {}", configProperties.title(), configProperties.description());
    }
}
