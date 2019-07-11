/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.controller;

import com.ocrv.restserviceapplication.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;

/*
 * Класс-сервлет.
 * Принимает запрос и возвращает ответ.
 *
 * Замеры скорости процесса отправки-приема сообщения, осуществления событийного парсинга и рассчет агрегированного
 * результата показали, что полное время находилось в пределах 2-4 секунд.
 * */
@WebServlet
public class JsonRPCMessageController extends HttpServlet {

    @Override
    protected void doPost(
        final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String request = req.getReader().lines().collect(Collectors.joining());
        JsonRPCMessageParser jsonRpcMessageParser = new JsonRPCMessageParser();
        jsonRpcMessageParser.setMessageFields(request);

        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().println(JsonRPCResponse.getResponse());
    }


}


