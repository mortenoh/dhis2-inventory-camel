package org.hisp.dhis.integration.services;

import org.hisp.dhis.integration.common.context.Host;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HostVerifier
{
    public boolean verify( Host host )
    {
        return true;
    }
}
