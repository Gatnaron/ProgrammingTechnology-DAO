module com.example.lab8adao {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires java.sql;
    requires lombok;
    requires java.naming;

    opens com.example.lab8adao to javafx.fxml;
    exports com.example.lab8adao;
}