package org.hisp.dhis.integration.common.context;

import java.util.Base64;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Host
{
    @NonNull
    private String type; // TODO add enum?

    @NonNull
    private String baseUrl;

    @NonNull
    private String username;

    @NonNull
    private String password;

    public String getAuthorizationHeader()
    {
        return "Basic " + Base64.getEncoder().encodeToString( (username + ":" + password).getBytes() );
    }
}
