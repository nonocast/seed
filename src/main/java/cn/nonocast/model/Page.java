package cn.nonocast.model;

import org.springframework.stereotype.Component;

@Component
public class Page {
    private String uri;
    private String content;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
