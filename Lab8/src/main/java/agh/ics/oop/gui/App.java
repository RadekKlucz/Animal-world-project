package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application implements IMapUpdateObserver {
    private IWorldMap map;
    private final GridPane grid = new GridPane();
    private IEngine engine;
    private GuiElementBox elementCreator;
    private int cellSize;

    @Override
    public void init() {
        this.map = new GrassField(20);
        int moveDelay = 300;
        List<Vector2d> positions = new ArrayList<>(List.of(new Vector2d(2,2), new Vector2d(2, 4)));
        this.engine = new SimulationEngine(this.map, positions);
        this.engine.addObserver(this);
        this.engine.setMoveDelay(moveDelay);
        this.elementCreator = new GuiElementBox();
        this.cellSize = 45;
    }

    private void createGrid() {
        Vector2d[] corners = this.map.getCorners();
        int left = corners[0].x;
        int right = corners[1].x;
        int down = corners[0].y;
        int up = corners[1].y;

        grid.setGridLinesVisible(false);
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();
        grid.setGridLinesVisible(true);

        Label yx = new Label("y \\ x");
        grid.add(yx, 0, 0, 1, 1);
        grid.getColumnConstraints().add(new ColumnConstraints(cellSize));
        grid.getRowConstraints().add(new RowConstraints(cellSize));
        GridPane.setHalignment(yx, HPos.CENTER);

        for (int i = 1; i <= right - left + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(cellSize));
            Label label = new Label(String.format("%d", left + i - 1));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, i, 0, 1, 1);
        }

        for (int i = 1; i <= up - down + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(cellSize));
            Label label = new Label(String.format("%d", up - i + 1));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, 0, i, 1, 1);
        }

        for (int i = 1; i <= up - down + 1; i++) {
            for (int j = 1; j <= right - left + 1; j++) {
                IMapElement object = map.objectAt(new Vector2d(left + j - 1, up - i + 1));
                Label label;
                if(object != null) {
                    VBox element = elementCreator.showElement(object);
                    GridPane.setHalignment(element, HPos.CENTER);
                    grid.add(element, j, i, 1, 1);
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Button start = new Button("Start");
        TextField moves = new TextField();
        VBox controls = new VBox(moves, start);
        HBox main = new HBox(grid, controls);

        start.setOnAction(click -> {
            List<MoveDirection> directions = OptionsParser.parse(moves.getText().split(" "));
            engine.setDirections(directions);

            Thread eThread = new Thread(engine);
            eThread.start();
                }
        );
        Scene scene = new Scene(main, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void positionChanged() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            createGrid();
                }
        );
    }
}