package us.codecraft.tinyioc.beans.io;

import java.net.URL;

/**
 * @author String location -> URL resource -> UrlResource urlResource(URL)
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
