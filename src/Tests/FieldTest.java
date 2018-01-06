package Tests;

import Client.AccessibleField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    AccessibleField testField;

    @Before
    public void setUp() throws Exception
    {
        testField = new AccessibleField(0,0);
    }

    @Test
    public void setNewCoordinatetes()
    {
        testField.setNewCoordinatetes(1,2);
        assertEquals(1, testField.getCoordinateX());
        assertEquals(2, testField.getCoordinateY());
    }

    @Test
    public void getCoordinateX()
    {
        testField = new AccessibleField(10,0);
        assertEquals(10, testField.getCoordinateX());
    }

    @Test
    public void getCoordinateY()
    {
        testField = new AccessibleField(0,10);
        assertEquals(10, testField.getCoordinateY());
    }
}