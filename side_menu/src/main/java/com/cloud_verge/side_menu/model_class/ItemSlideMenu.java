package com.cloud_verge.side_menu.model_class;

public class ItemSlideMenu {

    private int imgId;

    public ItemSlideMenu(int imgId) {
        this.imgId = imgId;
    }

    private String title;

    public ItemSlideMenu(String title) {
        this.title = title;
    }

    public ItemSlideMenu(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public ItemSlideMenu() {
        // empty constructor //
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
