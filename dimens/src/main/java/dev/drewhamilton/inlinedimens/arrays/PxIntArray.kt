package dev.drewhamilton.inlinedimens.arrays

import dev.drewhamilton.inlinedimens.PxInt
import dev.drewhamilton.inlinedimens.iterators.PxIntIterator

/**
 * An array of [PxInt]. When compiled, instances of this class are inlined to int[] on the JVM.
 */
@JvmInline
value class PxIntArray(internal val values: IntArray) {

    constructor(size: Int, init: (index: Int) -> PxInt) : this(IntArray(size) { index -> init(index).value })

    /**
     * Returns the array element at the given [index]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun get(index: Int): PxInt = PxInt(values[index])

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun set(index: Int, value: PxInt) {
        values[index] = value.value
    }

    /** Returns the number of elements in the array. */
    val size: Int get() = values.size

    /** Creates an iterator over the elements of the array. */
    operator fun iterator(): PxIntIterator = PxIntIterator(values.iterator())
}

fun Array<PxInt>.toPxIntArray() = PxIntArray(IntArray(size) { index -> this[index].value })
