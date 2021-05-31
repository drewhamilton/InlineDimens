package dev.drewhamilton.inlinedimens.arrays

import dev.drewhamilton.inlinedimens.SpInt
import dev.drewhamilton.inlinedimens.iterators.SpIntIterator

/**
 * An array of [SpInt]. When compiled, instances of this class are inlined to int[] on the JVM.
 */
@JvmInline
value class SpIntArray(internal val values: IntArray) {

    constructor(size: Int, init: (index: Int) -> SpInt) : this(IntArray(size) { index -> init(index).value })

    /**
     * Returns the array element at the given [index]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun get(index: Int): SpInt = SpInt(values[index])

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun set(index: Int, value: SpInt) {
        values[index] = value.value
    }

    /** Returns the number of elements in the array. */
    val size: Int get() = values.size

    /** Creates an iterator over the elements of the array. */
    operator fun iterator(): SpIntIterator = SpIntIterator(values.iterator())
}

fun Array<SpInt>.toSpIntArray() = SpIntArray(IntArray(size) { index -> this[index].value })
