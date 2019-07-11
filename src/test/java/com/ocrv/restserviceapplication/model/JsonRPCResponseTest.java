/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonRPCResponseTest {

    @Test
    public void testResponseCreating() {
        JsonRPCResponse.createResponse("anyString");

        assertThat(JsonRPCResponse.getResponse()).isNotNull();
    }
}