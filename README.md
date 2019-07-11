Была поставлена задача:

"Необходимо написать REST сервис на вход которого раз в 2 минуты поступает 100 000 сообщений. Протокол обмена rpc-json (по HTTP).
Формат данных:
• id_sample, - идетнификатор предмета(76rtw)
• num_id, -серийный номер предмета(ffg#er111)
• id_location, -место откуда(3211.2334), а может быть(Екатеринбург)
• id_signal_par, -датчик, с которого идет сигнал(0xcv11cs)
• id_detected, - данные о состоянии (None), - исправен,  (Nan), - поломка
• id_class_det, - вид поломки(req11).

В ответе REST сервис выдает агрегированные данные
Агрегировать по id_location, вычисляя:
• Количество событий с поломками
• Количество событий без поломок

Ограничения:
На обработку входящих сообщений отводится до 60 секунд. Чем быстрее тем лучше.
Версия Java не ниже 8й, или Scala.
Нет требований к режимам обработки сообщений. Можно как пакетно, так и потоково.
Допускается использование любого фреймворка. При его использовании по нему тоже могут быть заданы вопросы.
Кроме самой работы большое внимание при проверке будет уделено структуре кода, структуре и оформлению проекта, 
логичному разделению функций, сопровождаемости приложения, наличию комментариев, наличию тестов, соблюдению Java Naming Conventions 
и другим вещам."

Так же, для решения этой задачи написаны клиенты, которые создают соответствующие сообщения и отсылают их на сервер. Они не вложены в данный репозиторий. Если кому-то понадобятся, пишите.
