package org.hisp.dhis.integration.common.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Component
@Validated
@ConfigurationProperties( "dhis2.source" )
public class SourceProperties
{
    private List<String> host;

    private List<String> hosts;

    private Map<String, ?> properties = new HashMap<>();
}
