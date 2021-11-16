package com.interview;

import java.util.Objects;

public class Location {
    int i;
    int j;

    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return i == location.i && j == location.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
