package eu.zoho.chaotx.demo;

import eu.zoho.chaotx.demo.gui.stage.MainStage;
import javafx.application.*;
import javafx.stage.*;

public class DemoFX extends Application {
    @Override
    public void init() {
        // TODO init ressources etc.
    }

    @Override
    public void stop() {
        // TODO free ressources etc.
    }

    @Override
    public void start(Stage ps) {
        ps = new MainStage();
        ps.show();
    }
}