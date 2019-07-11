/*
 * @date 06/2019
 * @author Колосов Александр
 *
 * (Данный блок заполняется в соответствии со стандартами кампании)
 * */

package com.ocrv.restserviceapplication.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Класс создает агрегированный результат для ответа на запрос.
* */
class AggregatedResultBuilder {

    static void buildAggregatedResult(List<Message> messages){
        Map<String, Map<String, Long>> aggregatedResult = messages.stream()
                .collect(Collectors.groupingBy(Message::getIdLocation,
                        Collectors.groupingBy(Message::getIdDetected,
                                Collectors.counting())));

        JsonRPCResponse.createResponse(aggregatedResult.toString());
    }
}
