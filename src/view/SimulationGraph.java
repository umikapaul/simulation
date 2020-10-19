package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.sound.sampled.Line;
import model.grid.Grid;
import view.GamePaneShapes.GamePane;

public class SimulationGraph {

  private static final int GRAPH_WINDOW_WIDTH = 400;
  private static final int GRAPH_WINDOW_HEIGHT = 400;
  private static final String GRAPH_RESOURCE = "resources.graphLabels";

  private  ResourceBundle graphLabelSource;

  private Grid grid;
  private NumberAxis xAxis;
  private NumberAxis yAxis;
  private Map<String, Series> cellTypeData;

  private LineChart<Number, Number> simulationGraph;

  private String simulationType;


  public SimulationGraph(Grid grid, String simulationType) {
    this.grid = grid;
    this.simulationType = simulationType;
    graphLabelSource = ResourceBundle.getBundle(GRAPH_RESOURCE);

    BorderPane graphRoot = new BorderPane();
    Scene scene = new Scene(graphRoot, GRAPH_WINDOW_WIDTH, GRAPH_WINDOW_HEIGHT);
    Stage stage = new Stage();

    cellTypeData = new HashMap<>();

    xAxis = new NumberAxis();
    yAxis = new NumberAxis();

    simulationGraph = createSimulationGraph();

    graphRoot.setCenter(simulationGraph);

    stage.setTitle(simulationType);
    stage.setScene(scene);
    stage.show();


  }

  public LineChart createSimulationGraph() {
    LineChart<Number, Number> simulationGraph = new LineChart<>(xAxis, yAxis);
    simulationGraph.setCreateSymbols(false);
    xAxis.setLabel(graphLabelSource.getString("xAxis"));
    yAxis.setLabel(graphLabelSource.getString("yAxis"));
    simulationGraph.setTitle(simulationType);

    for (String cellTypeName: grid.getAllTypes()) {
      Series graphData = new Series();
      graphData.setName(cellTypeName);
      cellTypeData.put(cellTypeName, graphData);
      simulationGraph.getData().add(graphData);
    }

    return simulationGraph;
  }

  public void updateSimulationGraph(int frameCount, Map<String, Integer> cellTypeCounts) {
    for (String cellTypeName: cellTypeData.keySet()) {
      Data graphData = new Data(frameCount, cellTypeCounts.get(cellTypeName));
      cellTypeData.get(cellTypeName).getData().add(graphData);
    }
  }

}