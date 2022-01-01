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
}
