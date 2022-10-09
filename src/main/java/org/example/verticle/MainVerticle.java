package org.example.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.openapi.RouterBuilder;
import org.example.apis.WebClientApi;

public class MainVerticle extends AbstractVerticle {

    WebClientApi api = new WebClientApi();

    @Override
    public void start() throws Exception {

        RouterBuilder.create(vertx, "src/main/resources/openapi.yaml")
                .onFailure(Throwable::printStackTrace)
                .onSuccess(routerBuilder -> {
                    routerBuilder
                            .operation("createweb_page")
                            .handler(routingContext -> {
                                api.requestParams(routingContext);
                            });

                    Router router = routerBuilder.createRouter();
                    HttpServer server = vertx.createHttpServer();
                    server
                            .requestHandler(router)
                            .listen(config().getInteger("port"));
                });
    }
}
