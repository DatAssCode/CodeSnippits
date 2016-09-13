public class String_To_Mutiple_Lines {
	
	/*
	This method should be ran in the graphics.
	
	g is the graphics variable. You can change Graphics to Graphics2D by changing the Graphics g to Graphics2D g.
	
	Fnt is the font you want the font to use on the Text. Clr also allows you to set the colour of the string.
	Cont is the content you will be putting to the display.
	X and Y is the top left position of the text
	W is the Maximum width that you want the text to be.
	A is the Alignment. so you can use the alignment values.
	
	An Example: 
	StringToDisplay(g, new Font("Verdana", Font.PLAIN, 24), new Color(255,255,255,125), "Hello world. How are you?", 500, 300, 200, Align_Left);
	This method will print out "Hello world" on one line and How are you? on to another.
	*/
    public void StringToDisplay(Graphics g, Font Fnt, Color Clr, String Cont, int X, int Y, int W, int A) {
        g.setFont(Fnt);
        g.setColor(Clr);
		/*
		Splits the message into separate words. For example "hello world !!" will be put into an array that should look like this:
		{"Hello","World","!!"}
		*/
        String[] ContAry = Cont.split(" ");
        //Used to Store the rejoined string, this will be used to check the width of the string when drawn to the screen
		String ShortMsg = "";
		
		/*
		The `Lines` variable will be incremented every-time the ShortMsg string exceeds the width 
		*/
        int Lines = 1;
		/*
		The `Words` variable will count the amount of words in the ShortMsg.
		And the `Last` variable is used to store the last location in the array 
		*/
        int Words = 0;
        int Last = 0;
		
		/*
		The section of code adds one word to the ShortMsg and then tests the length of the string.
		If their is a new line character (\n) or if the string exceeds the maximum width, it will
		empty the ShortMsg string and then adds the number of words from the last variable to the now empty ShortMsg.
		*/
		// First off, there is a for loop that runs through the array of words.
        for (int P = 0; P < ContAry.length; P++) {
		// The BP boolean is to bypass the Test if a new line character is present.
            Boolean Bp = false;
			// A word is added to ShortMsg and then adds 1 to the `Words` Variable.
            ShortMsg += ContAry[P] + " ";
            Words++;
			//It tests if the Word that's just been added to the ShortMsg is a new line character and if it is it sets BP to true.
            if (ContAry[P].contains("\n")) {
                Bp = true;
                ShortMsg += ContAry[P].replace("\n", "");
                Words++;
            }
			//test if the ShortMsg is shorter than the maximum width or if BP is true.
            if (Fnt.getStringBounds(ShortMsg, FRC).getWidth() >= W || Bp) {
				//Clears the ShortMsg to have the right amount of words appended to the string.
                ShortMsg = "";
                for (int S = Last; S < (Last + Words - 1); S++) {
                    ShortMsg += ContAry[S] + " ";
                }
				//Runs a method to draw the ShortMsg and allows the user to set the alignment of the text.
                DrawString(g, Fnt, Clr, ShortMsg, X, (int) (Y + (Fnt.getStringBounds(ShortMsg, FRC).getHeight() * Lines)), W, A);
				//adds one to Lines variable.
                Lines += 1;
				// Clears the ShortMsg again.
                ShortMsg = "";
				//checks if the BP is false and then either sets last to the current location of P and then takes 1 from P (P being the Value of the first For loop)
				//else it sets Last to P plus 1.
                if (Bp != true) {
                    Last = P;
                    P -= 1;
                } else {
                    Last = P + 1;
                }
				// Sets Words to 0 before going back to the top of the for loop.
                Words = 0;
            }
        }
		//After the loop ends it prints the ShortMsg because there will more than likely be something left in the string.
        DrawString(g, Fnt, Clr, ShortMsg, X, (int) (Y + (Fnt.getStringBounds(ShortMsg, FRC).getHeight() * Lines)), W, A);
    }
	
	// Alignment Values
    public final int Align_Left = 0;
    public final int Align_Center = 1;
    public final int Align_Right = 2;
	
	//This method works out how to draw the string and how to align it. 
    private void DrawString(Graphics g, Font Fnt, Color Clr, String ShortMsg, int X, int Y, int W, int A) {
        // Depending on int A is it will select one of the conditions.
        if (A == Align_Left) {
            g.drawString(ShortMsg, X, Y);
        } else if (A == Align_Center) {
            g.drawString(ShortMsg, (int) (X + ((W / 2) - (Fnt.getStringBounds(ShortMsg, FRC).getWidth() / 2))), Y);
        } else if (A == Align_Right) {
            g.drawString(ShortMsg, (int) (X + (W - Fnt.getStringBounds(ShortMsg, FRC).getWidth())), Y);
        }else{
			 g.drawString("Invalid Alignment Value!", X, Y);
		}
		
    }

}
