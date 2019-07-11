/*
 * @date 05/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.Servlet;

/*
* Класс создает и запускает сервер
* */
public class JettyServer {

    public static void run(final Class<? extends Servlet> servlet) {
        final Server server = new Server(9129);
        final ServletHandler servletHandler = new ServletHandler();

        servletHandler.addServletWithMapping(servlet, "");

        server.setHandler(servletHandler);
        try {
            server.dumpStdErr();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
