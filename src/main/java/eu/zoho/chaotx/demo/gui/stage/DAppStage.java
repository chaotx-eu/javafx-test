package eu.zoho.chaotx.demo.gui.stage;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DAppStage extends Stage {
    public static final String DEFAULT_TITLE = "Demo Desktop Application";

    public DAppStage() {
        this(DEFAULT_TITLE);
    }

    public DAppStage(String title) {
        setTitle(title);
        setMaximized(true);
        setResizable(false);
        initStyle(StageStyle.DECORATED);
    }
}