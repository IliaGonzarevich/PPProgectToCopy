module com.example.jacococonnecting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jacococonnecting to javafx.fxml;
    exports com.example.jacococonnecting;
}