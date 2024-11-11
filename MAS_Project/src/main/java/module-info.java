module pl.pjatk.mas.s24512.masproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires mssql.jdbc;

    exports pl.pjatk.mas.s24512.masproject;
    opens pl.pjatk.mas.s24512.masproject to javafx.fxml;
//    exports pl.pjatk.mas.s24512.masproject.Utils;
//    opens pl.pjatk.mas.s24512.masproject.Utils to javafx.fxml;
}