

import fr.einfolearning.tp2.metiers.TextBuffer;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class TextBufferTest {
    private static Instant startedAt;
    private TextBuffer textBuffer;
    @BeforeEach
    public void initTextBuffer(){
        textBuffer = new TextBuffer("Ceci est un test de la méthode toString");
    }

    @AfterEach
    public void TextBufferNull(){
        textBuffer = null;
    }
    @BeforeAll
    public static void initStartingTime(){
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration(){
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt,endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée de tests : {0} ms",duration));
    }

    @Test
    public void should_return_string_when_create_textbuffer_with_string_content(){
        //ARRANGE
        String expectedString = "Ceci est un test de la méthode toString";
        TextBuffer textBuffer = new TextBuffer("Ceci est un test de la méthode toString");

        //ACT
        String string = textBuffer.toString();
        //ASSERT
        Assertions.assertEquals(expectedString,string);
    }

    @Test
    public void should_return_the_length_of_textBuffer(){
        //ARRANGE
        int expectedValue = "Ceci est un test de la méthode toString".length();
        //ACT
        int max = textBuffer.maxP();
        //ASSERT
        assertThat(max,is(expectedValue));
    }

    @Test
    public void should_return_same_inserted_string_when_insert_string(){
        // ARRANGE
        String expectedString = "test";
        int from = 4;
        int to = from+"test".length();
        // ACT
        textBuffer.ins("test",4);
        // ASSERT
        String stringInserted = textBuffer.substr(from,to);
        assertThat(stringInserted,is(expectedString));
    }

    @Test
    public void should_return_correct_string_when_correct_to_from_parameter(){
        // ARRANGE
        String expetedString = "test";
        int from = 1;
        int to = from+"test".length();

        //ACT
        textBuffer.ins("test",from);
        String substreString = textBuffer.substr(from,to);

        //ASSERT
        assertThat(substreString,is(expetedString));
    }

    @Test
    public void should_return_trunced_string_when_to_out_of_limit(){
        // ARRANGE
        int from = "Ceci est un test de la méthode toString".length()-6;
        int to = 200;
        String expectedString = "String";
        // ACT
        String subStringRes = textBuffer.substr(from,to);
        //ASSERT

        assertThat(subStringRes,is(expectedString));
    }
    @Test
    public void should_return_nothing_where_when_from_and_to_out_of_limit(){
        // ARRANGE

        int from = 200;
        int to = 200;
        String expectedString = "String";

        //ACT

        String subStringRes = textBuffer.substr(from,to);

        //ASSERT
        assertThat(subStringRes,is(""));
    }

    @Test
    public void should_delete_substring_where_when_from_and_correct(){
        //ARRANGE
        int from = 12;
        int to = 16;
        String expectedString = "Ceci est un  de la méthode toString";

        //ACT
        textBuffer.del(from,to);

        //ASSERT

        assertThat(textBuffer.toString(),is(expectedString));
    }

    @Test
    public void should_delete_trunced_substring_where_to_out_of_limit(){
        //ARRANGE
        int from = "Ceci est un test de la méthode toString".length()-6;
        int to = 200;
        String expectedString = "Ceci est un test de la méthode to";

        //ACT
        textBuffer.del(from,to);

        //ASSERT
        assertThat(textBuffer.toString(),is(expectedString));
    }

    @Test
    public void should_del_nothing_where_from_and_to_out_of_limit(){
        // ARRANGE
        int from = 200;
        int to = 200;

        String expectedString = "Ceci est un test de la méthode toString";

        //ACT
        textBuffer.del(from,to);

        //ASSERT
        assertThat(textBuffer.toString(),is(expectedString));
    }

    @Test
    public void should_return_inserted_text_when_position_superior_than_zero_and_inferior_than_textbuffer_length(){
        //ARRANGE
        int from = 10;
        int to = from+"text".length();
        String expectedString = "text";
        //ACT
            textBuffer.ins("text",10);
        //ASSERT
        String string = textBuffer.substr(from,to);
        assertThat(string,is(expectedString));
    }
    @Test
    public void from_shoul_not_be_inferior_than_0_in_del(){
        //ARRANGE
        int from = -1;
        int to = -1;
        String expectedString = "Ceci est un test de la méthode toString";

        //ACT
        textBuffer.del(from,to);

        //ASSERT
        assertThat(textBuffer.toString(),is(expectedString));
    }

    @Test
    public void from_shoul_not_be_inferior_than_0_in_substr(){
        //ARRANGE
        int from = -1;
        int to = -1;
        String expectedString = "";

        //ACT
        String substrectedText = textBuffer.substr(from,to);

        //ASSERT
        assertThat(substrectedText,is(expectedString));
    }


}
