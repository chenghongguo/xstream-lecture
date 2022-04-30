package com.hongguo.xstream.test.alias;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private Author writer;
    private List<Entity> entries = new ArrayList<>();

    public Blog(Author writer) {
        this.writer = writer;
    }

    public void add(Entity entity) {
        this.entries.add(entity);
    }

    public List<Entity> getContent() {
        return this.entries;
    }
}
