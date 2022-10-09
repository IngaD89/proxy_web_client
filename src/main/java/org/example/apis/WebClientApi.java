package org.example.apis;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.ValidationHandler;
import org.example.models.WebClientModel;
import org.example.services.WebClientServices;

public class WebClientApi {

    WebClientModel client = new WebClientModel();
    WebClientServices webService = new WebClientServices();

    public void requestParams(RoutingContext routingContext) {


        RequestParameters params =
                routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);
        RequestParameter body = params.body();

        client.setHost(body.getJsonObject().getString("host"));
        client.setPort(body.getJsonObject().getInteger("port"));
        client.setSsl(body.getJsonObject().getBoolean("ssl"));
        client.setUri(body.getJsonObject().getString("uri"));


        routingContext.response().setChunked(true);
        webService.service(client, routingContext.response());
    }


}