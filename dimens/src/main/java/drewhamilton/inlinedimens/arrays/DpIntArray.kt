package drewhamilton.inlinedimens.arrays

import drewhamilton.inlinedimens.DpInt
import drewhamilton.inlinedimens.iterators.DpIntIterator

/**
 * An array of [DpInt]. When compiled, instances of this class are inlined to int[] on the JVM.
 */
inline class DpIntArray(internal val ints: IntArray) {

    constructor(size: Int, init: (index: Int) -> DpInt) : this(IntArray(size) { index -> init(index).value })

    /**
     * Returns the array element at the given [index]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun get(index: Int): DpInt = DpInt(ints[index])

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS where
     * the behavior is unspecified.
     */
    operator fun set(index: Int, value: DpInt) {
        ints[index] = value.value
    }

    /** Returns the number of elements in the array. */
    val size: Int get() = ints.size

    /** Creates an iterator over the elements of the array. */
    operator fun iterator(): DpIntIterator = DpIntIterator(ints.iterator())
}

fun Array<DpInt>.toDpIntArray() = DpIntArray(IntArray(size) { index -> this[index].value })
