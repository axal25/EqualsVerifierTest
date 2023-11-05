package oles.jacek;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public final class PojoRedefinedSubclass extends Pojo {
    private final Pojo pojo;

    public PojoRedefinedSubclass(Integer id, String name) {
        super();
        this.pojo = new Pojo(id, name);
    }
}
