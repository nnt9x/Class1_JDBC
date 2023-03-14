package dao;

import connection.MyConnection;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    //Xem, Them, Sua, Xoa

    public List<Person> getAll() {
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối

        List<Person> personList = new ArrayList<>();
        try {
            // BUOC 1
            Connection conn = MyConnection.getConnection();
            // BUOC 2
            String sql = "SELECT * FROM persons";

            // BUOC 3
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Tao doi tuong Person rong
                Person p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));

                personList.add(p);
            }
            // Buoc 4
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return personList;
    }

    public Person getById(long id) {
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối

        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();

            // Buoc 2
            String sql = "SELECT * FROM `persons` WHERE `id` = " + id;
            // Buoc 3
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            Person p = null;
            if (rs.next()) {
                p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
            }
            // Buoc 4: Dong ket noi, tra ve ket qua
            rs.close();
            stmt.close();
            conn.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Person p) {
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối

        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();

            // Buoc 2
            String sql = String.format("INSERT INTO `persons` (`name`,`address`,`phone`,`email`) VALUES ('%s','%s','%s','%s') ",
                    p.getName(), p.getAddress(), p.getPhone(), p.getEmail()
            );

//            System.out.println(sql);

            // Buoc 3
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            // Buoc 4:
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Person p, long id) {
        // id có tồn tại hay ko -> có thì sẽ update cho bản ghi có id trên
        // Check xem id co ton tai
        Person tmp = getById(id);
        if (tmp == null) {
            System.out.println("Cập nhật thất bại do không có id = " + id);
            return;
        }
        // Bươc 1: Tạo kết nối
        // Bước 2: Chuẩn bị câu lệnh
        // Bước 3: Thực thi và xem kết quả
        // Bước 4: Đóng kết nối
        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();
            // Buoc 2
            String sql = String.format("UPDATE `persons` SET `name`='%s', `address`='%s', `phone`='%s', `email`='%s' WHERE `id`= %d",
                    p.getName(), p.getAddress(), p.getPhone(), p.getEmail(), id
            );

            System.out.println(sql);

            // Buoc 3
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối
        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();
            // Buoc 2
            String sql = "DELETE FROM `persons` WHERE id = " + id;
            // Buoc 3
            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
