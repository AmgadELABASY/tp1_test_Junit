
import org.junit.jupiter.api.Assertions;
import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TextBufferTest {
    private TextBuffer textBuffer;

    @BeforeEach
    public void init(){
        textBuffer = new TextBuffer("Ceci est un test de la méthode toString");
    }

    @Test
    public void should_return_string_when_create_textbuffer_with_string_content(){
        //ARRANGE
        String expectedString = "Ceci est un test de la méthode toString";

        //ACT
        String string = textBuffer.toString();
        //ASSERT
        Assertions.assertEquals(expectedString,string);
    }


}
