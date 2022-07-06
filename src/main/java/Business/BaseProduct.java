package Business;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */

public class BaseProduct extends MenuItem implements Serializable {

    String title;
    float rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;
    int number;

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price,int number)
    {
        this.title=title;
        this.rating=rating;
        this.calories=calories;
        this.protein=protein;
        this.fat=fat;
        this.sodium=sodium;
        this.fat=fat;
        this.price=price;
        this.number=0;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int computePrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return
                title + "," +
                        + rating +
                        ","+ calories +
                        "," + protein +
                        ","+ fat +
                        "," + sodium +
                        "," + price

                ;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}