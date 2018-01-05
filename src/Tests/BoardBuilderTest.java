package Tests;

import org.junit.Before;
import org.junit.Test;
import Client.*;
import java.lang.*;

import static org.junit.Assert.*;

public class BoardBuilderTest {

    Board testBoard;
    Field testField;

    // Testing creating of CCBoard based on 6 chosen fields

    @Before
    public void setUp() throws Exception
    {

        BoardDirector director = new BoardDirector();
        BoardBuilder builder = new CCBoard6P();
        director.setBuilder(builder);
        director.createBoard();
        testBoard = director.getBoard();

    }

    @Test
    public void creatingCCBoard() {
        testField = testBoard.getField(1, 1);
        Class testClass = testField.getClass();
        String name = testClass.getName();
        assertEquals(name, "Client.InaccessibleField");
    }
    @Test
    public void creatingCCBoard2() {
        testField = testBoard.getField(9, 3);
        Class testClass2 = testField.getClass();
        String name2 = testClass2.getName();
        assertEquals(name2, "Client.AccessibleField");
    }

    @Test
    public void creatingCCBoard3() {
        testField = testBoard.getField(11, 8);
        Class testClass3 = testField.getClass();
        String name3 = testClass3.getName();
        assertEquals(name3, "Client.AccessibleField");
    }

    @Test
    public void creatingCCBoard4()
    {
        testField = testBoard.getField(5,3);
        Class testClass4 = testField.getClass();
        String name4 = testClass4.getName();
        assertEquals(name4,"Client.WinningField");
    }

    @Test
    public void creatingCCBoard5()
    {
        testField = testBoard.getField(1,7);
        Class testClass4 = testField.getClass();
        String name4 = testClass4.getName();
        assertEquals(name4,"Client.WinningField");
    }

    @Test
    public void creatingCCBoard6()
    {
        testField = testBoard.getField(9,12);
        Class testClass4 = testField.getClass();
        String name4 = testClass4.getName();
        assertEquals(name4,"Client.InaccessibleField");
    }



}
