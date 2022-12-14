package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.System.out;

public class GuiElementBox {

    private Image imageUp = null;
    private Image imageDown = null;
    private Image imageRight = null;
    private Image imageLeft = null;
    private Image imageGrass = null;

    public GuiElementBox() {
        try {
            this.imageUp = new Image(new FileInputStream("src/main/resources/up.png"));
            this.imageDown = new Image(new FileInputStream("src/main/resources/down.png"));
            this.imageRight = new Image(new FileInputStream("src/main/resources/right.png"));
            this.imageLeft = new Image(new FileInputStream("src/main/resources/left.png"));
            this.imageGrass = new Image(new FileInputStream("src/main/resources/grass.png"));
        } catch(FileNotFoundException error) {
            out.println("File not found or file could not load" + error);
        }
    }

    public VBox showElement(IMapElement element) {
        Label label = new Label(element.getPosition().toString());
        ImageView imageView;
        if(element instanceof Animal) {
            imageView = switch (((Animal) element).getDirectionOnMap()) {
                case EAST -> new ImageView(imageRight);
                case WEST -> new ImageView(imageLeft);
                case NORTH -> new ImageView(imageUp);
                case SOUTH -> new ImageView(imageDown);
            };
        } else {
            imageView = new ImageView(imageGrass);
        }
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        VBox verticalBox = new VBox(imageView, label);
        verticalBox.setAlignment(Pos.CENTER);
        return verticalBox;
    }
}