package com.example.lab08;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {

    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.addCity(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
// This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDelete() {
        CustomList list = new CustomList();
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        assertTrue(list.hasCity(city)); // Check if the city is added
        list.delete(city);
        assertFalse(list.hasCity(city)); // Check if the city is deleted
    }

    @Test
    void testDeleteException() {
        CustomList cityList = mockCityList(); // This creates a list with "Edmonton"
        City city = new City("Regina", "Saskatchewan"); // A city that is not in the list

        // Assert that trying to delete a non-existent city throws the correct exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
}
