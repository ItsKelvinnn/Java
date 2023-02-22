// Hover Effect JavaFx
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Rectangle reg = new Rectangle(100,100,Color.BLACK);
        VBox root = new VBox(reg);
        
        RotateTransition rtEnter = new RotateTransition();

        root.setAlignment(Pos.CENTER);
        reg.addEventFilter(MouseEvent.MOUSE_ENTERED,new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                rtEnter.setNode(reg);
                rtEnter.setDuration(Duration.seconds(1));
                rtEnter.setToAngle(360);
                rtEnter.setAutoReverse(true);

                rtEnter.setInterpolator(Interpolator.EASE_IN);
                rtEnter.play();
            }
            
        });

        RotateTransition rtExit = new RotateTransition();   

        reg.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET,new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {

                rtExit.setNode(reg);
                rtExit.setDuration(rtEnter.getCurrentTime());
                rtExit.setToAngle(0);


                rtExit.setInterpolator(Interpolator.EASE_IN);
                rtEnter.stop();
                rtExit.play();
            }
            
        });

        Scene scene = new Scene(root,500,500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}