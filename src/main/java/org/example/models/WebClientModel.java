package org.example.models;

public class WebClientModel {

    private String host;
    private int port;
    private boolean ssl;
    private String uri;

    public WebClientModel(String host, int port, boolean ssl, String uri) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.uri = uri;
    }

    public WebClientModel() {

    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
