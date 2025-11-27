package org.mitocode.platform.infrastructure.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "mitocode.notification")
public interface AppConfigProperties {
    String title();
    String description();
}
