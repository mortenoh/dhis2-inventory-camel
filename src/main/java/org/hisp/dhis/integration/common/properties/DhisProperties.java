package org.hisp.dhis.integration.common.properties;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( "dhis2" )
public class DhisProperties
{
    @NotNull
    private InventoryProperties inventory;
}
