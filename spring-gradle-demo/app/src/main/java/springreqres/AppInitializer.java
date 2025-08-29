package springreqres;

import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.File;

public class AppInitializer {
    public static void main(String[] args) throws Exception {
        // Create Spring context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // Create DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Start embedded Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // This is IMPORTANT: force connector creation
        tomcat.getConnector();

        // Temp dir for Tomcat
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));

        // Add web app
        var ctx = tomcat.addContext("", new File(".").getAbsolutePath());

        // Register servlet
        Tomcat.addServlet(ctx, "dispatcher", dispatcherServlet).setLoadOnStartup(1);
        ctx.addServletMappingDecoded("/", "dispatcher");

        // Start server
        tomcat.start();
        tomcat.getServer().await();
    }
}
