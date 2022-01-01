package org.hisp.dhis.integration;

import org.hisp.dhis.integration.common.context.DhisContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
@EnableConfigurationProperties
public class Application implements CommandLineRunner
{
    @Autowired
    private DhisContext context;

    public static void main( String[] args )
    {
        SpringApplication.run( Application.class, args );
    }

    @Override
    public void run( String... args )
        throws Exception
    {
        log.info( "Context: " + context );
    }
}
