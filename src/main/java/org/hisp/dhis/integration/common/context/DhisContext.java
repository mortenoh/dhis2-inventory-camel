package org.hisp.dhis.integration.common.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DhisContext
{
    private Map<String, Host> hosts = new HashMap<>();

    private Map<String, List<Host>> groups = new HashMap<>();

    private Source source = new Source();

    private Destination destination = new Destination();
}

@Data
class Source
{
    private Host source;

    private List<Host> sources;
}

@Data
class Destination
{
    private Host destination;

    private List<Host> destinations;
}