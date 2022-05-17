package com.planetpope;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "quarkus.application.version")
    String version;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        StringBuilder sb = new StringBuilder();

        sb.append("Version:\r\n");
        sb.append("*".repeat(50) + "\r\n");
        sb.append("version = " + version + "\r\n");
        sb.append("*".repeat(50) + "\r\n");
        sb.append("\r\n");

        Map<String,String> map = System.getenv();
        SortedSet<String> keys = new TreeSet<>(map.keySet());
        sb.append("Environment Variables:\r\n");
        sb.append("*".repeat(50) + "\r\n");
        for(String key:keys) {
            sb.append(key + " = " + map.get(key) + "\r\n");
        }
        sb.append("*".repeat(50) + "\r\n");
        return sb.toString();
    }
}
