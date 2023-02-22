import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class Main extends Application{

    List<String> imgList = new ArrayList<>();
    Button leftBtn = new Button("Right");
    Button rightBtn = new Button("Left");
    
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        
        imgList.add("img/1.jpg");
        imgList.add("img/1.jpg");
        imgList.add("img/1.jpg");
        
        Image image[] = new Image[imgList.size()];
        ImageView imageView[] = new ImageView[imgList.size()];

        for(int i = 0; i < imgList.size(); i++){
            image[i] = new Image(imgList.get(i));
            imageView[i] = new ImageView(image[i]);
        }

        HBox root = new HBox();
        
        for(int i = 0; i < imgList.size(); i++){
            root.getChildren().addAll(imageView[i]);
        }

        root.setAlignment(Pos.CENTER);

            
        for(int i = 0; i < 3; i++){
            imageView[i].setTranslateX(225);
            System.out.println(i + " - posisi awal : " +imageView[i].getTranslateX());
        }


        System.out.println(image[0].getWidth());

        Scene scene = new Scene(root,235,225);
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                for(int i = 0; i < 3; i++){
                    imageView[i].setTranslateX(event.getSceneX());
                    System.out.println(imageView[i].getTranslateX());

                    if(imageView[i].getTranslateX() == -225){
                        imageView[i].setTranslateX(675);
                    }
                }
            }
            
        });


        stage.setScene(scene);
        stage.show();
    }
}