package org.hisp.dhis.integration.common;

import java.util.ArrayList;

import org.hisp.dhis.integration.common.context.DhisContext;
import org.hisp.dhis.integration.common.context.Host;
import org.hisp.dhis.integration.common.properties.DhisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DhisConfiguration
{
    private final DhisProperties dhisProperties;

    public DhisConfiguration( DhisProperties dhisProperties )
    {
        this.dhisProperties = dhisProperties;
    }

    @Bean
    public DhisContext getDhisContext()
    {
        DhisContext ctx = new DhisContext();

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

        return ctx;
    }
}
