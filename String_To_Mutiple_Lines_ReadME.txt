Hello all, just a little Read me about the Code.

What is the Code for?
The code is used to convert one string into multiple strings and then draws them to the screen,this is because Java's Drawstring
method will draw a string no matter how long the string is, so this code takes the string and chops it into sections of a certain
length that you can choose.

the code also allows you to choose a font to draw the text with, the colour of the text and the location of the array.

How does it work?
This code works by first taking the original string and spliting the words into an array, it splits by a space. The code than has a
main for loop that runs through the array. Each time the loop iterates it adds the array value to a string, adds one to the words
integer and then tests to check if the element is a new line character (\n) it sets a boolean to true so it can bypass some code late.

After it checks if the string is longer than specified width or if the bypass boolean is true, if the statement is true then the code
will clear the string that is storing the words because that string is longer than the length you specified, it then runs a second for
loop that that runs from the last value the first forloop was at when their was a new line and it take that and adds the words minus 1
for the amount of times it needs to loop and then it adds the array elements back to the string and that is now the right length of
the string to the screen.

Once the new string is made it draws it to the screen. If the bypass boolean is true it sets Last to the first forloop value plus
else it sets the Last variable to the first loops value and the the loops value minus 1. and then sets Words to 0. after the loop is
finished it draws the remaining string, if you dont have this then you will be missing the last bit of your message.

Whats next?
I'm planning on using HTML like code for formating the code. for example right now if there is a new line character it will
automatically go to a new line.
I'm also thinking about adding padding left and right values to move the code. doesn't really need it because you can just set the X
and Y location to a slightly more than they originaly are. 
