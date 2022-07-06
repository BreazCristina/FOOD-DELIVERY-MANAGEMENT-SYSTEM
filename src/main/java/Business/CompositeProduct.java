package Business;

import java.util.ArrayList;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */

public class CompositeProduct extends MenuItem{

    private ArrayList<BaseProduct>  baseProductsList;
    String title;
    float rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;
    int number;
    public CompositeProduct(String name,  ArrayList<BaseProduct> list, int number)
    {
        float r=0;
        baseProductsList=list;
        title=name;
        float rating1=0;
        for(BaseProduct p : list) {
            this.calories =this.calories+ p.getCalories();
            this.protein = this.protein+ p.getProtein();
            this.fat = this.fat+ p.getFat();
            this.sodium = this.sodium+ p.getSodium();
            this.price = this.price+ p.getPrice();
            rating1= rating1+p.getRating();
        }
        this. rating = rating1 / list.size();

        this.number=0;
    }

    public ArrayList<BaseProduct> getBaseProductsList() {
        return baseProductsList;
    }

    public void setBaseProductsList(ArrayList<BaseProduct> baseProductsList) {
        this.baseProductsList = baseProductsList;
    }

    @Override
    public int computePrice() {
        int price=0;
        for(BaseProduct p1: baseProductsList)
            price=price+p1.getPrice();
        return price;
    }

    @Override
    public String toString() {
        return

                title + " alcatuit din:"+
                        baseProductsList + ","+
                        rating +","+
                        + calories +","+
                        + protein +","+
                        + fat +","+
                        + sodium +","+
                        + price ;

    }
}