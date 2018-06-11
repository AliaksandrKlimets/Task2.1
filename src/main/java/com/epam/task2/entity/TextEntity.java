package com.epam.task2.entity;

/**
 * Abstract class using like a parent for Composite Entities and Leafs
 */

public abstract class TextEntity {

    public abstract boolean isLeaf();
    public abstract int size();
}
