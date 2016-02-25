package com.example.plic.hoteliosijek.model;

public class Accommodation {

    int id;
    String name;
    String address;
    String city;
    String description;
    float rating;
    String image;
    String images;

    // Empty constructor
    public Accommodation(){

    }

    public Accommodation(String name, String address, String city, String description, String image, String images, float rating) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.description = description;
        this.image = image;
        this.images = images;
        this.rating = rating;
    }

    public Accommodation(int id, String name, String address, String city, String description, float rating, String image, String images) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.description = description;
        this.rating = rating;
        this.image = image;
        this.images = images;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
