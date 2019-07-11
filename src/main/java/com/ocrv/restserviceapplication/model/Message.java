/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Класс шаблон для объектов Message. Проверяет если установлены значения всем полям объекта Message, добавляет
 * объекты Message в список, проверяет если список содержит необходимое количество (100 000) объектов Message.
 * */
public class Message {

    private static List<Message> messages = new ArrayList<>();

    private String idSignalPar;    // датчик, с которого идет сигнал
    private String idLocation;     // место откуда пришло сообщение
    private String idDetected;     // данные о состоянии (None), - исправен,  (Nan), - поломка
    private String idClassDet;     // вид поломки
    private String idSample;       // идетнификатор предмета
    private String numId;          // серийный номер предмета


    void verifyMessageFields(Message message) {
        if (isMessageReadyToBeAddedToList(message)) {
            addMessageToList(message);
        }
    }

    private boolean isMessageReadyToBeAddedToList(Message message) {
        return message.idSignalPar != null
                && message.idLocation != null
                && message.idClassDet != null
                && message.idDetected != null
                && message.idSample != null
                && message.numId != null;
    }

    private static void addMessageToList(Message message) {
        messages.add(message);

        createNewMessage();
    }

    private static void createNewMessage() {
        JsonRPCMessageParser.message = new Message();

        checkTheMessagesSize();
    }

    private static void checkTheMessagesSize() {
        if (messages.size() == 100000) {
            createNewListOfMessages();
        } else {
            JsonRPCResponse.createResponse("null");
        }
    }

    private static void createNewListOfMessages() {
        AggregatedResultBuilder.buildAggregatedResult(messages);

        messages = new ArrayList<>();
    }

    public void setIdSample(String idSample) {
        this.idSample = idSample;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public void setIdSignalPar(String idSignalPar) {
        this.idSignalPar = idSignalPar;
    }

    public void setIdDetected(String idDetected) {
        this.idDetected = idDetected;
    }

    public void setIdClassDet(String idClassDet) {
        this.idClassDet = idClassDet;
    }

    String getIdLocation() {
        return idLocation;
    }

    String getIdDetected() {
        return idDetected;
    }

    String getIdSample() {
        return idSample;
    }

    String getNumId() {
        return numId;
    }

    String getIdSignalPar() {
        return idSignalPar;
    }

    String getIdClassDet() {
        return idClassDet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;

        return Objects.equals(idSample, message.idSample)
                && Objects.equals(numId, message.numId)
                && Objects.equals(idLocation, message.idLocation)
                && Objects.equals(idSignalPar, message.idSignalPar)
                && Objects.equals(idDetected, message.idDetected)
                && Objects.equals(idClassDet, message.idClassDet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSample, numId, idLocation, idSignalPar, idDetected, idClassDet);
    }
}