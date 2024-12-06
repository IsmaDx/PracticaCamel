package mx.com.ids.camelpractica;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.RuntimeCamelException;
public class MyRouteBuilder2 extends RouteBuilder {
    @Override
    public void configure () throws Exception
    {
        from("timer:MyTimer?period=1s")
        .log("Hola mundo");

        from("timer:MyTimer?period=3s")
                .log("Hola mundo desde otro timer...");

        from("direct:ruta1")
                .log("Procesando ruta 1").end();

        from("timer:MyTimer?period=4s")
                .log("Hola mundo desde otro timer...")
                .to("direct:ruta1")
                .end();




    }
}
