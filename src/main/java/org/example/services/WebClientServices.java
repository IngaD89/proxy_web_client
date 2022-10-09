package org.example.services;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.WriteStream;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import org.example.models.WebClientModel;


public class WebClientServices {

    Vertx vertx = Vertx.vertx();


    public void service(WebClientModel client, WriteStream<Buffer> writeStream) {


        WebClient webClient = WebClient.create(vertx);

                webClient
                        .get(client.getPort(), client.getHost(), client.getUri())
                        .ssl(client.isSsl())
                        .putHeader("content-type", "application/octet-stream")
                        .as(BodyCodec.pipe(writeStream))
                        .send()
                        .onFailure(Throwable::printStackTrace);
            }
            

    }

