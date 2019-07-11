/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.model;

import com.fasterxml.jackson.core.*;

import java.io.IOException;


/*
* Класс парсит строковое представление полученного в формате JSON-RPC 2.0 сообщения, создает объекты Message и
* устанавливает значения их полей.
*/
public class JsonRPCMessageParser {

    static Message message = new Message();

    private final JsonFactory jsonFactory = new JsonFactory();

    public void setMessageFields(final String request) throws IOException {
        final JsonParser parser = jsonFactory.createParser(request);

        JsonToken token;
        while ((token = parser.nextToken()) != null) {
            if (token.isScalarValue()) {

                String currentName = parser.getCurrentName();
                if (currentName != null) {
                    switch (currentName) {
                        case ("idSample"):
                            message.setIdSample(parser.getText());
                            break;
                        case ("numId"):
                            message.setNumId(parser.getText());
                            break;
                        case ("idLocation"):
                            message.setIdLocation(parser.getText());
                            break;
                        case ("idSignalPar"):
                            message.setIdSignalPar(parser.getText());
                            break;
                        case ("idDetected"):
                            message.setIdDetected(parser.getText());
                            break;
                        case ("idClassDet"):
                            message.setIdClassDet(parser.getText());
                            break;
                        case ("id"):
                            int id = Integer.parseInt(parser.getText());
                            JsonRPCResponse.setJsonRPCResponseId(id);
                            break;
                    }
                    message.verifyMessageFields(message);
                }
            }
        }
    }
}
