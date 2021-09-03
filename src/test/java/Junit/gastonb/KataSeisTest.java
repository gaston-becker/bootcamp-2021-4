package junit.gastonb;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class KataSeisTest {

    @Test
    public void example() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }
    @Test
    public void example2() {
        final String input = "fox,bear,chicken,grass,sheep,antelope";
        final String[] expected = 	{
                "fox,bear,chicken,grass,sheep,antelope",
                "bear eats chicken",
                "sheep eats grass",
                "bear eats sheep",
                "fox,bear,antelope"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }
    @Test
    public void example3() {//ningun animal se come
        final String input = "fox,bear,little-fish,bug,sheep,antelope";
        final String[] expected = 	{
                "fox,bear,little-fish,bug,sheep,antelope",
                "fox,bear,little-fish,bug,sheep,antelope"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }
    @Test
    public void example4() {//un solo animal
        final String input = "fox";
        final String[] expected = 	{
                "fox",
                "fox"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }
    @Test
    public void example5() {//un solo animal / animal q no exista
        final String input = "monkey";
        final String[] expected = 	{
                "monkey",
                "monkey"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }
    @Test
    public void example6() {//un solo animal / animal q no exista
        final String input = "giraffe,bear,panda";
        final String[] expected = 	{
                "giraffe,bear,panda",
                "giraffe,bear,panda"};
        assertArrayEquals(expected, KataSeis.whoEatsWho(input));
    }

}