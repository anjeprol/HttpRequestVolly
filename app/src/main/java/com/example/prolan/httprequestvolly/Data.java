package com.example.prolan.httprequestvolly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prolan on 27/01/2016.
 */
public class Data {
    String oneRecord;
    Data(String oneRecord){
        this.oneRecord = oneRecord;
    }
    private List<Data> data;
    public List<Data> initializeData(Data dataFO){
        data = new ArrayList<>();
        data.add(dataFO);
        return data;
    }
}
