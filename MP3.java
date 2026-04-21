/**
 * The MP3 class represents an MP3 player in the Gadget Shop. It extends 
 * the Gadget class, which means it inherits all it's fields and methods from
 * Gadget such as model, price, weight, and size. It also adds a new field called 
 * memory. The memory shows how much storage space is available on the MP3 player.
 * When music is downloaded onto the Mp3 player the memory will goes down and when 
 * the music is deleted from the MP3 player, the memory will go back up.
 * This class uses inheritance which means we do not have to rewrite
 * the common fields, because they already exist in the Gadget class.
 *
 * Author:- Anish Shashicant
 * Date:- 19th April 2026
 * Version:- 1.2
 */
public class MP3 extends Gadget
{
    private int memory; // This stores how much memory the MP3 player currently has available.

    /**
     * This is the constructor for the MP3 class. It is used to create a new MP3 player object.
     * It takes the model, price, weight, size, and the memory as inputs. It first calls the
     * Gadget constructor using the super keyword. The super keyword passes the model, price,
     * weight,and size up to the Gadget constructor. This sets up the common fields that
     * come from the Gadget class. After that it sets the memory field which belongs 
     * only to the MP3 class.
     */
    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    /**
     * This method is used to get the current memory available on the MP3 player. The memory is 
     * stored as an integer, which means it's a whole number. Because the field is private it
     * cannot be accessed directly from outside the class. So this method is used to safely
     * return the memory.     * It simply returns whatever is currently saved in the memory field.
     */
    public int get_Memory()
    {
        return memory;
    }

    /**
     * This method is used to download music onto the MP3 player. It takes the size of the music
     *  file as an input. Then, before downloading, it checks the condition, if the current memory 
     *  is enough to fit the file. If there is enough memory then the file size is subtracted from
     *  the memory. If there is not enough memory, then the download does not happen and nothing
     *  changes. This stops the memory from going below zero.
     */
    public void download_Music(int dsize)
    {
        if(memory >= dsize)
        {
            memory = memory - dsize;
        }
    }

    /**
     * This method is used to delete music from the MP3 player.It takes in the size of the music
     * file being deleted as an input. When a file is deleted, the memory that it was using
     * becomes free again. So the file size is added back onto the memory of the MP3 player.
     * There is no check needed here, because deleting always increases the memory.
     */
    public void delete_Music(int dsize)
    {
        memory = memory + dsize;
    }

    /**
     * This method is used to display all the details of the MP3 player as a String. 
     * It starts with an empty String called text. It then calls the super.display()
     * to get the common details from the Gadget class. This includes the model, 
     * price, weight, and size. After that it adds the memory onto the String on a
     * new line. At the end, the completed String is returned, so it can be displayed to user.
     */
    public String display()
    {
        String text = "";

        text = text + super.display();
        text = text + "Memory: " + memory + "\n";

        return text;
    }
}