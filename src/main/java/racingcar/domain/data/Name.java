package racingcar.domain.data;

import racingcar.domain.validation.NameValidation;

import java.util.Objects;

public class Name {
    private static int NAME_MAX_LENGTH = 5;
    private final String value;

    Name(final String value) {
        NameValidation.validateName(value.trim(), NAME_MAX_LENGTH);
        this.value = value.trim();
    }

    String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
