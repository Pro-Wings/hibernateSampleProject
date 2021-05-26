package com.prowings;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Bloch");
        student.setContactNo("123456789");

//        Student student = new Student();
//        student.setFirstName("Linus1");
//        student.setLastName("Torwards1");
//        student.setContactNo("123456789");

        Student student1 = new Student();
        student1.setFirstName("Barry");
        student1.setLastName("Gates");
        student1.setContactNo("987654321");

        session.save(student);
        session.save(student1);
        session.getTransaction().commit();

        System.out.println("Fetching stored student records :: ");
        Query<Student> q = session.createQuery("From Student", Student.class);
        List<Student> resultList = q.list();
        System.out.println("total sudents:" + resultList.size());

        for (Student s : resultList) {
            System.out.println("student : " + s);
        }

        HibernateUtil.close();
    }
}