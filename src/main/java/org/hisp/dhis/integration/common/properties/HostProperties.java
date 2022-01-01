package org.hisp.dhis.integration.common.properties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Valid
public class HostProperties
{
    @NotNull
    private String type;

    @NotNull
    private String baseUrl;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
