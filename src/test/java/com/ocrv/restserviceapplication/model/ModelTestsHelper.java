/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.model;

class ModelTestsHelper {
    private Message message;

    ModelTestsHelper() {
        message = new Message();
    }

    void setMessageFields(Message message) {
        message.setIdClassDet("req11");
        message.setIdDetected("Nan");
        message.setIdLocation("5686.6000");
        message.setIdSample("76rtw");
        message.setIdSignalPar("0xcv11cs");
        message.setNumId("ffg#er111");
    }

    Message getMessage() {
        return message;
    }
}
