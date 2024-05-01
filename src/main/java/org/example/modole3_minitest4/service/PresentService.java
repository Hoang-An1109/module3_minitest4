package org.example.modole3_minitest4.service;

import org.example.modole3_minitest4.model.Present;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PresentService implements IPresentService {

    public static List<Present> presentList= new ArrayList<>();

    static {
        presentList.add(new Present(1, "ABC123", "Product 1", 10.99, "Free", "image1.jpg"));
        presentList.add(new Present(2, "DEF456", "Product 2", 19.99, "Standard", "image2.jpg"));
        presentList.add(new Present(3, "GHI789", "Product 3", 29.99, "Express", "image3.jpg"));
        presentList.add(new Present(4, "JKL012", "Product 4", 14.99, "Standard", "image4.jpg"));
        presentList.add(new Present(5, "MNO345", "Product 5", 24.99, "Free", "image5.jpg"));
    }


    @Override
    public List<Present> findAll() {
        return presentList;
    }

    @Override
    public void save(Present present) {

        presentList.add(present);
    }

    @Override
    public Present findById(int id) {
        return presentList.get(id);
    }

    @Override
    public void update(int id, Present present) {

        presentList.add(id,present);
    }

    @Override
    public void remove(int id) {

        presentList.remove(id);
    }
}
