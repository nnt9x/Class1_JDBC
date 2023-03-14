import dao.PersonDAO;
import model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Lay ra toan bo nguoi
        List<Person> list = personDAO.getAll();
        System.out.println(list);
        Person p1 = new Person("Nguyen Van A","BKACAD","0292929","abc@gmail.com");

        personDAO.insert(p1);

        // Nhap id -> neu tim thay => in ra nguoi do
        // Neu ko thay -> ko co
//        Scanner in = new Scanner(System.in);
//
//        Person tmp = new Person();
//
//        System.out.print("Nhap id nguoi can cap nhat: ");
//        long id = Long.parseLong(in.nextLine());
//        System.out.print("Nhap ten: ");
//        tmp.setName(in.nextLine());
//        System.out.print("Nhap dia chi: ");
//        tmp.setAddress(in.nextLine());
//        System.out.print("Nhap sdt: ");
//        tmp.setPhone(in.nextLine());
//        System.out.print("Nhap email: ");
//        tmp.setEmail(in.nextLine());
//        in.close();
//
//        personDAO.update(tmp, id);
    }
}
