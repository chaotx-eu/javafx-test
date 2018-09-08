package eu.zoho.chaotx.demo.gui.stage;

import eu.zoho.chaotx.demo.gui.view.DemoView;
import eu.zoho.chaotx.demo.logic.DemoText;
import javafx.scene.Scene;

public class MainStage extends DAppStage {
    public MainStage() {
        DemoText dt = new DemoText("Demo");
        DemoView dv = new DemoView(dt);
        dv.prefWidthProperty().bind(widthProperty());
        dv.prefHeightProperty().bind(heightProperty());
        setScene(new Scene(dv));
        setOnShown(e -> dt.start());
        setOnCloseRequest(e -> dt.stop());
    }
}