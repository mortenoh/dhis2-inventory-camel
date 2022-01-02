package org.hisp.dhis.integration.common;

import java.util.ArrayList;

import org.hisp.dhis.integration.common.context.DhisContext;
import org.hisp.dhis.integration.common.context.Host;
import org.hisp.dhis.integration.common.properties.DhisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class DhisConfiguration
{
    private final DhisProperties dhisProperties;

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public DhisContext getDhisContext()
        throws Exception
    {
        DhisContext ctx = new DhisContext();
        log.info( "Properties: " + dhisProperties );

        dhisProperties.getInventory().getHosts().forEach( ( k, v ) -> {
            // TODO add ctx.addHost(..) shortcut
            Host host = Host.builder()
                .type( v.getType() )
                .baseUrl( v.getBaseUrl() )
                .username( v.getUsername() )
                .password( v.getPassword() )
                .build();

            ctx.getHosts().put( k, host );
        } );

        dhisProperties.getInventory().getGroups().forEach( ( k, v ) -> {
            // TODO add ctx.addGroup(..) shortcut
            if ( !ctx.getGroups().containsKey( k ) )
            {
                ctx.getGroups().put( k, new ArrayList<>() );
            }

            v.forEach( h -> {
                ctx.getGroups().get( k ).add( ctx.getHosts().get( h ) );
            } );
        } );

        if ( dhisProperties.getInventory().isVerify() )
        {
            ctx.getHosts().values().forEach( this::verifyHost );
        }

        return ctx;
    }

    // --------------------------------------------------------------------------------------------
    // Helpers
    // --------------------------------------------------------------------------------------------

    private void verifyHost( Host host )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set( "Content-Type", MediaType.APPLICATION_JSON_VALUE );
        headers.set( "Accept", MediaType.APPLICATION_JSON_VALUE );
        headers.set( "Authorization", host.getAuthorizationHeader() );

        UriComponents uriComponents = UriComponentsBuilder.fromUriString( "{server}/api/system/info" )
            .buildAndExpand( host.getBaseUrl() )
            .encode();

        ResponseEntity<SystemInfo> response = restTemplate().exchange( uriComponents.toUri(),
            HttpMethod.GET, new HttpEntity<>( headers ), SystemInfo.class );

        System.err.println( response.getBody() );
    }
}

@Data
class SystemInfo
{
    private String instanceBaseUrl;

    private String version;

    private String revision;

    private String systemId;

    private String systemName;

    private String serverTimeZoneId;
}
