package racingcar.domain.data;

import racingcar.utils.exception.InvalidNameLengthException;
import racingcar.utils.exception.InvalidTextException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
    private static int NAME_MAX_LENGTH = 5;
    private final String value;

    private static final Pattern TEXT_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");


    Name(final String value) {
        validateName(value.trim(), NAME_MAX_LENGTH);
        this.value = value.trim();
    }

    String value() {
        return value;
    }

    public static void validateName(String name, int maxLength) {
        isValidLength(name, maxLength);
        isValidText(name);
    }

    private static void isValidLength(String value, int maxLength) {
        if (value.length() <= 0 || value.length() > maxLength) {
            throw new InvalidNameLengthException(maxLength);
        }
    }

    private static void isValidText(String name) {
        if (!TEXT_PATTERN.matcher(name).matches()) {
            throw new InvalidTextException();
        }
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
