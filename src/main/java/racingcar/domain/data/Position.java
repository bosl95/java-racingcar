package racingcar.domain.data;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public boolean isSameAs(int maxPosition) {
        return this.value == maxPosition;
    }

    public boolean isBigger(int maxPosition) {
        return value > maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
