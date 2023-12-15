package Seminar6_Attestation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// слегка переделанная задача 5го семинара :\
public class Phonebook {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String lastName) {
        map.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNum);
    }

    String getByPhoneNumber(String phoneNum) {
        for (var entry : map.entrySet()) {
            if (entry.getValue().contains(phoneNum)) {
                return entry.getKey() + " : " + phoneNum;
            }
        }
        return "Номер телефона не найден.";
    }

    String getByLastName(String lastName) {
        if (map.containsKey(lastName)) {
            return lastName + " : " + map.get(lastName);
        } else {
            return "ФИ не найдено.";
        }
    }

    String getAll() {
        return map.toString();
    }
}
