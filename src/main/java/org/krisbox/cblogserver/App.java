package org.krisbox.cblogserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.krisbox.cblogserver.utils.files.FileReader;
import org.krisbox.cblogserver.utils.properties.ApplicationProperties;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Optional;

public class App extends javafx.application.Application {
    private final String   CONFIG_FILE = new String("properties.json");
    private final String   CSS_FILE    = new String("css/style.css");
    private Scene          scene;
    private ApplicationProperties props;


    public App() {
        try {
            props = new ObjectMapper().readValue(new FileReader().readFile(CONFIG_FILE), ApplicationProperties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Font loadFont(String fontpack) {
        Font f = null;

        if (fontpack.equals("solid")) {
            f = Font.loadFont(App.class.getResource("/fonts/fontawesome-solid-900.ttf").toExternalForm(), 12);
        }else if(fontpack.equals("brands")) {
            f = Font.loadFont(App.class.getResource("/fonts/fontawesome-brands-900.ttf").toExternalForm(), 12);
        }else if(fontpack.equals("regular")) {
            f = Font.loadFont(App.class.getResource("/fonts/fontawesome-regular-900.ttf").toExternalForm(), 12);
        }else if(fontpack.equals("light")) {
            f = Font.loadFont(App.class.getResource("/fonts/fontawesome-light-900.ttf").toExternalForm(), 12);
        }

        return f;
    }

    private void buildAboutDialog() {
        String titleText = "About CBlogServerUI";

        String aboutText = props.getAppProperties().getAuthor().getAuthor() + "\n" +
                props.getAppProperties().getAuthor().getAuthorEmail() + "\n" +
                 "Copyright " + props.getAppProperties().getAuthor().getCopyrite();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleText);
        alert.setHeaderText(props.getAppProperties().getTitle() + " \u00a9\n" + "License " + props.getAppProperties().getAuthor().getLicense());

        alert.setContentText(aboutText);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    private MenuBar buildMenu() {
        MenuBar menuBar = new MenuBar();

        for(int i=0; i<props.getAppProperties().getMenu().size(); i++) {
            Menu menuItem = new Menu(props.getAppProperties().getMenu().get(i).getDisplay());

            for(int j=0; j<props.getAppProperties().getMenu().get(i).getSubitems().size(); j++) {
                MenuItem subMenuItem = new MenuItem(props.getAppProperties().getMenu().get(i).getSubitems().get(j).getDisplay());

                if(props.getAppProperties().getMenu().get(i).getSubitems().get(j).getName().equals("Exit")) {
                    subMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent t) {
                            System.exit(0);
                        }
                    });
                }else if(props.getAppProperties().getMenu().get(i).getSubitems().get(j).getName().equals("About")) {
                    subMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent t) {
                            buildAboutDialog();
                        }
                    });
                }
                menuItem.getItems().add(subMenuItem);
            }
            menuBar.getMenus().add(menuItem);
        }

        return menuBar;
    }

    private void insertText(TextArea textArea, String toInsert) {
        textArea.insertText(textArea.getCaretPosition(), toInsert);
    }

    private String buildHTML(String text) {
        return buildFormatting(buildShortcodes(text));
    }

    private String buildShortcodes(String text) {
        String after = text;

        for(int j=0; j<props.getAppProperties().getShortcodes().size(); j++) {
            String start = props.getAppProperties().getShortcodes().get(j).getRegex().getStart();
            String end   = props.getAppProperties().getShortcodes().get(j).getRegex().getEnd();


            after = after.replaceAll(props.getAppProperties().getShortcodes().get(j).getRegex().getStart(),
                    props.getAppProperties().getShortcodes().get(j).getHtml().getStart());

            after = after.replaceAll(props.getAppProperties().getShortcodes().get(j).getRegex().getEnd(),
                    props.getAppProperties().getShortcodes().get(j).getHtml().getEnd());
        }

        return after;
    }

    private String buildFormatting(String text) {
        String after = text;

        for(int k=0; k<props.getAppProperties().getFormatting().size(); k++) {
            after = after.replaceAll(props.getAppProperties().getFormatting().get(k).getRegex(),
                    props.getAppProperties().getFormatting().get(k).getHtml());
        }

        return after;
    }

    private ToolBar buildToolBar() {
        ToolBar toolBar1 = new ToolBar();

        for(int i=0; i<props.getAppProperties().getToolbar().size(); i++) {
            if(props.getAppProperties().getToolbar().get(i).getName().equals("Separator")) {
                toolBar1.getItems().add(new Separator());
            }else{
                Button btnTempButton = new Button(props.getAppProperties().getToolbar().get(i).getIcon());
                btnTempButton.setFont(loadFont(props.getAppProperties().getToolbar().get(i).getFontpack()));

                if(props.getAppProperties().getToolbar().get(i).getName().equals("Codeblock")) {
                    int finalI = i;
                    btnTempButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            insertText((TextArea)((VBox) scene.getRoot()).getChildren().get(2), "[" + props.getAppProperties().getToolbar().get(finalI).getShortcode() + "]" + "[/" + props.getAppProperties().getToolbar().get(finalI).getShortcode() + "]");
                        }
                    });
                } else if (props.getAppProperties().getToolbar().get(i).getName().equals("Quoteblock")) {
                    int finalI1 = i;
                    btnTempButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            insertText((TextArea)((VBox) scene.getRoot()).getChildren().get(2), "[" + props.getAppProperties().getToolbar().get(finalI1).getShortcode() + "]" + "[/" + props.getAppProperties().getToolbar().get(finalI1).getShortcode() + "]");
                        }
                    });
                } else if (props.getAppProperties().getToolbar().get(i).getName().equals("Link")) {
                    int finalI2 = i;
                    btnTempButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            String t = "[" + props.getAppProperties().getToolbar().get(finalI2).getShortcode() + " url=\"\"]" + "[/" + props.getAppProperties().getToolbar().get(finalI2).getShortcode() + "]";
                            insertText((TextArea)((VBox) scene.getRoot()).getChildren().get(2), t);
                        }
                    });
                } else if (props.getAppProperties().getToolbar().get(i).getName().equals("Preview")) {
                    btnTempButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            System.out.println("Preview clicked");

                            TextArea t = (TextArea)((VBox) scene.getRoot()).getChildren().get(2);

                            String stuff = buildHTML(t.getText());

                            buildPreview(stuff);

                            System.out.println(buildHTML(t.getText()));
                        }
                    });
                }

                toolBar1.getItems().add(btnTempButton);
            }
        }

        return toolBar1;
    }

    private TextArea buildTextArea() {
        return new TextArea();
    }

    private void buildPreview(String content) {
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle(props.getAppProperties().getPreview().getTitle());
        dialog.setHeaderText(props.getAppProperties().getPreview().getHeader());

        ButtonType copyHtmlButton = new ButtonType("Copy HTML", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(copyHtmlButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Browser(content),0,0);

        Node copyButton = dialog.getDialogPane().lookupButton(copyHtmlButton);
        copyButton.setDisable(false);

        dialog.getDialogPane().setContent(grid);

        Object t = dialog.showAndWait();

        if(((Optional<ButtonType>)t).get() == ButtonType.CANCEL) {
        }else{
            copyToClipboard(buildHTML(content));
            notifyCopied();
        }
    }

    private void notifyCopied() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(props.getAppProperties().getPreview().getTitle());
        alert.setHeaderText(null);
        alert.setContentText(props.getAppProperties().getPreview().getCopiedText());

        alert.showAndWait();
    }

    private void copyToClipboard(String data) {
        StringSelection selection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private String buildPreviewHTML(String content) {
        return "<html><head><style>"+new FileReader().readFile(CSS_FILE)+"</style></head><body>" + content + "</body></html>";
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        scene    = new Scene(new VBox(), props.getAppProperties().getWidth(), props.getAppProperties().getHeight());

        primaryStage.setTitle(props.getAppProperties().getTitle());
        ((VBox) scene.getRoot()).getChildren().addAll(buildMenu());
        ((VBox) scene.getRoot()).getChildren().addAll(buildToolBar());
        TextArea t = buildTextArea();
        ((VBox) scene.getRoot()).getChildren().addAll(t);

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {

            }
        });

        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                t.setPrefHeight(newSceneHeight.intValue()-65);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        t.setMinHeight(primaryStage.getMinHeight());
        t.setMaxHeight(primaryStage.getMaxHeight());
        t.setPrefHeight(props.getAppProperties().getHeight()-65);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public class Browser extends Region {

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        public Browser(String content) {
            getStyleClass().add("browser");
            getChildren().add(browser);
            render(content);
        }

        public void render(String content) {
            webEngine.loadContent(buildPreviewHTML(content), "text/html");
        }
        private Node createSpacer() {
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            return spacer;
        }

        @Override protected void layoutChildren() {
            double w = getWidth();
            double h = getHeight();
            layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
        }

        @Override protected double computePrefWidth(double height) {
            return 750;
        }

        @Override protected double computePrefHeight(double width) {
            return 500;
        }
    }
}
