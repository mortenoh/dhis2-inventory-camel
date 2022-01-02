package org.hisp.dhis.integration;

import org.hisp.dhis.integration.common.context.DhisContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner
{
    private final DhisContext context;

    public static void main( String[] args )
    {
        SpringApplication.run( Application.class, args );
    }

    @Override
    public void run( String... args )
    {
        log.info( "Context: " + context );
    }
}
