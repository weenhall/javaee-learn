package com.ween.webservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wen on 2018/4/8
 */
public class PersonServiceImpl implements PersonService {
    public Person getPerson(String name) {
        Person p = new Person();
        p.setName(name);
        p.setAge(100);
        return p;
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName("wpx");
        p1.setAge(100);
        persons.add(p1);
        Person p2 = new Person();
        p2.setName("zlr");
        p2.setAge(100);
        persons.add(p2);
        return persons;
    }
}
