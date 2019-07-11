/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.server;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import org.junit.*;

import java.net.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JettyServerRunTest {

    private Server server;

    @Before
    public void startJetty() throws Exception
    {
        server = new Server(9129);

        ServletContextHandler context = new ServletContextHandler();

        ServletHolder defaultServ = new ServletHolder("default", DefaultServlet.class);
        defaultServ.setInitParameter("resourceBase",System.getProperty("user.dir"));
        defaultServ.setInitParameter("dirAllowed","true");

        context.addServlet(defaultServ,"/");

        server.setHandler(context);

        server.start();
    }

    @After
    public void stopJetty()
    {
        try
        {
            server.stop();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoPost() throws Exception
    {
        HttpURLConnection http = (HttpURLConnection)new URL("http://localhost:9129/")
                .openConnection();
        http.connect();
        assertThat("Response Code", http.getResponseCode(), is(HttpStatus.OK_200));
    }

    @Test(expected = Exception.class)
    public void testDoPostWithWrongPort() throws Exception
    {
        HttpURLConnection http = (HttpURLConnection)new URL("http://localhost:8080/")
                .openConnection();
        http.connect();
        assertThat("Response Code", http.getResponseCode(), is(HttpStatus.OK_200));
    }
}