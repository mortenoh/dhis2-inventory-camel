package org.hisp.dhis.integration.common.properties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Component
@Validated
@ConfigurationProperties( "dhis2" )
public class DhisProperties
{
    @NotNull
    @Valid
    private InventoryProperties inventory;
}
