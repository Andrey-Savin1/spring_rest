package ru.savin.spring.rest.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.savin.spring.rest.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public List<Employee> getAllEmployees() {


        Session session = sessionFactory.getCurrentSession();
        // 1 вариант
//        List<Employee> allEmployees = session.createQuery(
//                "from Employee", Employee.class).getResultList();

        //2 вариант

        Query<Employee> query = session.createQuery(
                "from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getAllEmployees(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);


          return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}