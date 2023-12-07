package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

           Person person = new Person("Test Hibernate",20);
           Item item = new Item("Test Hibernate",person);

           person.setItems(new ArrayList<>(Collections.singletonList(item)));

           session.persist(person);
           session.persist(item);

            session.getTransaction().commit();
        }

    }
}