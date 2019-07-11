/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами компании)
 * */

package com.ocrv.restserviceapplication.model;

import org.junit.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregatedResultBuilderTest {

    private List<Message> messages;

    @Before
    public void setUp() {
        ModelTestsHelper modelTestsHelper = new ModelTestsHelper();
        Message message = modelTestsHelper.getMessage();
        messages = new ArrayList<>();

        modelTestsHelper.setMessageFields(message);
        messages.add(message);
    }

    @Test
    public void testAggregatedResultBuilding() {
        Map<String, Map<String, Long>> aggregatedResult = messages.stream()
                .collect(Collectors.groupingBy(Message::getIdLocation,
                        Collectors.groupingBy(Message::getIdDetected,
                                Collectors.counting())));

        String expected = "{5686.6000={Nan=1}}";
        String actual = aggregatedResult.toString();

        assertThat(actual).isEqualTo(expected);
    }

}