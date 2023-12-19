import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class EmacsKillRingTest {
    private TextBuffer textBuffer;
    private EmacsKillRing emacsKillRing;

    @BeforeEach
    public void init(){
        emacsKillRing = new EmacsKillRing();
    }
    @Test
    public void should_throw_emacskillringoverflowexception_when_buffer_full(){
        //ACT
        try {
            for (int i = 0; i < emacsKillRing.MAX ;i++){
                emacsKillRing.add("test");
            }
        }catch (EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //ASSERT
        Assertions.assertThrows(EmacsKillRingOverflowException.class,()->{emacsKillRing.add("test");});
    }

    @Test
    public void should_return_string_added_in_add(){
        //ARRANGE
        String expectedValue = "Amgad";
        //ACT
        try{
            emacsKillRing.add("Amgad");

        }catch (EmacsKillRingOverflowException e){
            Assertions.fail();
        }
        String string = emacsKillRing.currentElt();
        //ASSERT
        Assertions.assertEquals(expectedValue,string);

    }

}
