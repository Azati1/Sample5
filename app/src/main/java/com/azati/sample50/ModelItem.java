package com.azati.sample50;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azati on 11.10.2017.
 */

class ModelItem {
    private String name;
    private int imgId;
    private String priceInRub;

    public ModelItem(String author, int imgId, int priceInRub) {
        this.name = author;
        this.imgId = imgId;
        this.priceInRub = getUsefulPrice(priceInRub);
    }

    public int getImgId() {
        return imgId;
    }

    public String getAuthor() {
        return name;
    }

    public String getPriceInRub() {
        return priceInRub;
    }

    public static List<ModelItem> getFakeItems() {
        ArrayList<ModelItem> itemsList = new ArrayList<>();
        itemsList.add(new ModelItem("Nissan NSX", R.drawable.crowned_nsx, 1000));
        itemsList.add(new ModelItem("Lamborghini Aventador", R.drawable.crowned_aventador, 2000));
        itemsList.add(new ModelItem("Ferrari F40", R.drawable.crowned_f40, 3000));
        itemsList.add(new ModelItem("Lamborghini Murcielago", R.drawable.crowned_murcielago,5000));
        return itemsList;
    }

    private String getUsefulPrice(int price){
        String uPrice = "";
        String p = String.valueOf(price);
        int length = p.length();
        while (length > 0) {
            if (length%3 == 0 && length!=p.length())
                uPrice += " ";
            uPrice += price / (int)Math.pow(10, (length-1));
            int dest = (price / (int)Math.pow(10, (length-1)));
            int m = (int)Math.pow(10, (length-1));
            price -= (price / (int)Math.pow(10, (length-1))) * (int)Math.pow(10, (length-1));
            length--;
        }
        uPrice += " RUB";
        return uPrice;
    }
}
