package com.example.jacococonnecting;

import javafx.fxml.FXML;

public class FirstController {

    @FXML
    protected void showWindow() throws Exception {
            Second second = new Second();
            second.showWindow();
    }
}
