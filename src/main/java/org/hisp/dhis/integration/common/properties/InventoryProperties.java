package org.hisp.dhis.integration.common.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@Component
@ConfigurationProperties( "dhis2.inventory" )
public class InventoryProperties
{
    /**
     * Should we verify the host availability/credentials on startup.
     */
    private boolean verify;

    private Map<String, HostProperties> hosts = new HashMap<>();

    private Map<String, List<String>> groups = new HashMap<>();
}
