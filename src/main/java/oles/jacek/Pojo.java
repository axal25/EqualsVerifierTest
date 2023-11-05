package oles.jacek;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Pojo {
    private final Integer id;
    private final String name;

    protected Pojo() {
        id = null;
        name = null;
    }
}
