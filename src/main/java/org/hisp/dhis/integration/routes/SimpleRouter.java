package org.hisp.dhis.integration.routes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouter extends RouteBuilder
{
    @Override
    public void configure()
    {
        Integer repeatCount = 1;
        String time = LocalDateTime.now().plusSeconds( 5 ).format( DateTimeFormatter.ISO_DATE_TIME );

        from( String.format( "timer:foo?repeatCount=%d&time=%s", repeatCount, time ) ).log( "bar" );
    }
}
