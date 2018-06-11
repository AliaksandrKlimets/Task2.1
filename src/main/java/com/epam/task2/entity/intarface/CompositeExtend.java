package com.epam.task2.entity.intarface;

import com.epam.task2.entity.TextEntity;
import java.util.List;

public interface CompositeExtend {
    void addChild(TextEntity textComponent);
    void removeChild(TextEntity textComponent);
    List<TextEntity> getChildList();
    void setChildList(List<TextEntity> list);
}
