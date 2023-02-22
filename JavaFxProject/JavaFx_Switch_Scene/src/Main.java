import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        
        Button btn1 = new Button("Scene2");
        Button btn2 = new Button("Scene1"); 
        Label lblScene1 = new Label("Scene 1");
        Label lblScene2 = new Label("Scene 2");

        BorderPane box1 = new BorderPane();
        box1.setCenter(btn1);
        box1.setTop(lblScene1);

        BorderPane box2 = new BorderPane();
        box2.setCenter(btn2);
        box2.setTop(lblScene2);

        BorderPane.setAlignment(lblScene1, Pos.CENTER);
        BorderPane.setAlignment(lblScene2, Pos.CENTER);
        
        lblScene1.setStyle("-fx-font-size: 30; -fx-font-weight: 900;");
        lblScene2.setStyle("-fx-font-size: 30; -fx-font-weight: 900;");

        BorderPane.setMargin(lblScene1, new Insets(100,0,0,0));
        BorderPane.setMargin(lblScene2, new Insets(100,0,0,0));


        Scene scene2 = new Scene(box2,500,500);
        Scene scene1 = new Scene(box1,500,500);


        btn1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                stage.setScene(scene2);
                System.out.println("load scene 2");
            }
            
        });

        btn2.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                stage.setScene(scene1);
                System.out.println("load scene 1");
            }
            
        });


        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}