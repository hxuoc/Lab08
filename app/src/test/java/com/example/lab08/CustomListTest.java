package com.example.lab08;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
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
        CityList cityList = new CityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertTrue(cityList.hasCity(city)); // Check if the city is added
        cityList.delete(city);
        assertFalse(cityList.hasCity(city)); // Check if the city is deleted
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList(); // This creates a list with "Edmonton"
        City city = new City("Regina", "Saskatchewan"); // A city that is not in the list

        // Assert that trying to delete a non-existent city throws the correct exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
}
