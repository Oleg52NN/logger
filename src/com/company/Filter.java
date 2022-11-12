package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final int filterBorder;

    public Filter(int filterBorder) {
        this.filterBorder = filterBorder;
    }

    List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.get();
        logger.log("Начинаем фильтрацию");
        int count = 0;
        List<Integer> listF = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > filterBorder) {
                logger.log("Элемент " + "\"" + list.get(i) + "\"" + " проходит ");
                listF.add(list.get(i));
                count++;
            } else {
                logger.log("Элемент " + "\"" + list.get(i) + "\"" + " не проходит ");
            }
        }
        logger.log("Прошли фильтрацию " + count + " эл. из " + list.size());
        logger.log("Выводим результат на экран");
// Если без логирования...
//       List<Integer> listF = list.stream()
//                .filter(w -> w > filterBorder)
//                .collect(Collectors.toList());
        return listF;

    }
}
