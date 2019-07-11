/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.model;

import org.junit.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

    private static List<Message> messages;

    private static Message message;

    private static ModelTestsHelper modelTestsHelper;

    @BeforeClass
    public static void setUp() {
        modelTestsHelper = new ModelTestsHelper();
        message = modelTestsHelper.getMessage();
        messages = new ArrayList<>();
    }

    @Test
    public void invokeVerifyMessageFieldsMethod() {
        message.verifyMessageFields(new Message());
    }

    @Test
    public void checkIfMessageIsReadyToBeAddedToList() {
        modelTestsHelper.setMessageFields(message);

        assertThat(message.getIdClassDet()).isNotNull();
        assertThat(message.getIdDetected()).isNotNull();
        assertThat(message.getIdLocation()).isNotNull();
        assertThat(message.getIdSample()).isNotNull();
        assertThat(message.getIdSignalPar()).isNotNull();
        assertThat(message.getNumId()).isNotNull();
    }

    @Test
    public void checkIfMessagesIsEmpty() {
        assertThat(messages).isEmpty();
    }

    @Test
    public void testAdditionOfNewMessageToTheMessages() {
        messages.add(message);

        assertThat(messages).isNotEmpty();

        checkTheMessagesSize();
    }

    private void checkTheMessagesSize() {
        assertThat(messages.size()).isEqualTo(1);
    }

    @Test
    public void testCreatingNewMessage() {
        message = new Message();

        assertThat(message.getIdClassDet()).isNull();
        assertThat(message.getIdDetected()).isNull();
        assertThat(message.getIdLocation()).isNull();
        assertThat(message.getIdSample()).isNull();
        assertThat(message.getIdSignalPar()).isNull();
        assertThat(message.getNumId()).isNull();
    }

    @Test
    public void testCreatingNewMessages() {
        messages = new ArrayList<>();

        assertThat(messages).isEmpty();
    }
}