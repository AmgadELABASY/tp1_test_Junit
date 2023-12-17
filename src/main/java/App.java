//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void main(String[] args) {

        TextBuffer tb = new TextBuffer("Hello world");
        tb.ins("Amgad",5);
        System.out.println(tb.toString());

        tb.del(5,10);
        System.out.println(tb.toString());

        String substr = tb.substr(0,5);
        System.out.println(substr);

        int length = tb.maxP();

        System.out.println(length);

        EmacsKillRing ekr = new EmacsKillRing();
        TextEditor texte = new TextEditor("Hello World");


    }
}
