// © 2019 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html
package org.unicode.icu.tool.cldrtoicu;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;

/**
 * A resource bundle value containing a sequence of elements. This is a very thin wrapper over an
 * immutable list, with a few additional constraints (e.g. cannot be empty).
 *
 * <p>Immutable and thread safe.
 */
public final class RbValue {
    private final ImmutableList<String> elements;

    /** Returns a resource bundle value of the given elements. */
    public static RbValue of(String... elements) {
        return of(Arrays.asList(elements));
    }

    /** Returns a resource bundle value of the given elements. */
    public static RbValue of(Iterable<String> elements) {
        return new RbValue(elements);
    }

    private RbValue(Iterable<String> elements) {
        this.elements = ImmutableList.copyOf(elements);
        checkArgument(!this.elements.isEmpty(), "Resource bundle values cannot be empty");
    }

    /** Returns the (non zero) number of elements in this value. */
    public int size() {
        return elements.size();
    }

    /** Returns the Nth element of this value. */
    public String getElement(int n) {
        return elements.get(n);
    }

    @Override public int hashCode() {
        return Objects.hashCode(elements);
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof  RbValue && elements.equals(((RbValue) obj).elements);
    }

    @Override public String toString() {
        return elements.toString();
    }
}
