module frontend {
    requires javafx.controls;
    requires javafx.fxml;

    opens frontend to javafx.fxml;

    exports frontend;

    opens frontend.View to javafx.graphics;
    opens frontend.View.Controllers to javafx.graphics, javafx.fxml;
}
