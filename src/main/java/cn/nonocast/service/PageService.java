package cn.nonocast.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PageService {
    private Map<String, String> pages = new HashMap<String, String>();

    public Boolean has(String uri) {
        return pages.containsKey(uri);
    }

    public String get(String uri) {
        return pages.get(uri);
    }

    public void put(String uri, String content) {
        pages.put(uri, content);
    }
}
