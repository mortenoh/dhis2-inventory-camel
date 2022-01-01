package org.hisp.dhis.integration.common.context;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Host
{
    private String baseUrl;

    private String username;

    private String password;
}
