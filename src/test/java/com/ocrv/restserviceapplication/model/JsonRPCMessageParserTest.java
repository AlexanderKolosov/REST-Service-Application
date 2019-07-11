/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.model;

import com.fasterxml.jackson.core.*;
import org.junit.*;

import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonRPCMessageParserTest {

    private static Map<String, Object> paramsForJsonRPCMessage;
    private static String request;
    private static Message message;
    private static Message messageForTest;
    private static JsonFactory jsonFactory;
    private static JsonRPCMessageParser jsonRPCMessageParser;
    private static ModelTestsHelper modelTestsHelper;


    @BeforeClass
    public static void setUp() {
        modelTestsHelper = new ModelTestsHelper();
        message = modelTestsHelper.getMessage();
        paramsForJsonRPCMessage = createParamsForJsonRPCMessage();
        jsonFactory = new JsonFactory();
        jsonRPCMessageParser = new JsonRPCMessageParser();

        request = "{\"method\":\"requestMessage\"," +
                "\"id\":1," +
                "\"params\":" +
                "{\"idSample\":\"76rtw\",\"idLocation\":\"5686.6000\",\"numId\":\"ffg#er111\"," +
                "\"idSignalPar\":\"0xcv11cs\",\"idClassDet\":\"req11\",\"idDetected\":\"Nan\"}," +
                "\"jsonrpc\":\"2.0\"}";
    }

    private static Map<String, Object> createParamsForJsonRPCMessage() {
        paramsForJsonRPCMessage = new HashMap<>();
        modelTestsHelper.setMessageFields(message);
        paramsForJsonRPCMessage.put("1", message);

        return paramsForJsonRPCMessage;
    }

    @Test
    public void invokeSetMessageFieldsMethod() throws IOException {
        jsonRPCMessageParser.setMessageFields(request);
    }

    @Test
    public void testIfParserCorrectlySetsAllFieldsOfTheMessageForTest() throws IOException{
        setFieldsOfMessageForTest();

        assertThat(messageForTest.getIdClassDet()).isEqualTo(message.getIdClassDet());
        assertThat(messageForTest.getIdDetected()).isEqualTo(message.getIdDetected());
        assertThat(messageForTest.getIdLocation()).isEqualTo(message.getIdLocation());
        assertThat(messageForTest.getIdSample()).isEqualTo(message.getIdSample());
        assertThat(messageForTest.getIdSignalPar()).isEqualTo(message.getIdSignalPar());
        assertThat(messageForTest.getNumId()).isEqualTo(message.getNumId());
    }

    private void setFieldsOfMessageForTest() throws IOException {
        JsonParser parser = jsonFactory.createParser(request);
        modelTestsHelper = new ModelTestsHelper();
        messageForTest = modelTestsHelper.getMessage();

        JsonToken token;
        while ((token = parser.nextToken()) != null) {
            if (token.isScalarValue()) {

                String currentName = parser.getCurrentName();
                if (currentName != null) {
                    switch (currentName) {
                        case ("idSample"):
                            messageForTest.setIdSample(parser.getText());
                            break;
                        case ("numId"):
                            messageForTest.setNumId(parser.getText());
                            break;
                        case ("idLocation"):
                            messageForTest.setIdLocation(parser.getText());
                            break;
                        case ("idSignalPar"):
                            messageForTest.setIdSignalPar(parser.getText());
                            break;
                        case ("idDetected"):
                            messageForTest.setIdDetected(parser.getText());
                            break;
                        case ("idClassDet"):
                            messageForTest.setIdClassDet(parser.getText());
                            break;
                    }
                }
            }
        }
    }
}