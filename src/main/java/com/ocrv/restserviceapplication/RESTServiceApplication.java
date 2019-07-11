/*
 * @application Приложение REST сервис. Предназначено для получения сообщений в формате JSON-RPC 2.0, осуществляет их
 * событийный парсинг, создает объекты сообщений, формирует агрегированный результат и возвращает его в формате
 * JSON-RPC 2.0.
 *
 * @date 05/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication;

import com.ocrv.restserviceapplication.controller.JsonRPCMessageController;
import com.ocrv.restserviceapplication.server.JettyServer;

/*
* Класс стартует работу REST сервиса
* */
public class RESTServiceApplication {

    public static void main(String[] args) {
        JettyServer.run(JsonRPCMessageController.class);
    }
}
