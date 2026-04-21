/**
 * The Mobile class represents a mobile phone in the Gadget Shop and it extends the Gadget class 
 * which means it inherits all it's fields and methods from Gadget such as model, price, weight,
 * and size. It also adds a new field called credit. The credit will show how many minutes of 
 * calls the phone has available. When a call is made the duration of the call is subtracted
 * from the credit. Credit can also be added to the phone using the add_Credit method. 
 * This class uses inheritance which means we do not need to rewrite the fields which
 * are common because they already exist in the Gadget class.
 *
 * Author:- Anish Shashicant
 * Date:- 19th April 2026
 * Version:- 1.2
 */
public class Mobile extends Gadget
{
    private int credit; // This stores how much call credit the mobile phone currently has as integer.

    /**
     * This is the constructor of the Mobile class. It is used to create a new Mobile object.
     * It takes in the model, price, weight, size, and credit as inputs. It first calls the Gadget
     * constructor using the super keyword. The super keyword passes the model, price, weight,
     * and size up to the Gadget constructor. This sets up the common fields that come from the 
     * Gadget class. After that it sets the credit field which belongs only to the Mobile class.
     */
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model, price, weight, size);
        this.credit = credit;
    }

    /**
     * This method is used to get the current credit from the mobile phone. The credit is stored 
     * as an integer,which means it is a whole number. Because the field is private it cannot be
     * accessed directly from outside the class. So this method is used to safely return the credit. 
     * It simply returns whatever is currently saved in the credit field.
     */
    public int get_Credit()
    {
        return credit;
    }

    /**
     * This method is used to add credits to the gadget mobile phone. It takes an amount as an input.
     * Before adding the credit it's going to checks if the amount is greater than zero. This is
     * to make sure that a negative or zero value cannot reduce the credit of the mobile phone. 
     * If the condition is true,then it is added onto the existing credit. If the amount is zero or
     * less then nothing happens.
     */
    public void add_Credit(int amount)
    {
        if(amount > 0)
        {
            credit = credit + amount;
        }
    }

    /**
     * This method is used to make a phone call on the mobile phone. It takes in a phone number
     *  and a call duration as inputs from the user. Before making the call it checks if the current
     *  credit is enough for the duration of the call. If there is enough credit then the duration
     *  is subtracted from the credit. If there is not enough credit, then the call does not go 
     *  through and nothing happens. This will stop the credit from going below zero.
     */
    public void make_Call(String phoneNumber, int duration)
    {
        if(credit >= duration)
        {
            credit = credit - duration;
        }
}

    /**
     * This method is used to display all the details of the mobile phone as a String. It starts with
     *  an empty String called text. Then, it calls super.display() to get the common details from the 
     *  Gadget class. This includes the model, price, weight, and size. After that it adds the credit
     *  onto the String on a new line which is specific to the mobile. At the end the completed String is
     *  returned so it can be displayed to the user.
     */
    public String display()
    {
        String text = "";

        text = text + super.display();
        text = text + "Credit: " + credit + "\n";

        return text;
    }
}