package eu.zoho.chaotx.demo.logic;

import javafx.beans.property.*;

public class DemoText {
    public static final double PPS = 1.0; // pixel per step

    private long sps; // steps per second
    private Thread thread;
    private StringProperty text;
    private DoubleProperty x, y, width, height;

    public DemoText(String screen_text) {
        text = new SimpleStringProperty(screen_text);
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        width = new SimpleDoubleProperty(Double.MAX_VALUE);
        height = new SimpleDoubleProperty(Double.MAX_VALUE);
        setSpeed(500);
    }

    public void setSpeed(long steps_per_second) {
        sps = steps_per_second;
    }

    public void setText(String text) {
        textProperty().set(text);
    }

    public String getText() {
        return textProperty().get();
    }

    public StringProperty textProperty() {
        return text;
    }
    
    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public DoubleProperty heightProperty() {
        return height;
    }
    
    public synchronized void start() {
        stop();

        thread = new Thread(() -> {
            int[] v = {40, -10};
            double lambda, new_x, new_y;

            try { while(!thread.isInterrupted()) {
                Thread.sleep(1000/sps);
                lambda = PPS/Math.sqrt(v[0]*v[0] + v[1]*v[1]);
                new_x = x.add(lambda*v[0]).get();
                new_y = y.add(lambda*v[1]).get();

                if(new_x < 0 || new_x > width.get()) v[0] *= -1;
                else if(new_y < 0 || new_y > height.get()) v[1] *= -1;

                x.set(x.add(lambda*v[0]).get());
                y.set(y.add(lambda*v[1]).get());

                //System.out.println(v[0] + ", " + v[1] + ", " + x.get() + ", " + y.get());
            }} catch(InterruptedException e) { return; }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void stop() {
        if(thread != null)
            thread.interrupt();
    }
}