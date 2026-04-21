/**
 * The GadgetShop class is the main class that runs the Gadget Shop application. It uses JavaFX
 *  to create a graphical user interface that the user can interact with. The interface has
 *  text fields where the user can type in the information about gadgets. It also has buttons
 *  that the user can click to do different things in the application. The class extends Application
 *  which is needed to run a JavaFX program. It also implements EventHandler which allows the class
 *  to detect when the button is clicked. All the gadgets that are added are stored in an ArrayList 
 *  called gadgets. The ArrayList can hold both Mobile and MP3 objects because they both extend Gadget.
 *  The log area at the bottom of the screen shows messages to the user, so they know what is happening
 *  in the application.
 *
 * Author:- Anish Shashicant
 * Date:- 19th April 2026
 * Version:- 1.2
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.util.ArrayList;

public class GadgetShop extends Application implements EventHandler<ActionEvent>
{
    private TextField model_Field = new TextField();
    private TextField price_Field = new TextField();
    private TextField weight_Field = new TextField();
    private TextField size_Field = new TextField();
    private TextField credit_Field = new TextField();
    private TextField memory_Field = new TextField();
    private TextField phone_Field = new TextField();
    private TextField duration_Field = new TextField();
    private TextField download_Size_Field = new TextField();
    private TextField display_Number_Field = new TextField();

    private TextArea logArea = new TextArea();

    private Button addMobileButton;
    private Button addMP3Button;
    private Button displayAllButton;
    private Button makeCallButton;
    private Button downloadMusicButton;
    private Button clearButton;
    private Button exitButton;

    private ArrayList<Gadget> gadgets = new ArrayList<>();

    public void start(Stage stage)
    {
        Pane root = new Pane();

        Label modelLabel = new Label("Model:");
        modelLabel.setLayoutX(20); modelLabel.setLayoutY(25);
        model_Field.setLayoutX(180); model_Field.setLayoutY(20);

        Label priceLabel = new Label("Price (£):");
        priceLabel.setLayoutX(20); priceLabel.setLayoutY(55);
        price_Field.setLayoutX(180); price_Field.setLayoutY(50);

        Label weightLabel = new Label("Weight (g):");
        weightLabel.setLayoutX(20); weightLabel.setLayoutY(85);
        weight_Field.setLayoutX(180); weight_Field.setLayoutY(80);

        Label sizeLabel = new Label("Size:");
        sizeLabel.setLayoutX(20); sizeLabel.setLayoutY(115);
        size_Field.setLayoutX(180); size_Field.setLayoutY(110);

        Label creditLabel = new Label("Credit:");
        creditLabel.setLayoutX(20); creditLabel.setLayoutY(145);
        credit_Field.setLayoutX(180); credit_Field.setLayoutY(140);

        Label memoryLabel = new Label("Memory (MB):");
        memoryLabel.setLayoutX(20); memoryLabel.setLayoutY(175);
        memory_Field.setLayoutX(180); memory_Field.setLayoutY(170);

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setLayoutX(20); phoneLabel.setLayoutY(205);
        phone_Field.setLayoutX(180); phone_Field.setLayoutY(200);

        Label durationLabel = new Label("Duration (Min):");
        durationLabel.setLayoutX(20); durationLabel.setLayoutY(235);
        duration_Field.setLayoutX(180); duration_Field.setLayoutY(230);

        Label downloadLabel = new Label("Download Size (MB):");
        downloadLabel.setLayoutX(20); downloadLabel.setLayoutY(265);
        download_Size_Field.setLayoutX(180); download_Size_Field.setLayoutY(260);

        Label displayLabel = new Label("Gadget's Display Number:");
        displayLabel.setLayoutX(20); displayLabel.setLayoutY(295);
        display_Number_Field.setLayoutX(180); display_Number_Field.setLayoutY(290);

        addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(20); addMobileButton.setLayoutY(330);
        addMobileButton.setOnAction(this);

        addMP3Button = new Button("Add MP3");
        addMP3Button.setLayoutX(125); addMP3Button.setLayoutY(330);
        addMP3Button.setOnAction(this);

        displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(217); displayAllButton.setLayoutY(330);
        displayAllButton.setOnAction(this);

        makeCallButton = new Button("Make Call");
        makeCallButton.setLayoutX(320); makeCallButton.setLayoutY(330);
        makeCallButton.setOnAction(this);

        downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(420); downloadMusicButton.setLayoutY(330);
        downloadMusicButton.setOnAction(this);

        clearButton = new Button("Clear All");
        clearButton.setLayoutX(550); clearButton.setLayoutY(330);
        clearButton.setOnAction(this);

        exitButton = new Button("Exit");
        exitButton.setLayoutX(635); exitButton.setLayoutY(330);

        exitButton.setOnAction(e -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Exit Application");
                    alert.setHeaderText("Are you sure you want to exit?");
                    alert.setContentText("Click OK to exit or Cancel to continue.");

                    if (alert.showAndWait().get() == ButtonType.OK)
                    {
                        Platform.exit();
                    }
            });

        logArea.setLayoutX(20);
        logArea.setLayoutY(370);
        logArea.setPrefSize(650, 300);

        root.getChildren().addAll(
            modelLabel,
            model_Field,
            priceLabel,
            price_Field,
            weightLabel,
            weight_Field,
            sizeLabel,size_Field,
            creditLabel,credit_Field,
            memoryLabel,memory_Field,
            phoneLabel,phone_Field,
            durationLabel,duration_Field,
            downloadLabel,download_Size_Field,
            displayLabel,display_Number_Field,
            addMobileButton,addMP3Button,
            displayAllButton,
            makeCallButton,
            downloadMusicButton,
            clearButton,
            exitButton,
            logArea
        );

        stage.setScene(new Scene(root, 700, 700));
        stage.setTitle("Anish's Gadget Shop");
        stage.show();
    }

    public void handle(ActionEvent e)
    {
        if (e.getSource() == addMobileButton)
            add_Mobile();
        else if (e.getSource() == addMP3Button)
            add_MP3();
        else if (e.getSource() == displayAllButton)
            display_All();
        else if (e.getSource() == makeCallButton)
            make_Call();
        else if (e.getSource() == downloadMusicButton)
            download_Music();
        else if (e.getSource() == clearButton)
            clear_Text_Fields();
    }

    private void show_Error(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public int get_Display_Number()
    {
        int number = -1;

        try
        {
            number = Integer.parseInt(display_Number_Field.getText());

            if (number < 0 || number >= gadgets.size())
            {
                show_Error("Invalid Gadget's Display Number.\nPlease enter a number between 0 and " + (gadgets.size() - 1) + ".");
                number = -1;
            }
        }
        catch (Exception e)
        {
            show_Error("Please enter a valid whole number for the\nGadget's Display Number.");
        }

        return number;
    }

    public void add_Mobile()
    {
        try
        {
            double price = Double.parseDouble(price_Field.getText());
            int weight = Integer.parseInt(weight_Field.getText());
            int credit = Integer.parseInt(credit_Field.getText());

            if(price < 0 || weight < 0 || credit < 0)
            {
                show_Error("Values cannot be negative.");
                return;
            }

            Mobile m = new Mobile(
                    model_Field.getText(),
                    price,
                    weight,
                    size_Field.getText(),
                    credit
                );
            gadgets.add(m);
            logArea.appendText("Mobile added to the Gadget Shop.\n");
        }
        catch (Exception e)
        {
        show_Error("Error adding a mobile gadget.\nPlease check all fields are filled correctly.");
        }
    }

    public void add_MP3()
    {
        try
        {
            double price = Double.parseDouble(price_Field.getText());
            int weight = Integer.parseInt(weight_Field.getText());
            int memory = Integer.parseInt(memory_Field.getText());

            if(price < 0 || weight < 0 || memory < 0)
            {
                show_Error("Values cannot be negative.");
                return;
            }
            MP3 p = new MP3(
                    model_Field.getText(),
                    price,
                    weight,
                    size_Field.getText(),
                    memory
                );
            gadgets.add(p);
            logArea.appendText("MP3 added to the Gadget Shop.\n");
        }
        catch (Exception e)
        {
            show_Error("Error adding MP3 player.\nPlease check all fields are filled correctly.");
        }
    }

    public void display_All()
    {
        logArea.appendText("\nTotal Gadgets in the Gadget Shop.\n");

        for (int i = 0; i < gadgets.size(); i++)
        {
            logArea.appendText("Gadget's Display Number: " + i + "\n");
            logArea.appendText(gadgets.get(i).display());
            logArea.appendText("Next Gadget\n");
            logArea.appendText("\n");
        }
    }

    public void make_Call()
    {
        int index = get_Display_Number();

        if (index != -1)
        {
            try
            {
                Mobile m = (Mobile) gadgets.get(index);

                String phone = phone_Field.getText();
                int duration = Integer.parseInt(duration_Field.getText());

                if (m.get_Credit() < duration)
                {
                    show_Error("Insufficient credit to make your call.\nYou have " + m.get_Credit() + " minutes of credit left.");
                    return;
                }

                m.make_Call(phone, duration);
                logArea.appendText("\nCall has been made\n");
                logArea.appendText("Model: " + m.get_Model() + "\n");
                logArea.appendText("Gadget's Display Number: " + index + "\n");
                logArea.appendText("Phone Number: " + phone + "\n");
                logArea.appendText("Duration: " + duration + " minutes\n");
                logArea.appendText("Credit Left: " + m.get_Credit() + " minutes\n");
                logArea.appendText("\n");
            }
            catch (NumberFormatException e)
            {
                show_Error("Please enter a valid whole number for the call duration.");
            }
            catch (ClassCastException e)
            {
                show_Error("Selected gadget is not a Mobile phone. Please select a Mobile.");
            }
        }
    }

    public void download_Music()
    {
        int index = get_Display_Number();

        if (index != -1)
        {
            try
            {
                MP3 p = (MP3) gadgets.get(index);

                int size = Integer.parseInt(download_Size_Field.getText());

                if (p.get_Memory() < size)
                {
                    show_Error("Insufficient memory to download the music.\nYou have " + p.get_Memory() + " MB of memory left.");
                    return;
                }

                p.download_Music(size);
                logArea.appendText("\nMusic has been Downloaded.\n");
                logArea.appendText("Model: " + p.get_Model() + "\n");
                logArea.appendText("Gadget's Display Number: " + index + "\n");
                logArea.appendText("Download Size: " + size + " MB\n");
                logArea.appendText("Memory Left: " + p.get_Memory() + " MB\n");
                logArea.appendText("\n");
            }
            catch (NumberFormatException e)
            {
                show_Error("Please enter a valid whole number for the song's download size.");
            }
            catch (ClassCastException e)
            {
                show_Error("Selected gadget is not a MP3 player. Please select a MP3 player.");
            }
        }
    }

    public void clear_Text_Fields()
    {
        model_Field.clear();
        price_Field.clear();
        weight_Field.clear();
        size_Field.clear();
        credit_Field.clear();
        memory_Field.clear();
        phone_Field.clear();
        duration_Field.clear();
        download_Size_Field.clear();
        display_Number_Field.clear();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
