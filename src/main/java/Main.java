import dao.PersonDAO;
import model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Lay ra toan bo nguoi
        List<Person> list = personDAO.getAll();
        System.out.println(list);
        // Them 1 nguoi vao database
        Person p = new Person();
        p.setName("Nguyen Van B");
        p.setAddress("HN");
        p.setEmail("bcd@gmai.com");
        p.setPhone("123837383");

        personDAO.insert(p);
    }
}
