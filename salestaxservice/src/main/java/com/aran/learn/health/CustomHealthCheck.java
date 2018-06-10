package com.aran.learn.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class CustomHealthCheck implements HealthIndicator {

    public Health health() {
        if (isRemoteServiceUp()) {
            return Health.up().withDetail("remote service", "online").build();
        } else {
            return Health.up().withDetail("remote service", "offline").build();
        }
    }

    private boolean isRemoteServiceUp() {
        return true;
    }
}
