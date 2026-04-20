/**
 * The Gadget class is the main superclass for all gadgets in the Gadget Shop.
 * It stores the basic information that every gadget will have.
 * Every gadget in the shop will have model name, price, weight, and size.
 * Other classes like Mobile and MP3 extend this class, which means they inherit all 
 * the fields and methods defined here. It helps avoid repeating the same code.
 *
 * Author:- Anish Shashicant
 * Date:- 19th April 2026
 * Version:- 1.2
 */
public class Gadget
{
    // These are the variables that every gadget will have. They are private, which means they can only be accessed
    // through the getter methods that are written below.
    private String model;  // This stores model name of the gadget.
    private double price;  // This stores price of the gadget.
    private int weight;    // This stores weight of the gadget.
    private String size;   // This stores size of the gadget.

    /**
     * The constructor creates a new Gadget object with model, price, weight and size.
     * It is called first when a new gadget is created. It takes the model, price, weight, and size as inputs.
     * It then saves each one into the matching field using "this" keyword.
     * 
     */
    public Gadget(String model, double price, int weight, String size)
    {

        // "this" refers to the current object which is the instance of the class you are in.
        //  It is used to access the object's variables.
        // We used "this" keyword because the parameter names are the same as the field names. Without this, Java would not know
        // which one we are refering to. Example:- "this.model" refers to the field, while "model" refers to the parameter.
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * This method is used to get the model name of the gadget. The model name is a String and it is stored
     *  in the private model field. Because the field is private it cannot be accessed directly from outside the class.
     * So this method is used to safely return the model name. It simply returns whatever is currently saved in the model field.
     */
    public String get_Model()
    {
        return model;
    }

    /**
     * This method is used to get the price of the gadget. The price is stored as a double which means
     * it can hold decimal numbers. Because the field is private it cannot be accessed directly from outside the class.
     * So this method is used to safely return the price. It will return whatever is currently saved in the price field.
     */
    public double get_Price()
    {
        return price;
    }

    /**
     *This method is used to get the weight of the gadget. The weight is stored in integer, which means it is a whole number.
     * Because the field is private it cannot be accessed directly from outside the class. So, this method is used to 
     * safely return the weight. It will return whatever is currently saved in the weight field.
     */
    public int get_Weight()
    {
        return weight;
    }

    /**
     * This method is used to get the size of the gadget. The size is stored as a String.
     *  So, this method is used to safely return the size. It will return whatever is currently saved in the size field.
     */
    public String get_Size()
    {
        return size;
    }

    /**
     *  This method is used to display all the details of the gadget as a String in one block.
     * It starts with an empty String called text.Then it adds the model, price, weight, and size onto the String one by one.
     * Each detail is placed on a new line using the newline character \n. Each line will contain a label + a value. 
     * At the end the completed String is returned, so it can be displayed to the user. This method can also be overridden
     *  by subclasses like Mobile and MP3. When it is overridden the subclass can call super.display() to get these details
     * and then add its own extra details on top of it.
     */
    public String display()
    {
        String text = "";

        text = text + "Model: " + model + "\n";  // add the model name to the text.
        text = text + "Price: " + price + "\n";  // add the price details to the text.
        text = text + "Weight: " + weight + "\n"; // add the weight details to the text.
        text = text + "Size: " + size + "\n";    // add the size details to the text.

        return text;
    }
}