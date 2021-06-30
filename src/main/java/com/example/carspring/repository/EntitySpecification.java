package com.example.carspring.repository;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class EntitySpecification {

    public static <T> Specification<T> textInAllColumns(String text) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        final String finalText = text;

        return (Specification<T>) (root, cq, builder) ->
                builder.or(root.getModel()
                        .getDeclaredSingularAttributes()
                        .stream()
                        .filter(a -> a.getJavaType()
                                .getSimpleName().equalsIgnoreCase("string"))
                        .map(a -> builder.like(root.get(a.getName()), finalText)
                        ).toArray(Predicate[]::new)
                );
    }
}
