package com.epam.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeEntity extends TextEntity {
    private List<TextEntity> childList;

    public CompositeEntity() {
        childList = new ArrayList<>();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public int size() {
        return childList.size();
    }

    public void addChild(TextEntity textComponent) {
        childList.add(textComponent);
    }

    @Override
    public String toString() {
        String content = "";
        for (TextEntity textEntity : childList) {
            if (textEntity.isLeaf()) {
                LeafEntity leaf = (LeafEntity) textEntity;
                content += leaf.toString();
            } else {
                CompositeEntity entity = (CompositeEntity) textEntity;
                content += entity.toString();
            }
        }
        return content;
    }
}
