package eu.zoho.chaotx.demo.gui.view;


import eu.zoho.chaotx.demo.logic.DemoText;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

public class DemoView extends Region {
    public DemoView(DemoText demoText) {
        Text text = new Text();
        // https://docs.oracle.com/javafx/2/text/jfxpub-text.htm
        text.setFont(Font.font("Verdana", FontPosture.ITALIC, 50));
        text.textProperty().bind(demoText.textProperty());
        text.xProperty().bind(demoText.xProperty());
        text.yProperty().bind(demoText.yProperty().add(text.getFont().getSize()));
        
        demoText.xProperty().set(100);
        demoText.yProperty().set(100);
        demoText.widthProperty().bind(widthProperty()
            .subtract((demoText
                .textProperty()
                .length().get()-1)*text.getFont().getSize()));
        demoText.heightProperty().bind(heightProperty().subtract(text.getFont().getSize()));

        getChildren().add(text);
        setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
    }
}