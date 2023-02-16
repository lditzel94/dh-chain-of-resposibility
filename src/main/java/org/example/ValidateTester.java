package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ValidateTester {
    @NotNull
    static Function<Tester, Boolean> validateFor( Product product ) {
        return tester -> tester.validate( product );
    }
}