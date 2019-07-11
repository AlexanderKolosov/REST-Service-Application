/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.model;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;

/*
* Класс создает объект ответа на запрос.
* */
public class JsonRPCResponse {

    private static JSONRPC2Response response;
    private static int jsonRPCResponseId = 0;

    public static void createResponse(String response) {
        JsonRPCResponse.response = new JSONRPC2Response(response, jsonRPCResponseId);
    }

    public static JSONRPC2Response getResponse() {
        return response;
    }

    static void setJsonRPCResponseId(int jsonRPCResponseId) {
        JsonRPCResponse.jsonRPCResponseId = jsonRPCResponseId;
    }
}
