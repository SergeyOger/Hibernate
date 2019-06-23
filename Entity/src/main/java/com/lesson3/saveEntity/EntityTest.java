package com.lesson3.saveEntity;

import com.com.lessons.entitys.Employee;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class EntityTest {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //createEmployee(session);
            getEmployeeById(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeById(Session session) {


    }

    private static void createEmployee(Session session) {
        session.beginTransaction();

        // Save entity, will throw an exception if entity already exist in database
        //session.persist(getEmployee1());

        // Save entity, will throw an exception if entity already exist in database.  Return primary key
        Integer employeeId = (Integer) session.save(getEmployee2());

        // Save or update entity
        // session.saveOrUpdate(getEmployee3());

        session.getTransaction().commit();
        System.out.println("Saved employee id " + employeeId);
    }

    private static Employee getEmployee1() {
        Employee employee1 = new Employee();
        employee1.setEmployeeName("Employee name 1");
        employee1.setEmployeeEmail("employee1@gmail.com");
        employee1.setDateOfEmploy(new Date());
        employee1.setSalary(10000.00);
        return employee1;
    }

    private static Employee getEmployee2() {
        Employee employee2 = new Employee();
        employee2.setEmployeeName("Employee name 2");
        employee2.setEmployeeEmail("employee2@gmail.com");
        employee2.setDateOfEmploy(new Date());
        employee2.setSalary(20000.00);
        return employee2;
    }

    private static Employee getEmployee3() {
        Employee employee3 = new Employee();
        employee3.setEmployeeName("Employee name 3");
        employee3.setEmployeeEmail("employee3@gmail.com");
        employee3.setDateOfEmploy(new Date());
        employee3.setSalary(30000.00);
        return employee3;
    }
}
