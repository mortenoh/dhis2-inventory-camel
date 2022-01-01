package org.hisp.dhis.integration.common.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Valid
@Component
@ConfigurationProperties( "dhis2.inventory" )
public class InventoryProperties
{
    private Map<String, HostProperties> hosts = new HashMap<>();

    private Map<String, List<String>> groups = new HashMap<>();
}
