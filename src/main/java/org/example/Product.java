package org.example;

public record Product(
        String name,
        Integer batch,
        Integer weight,
        String packaging
) {
}
