package com.epam.task2.entity;

/**
 * Leaf is a class that can't has children :(
 */
public class LeafEntity extends TextEntity {
    private String content;

    public LeafEntity(String content) {
        this.content = content;
    }

    public LeafEntity() {
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public int size() {
        return  this.content.length();
    }

    @Override
    public String toString(){
        return content;
    }

    public String getContent(){return content;}
}
