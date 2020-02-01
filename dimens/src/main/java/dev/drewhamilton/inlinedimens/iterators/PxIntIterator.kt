package dev.drewhamilton.inlinedimens.iterators

import dev.drewhamilton.inlinedimens.PxInt

/**
 * An iterator over a sequence of values of type [PxInt].
 */
inline class PxIntIterator(private val intIterator: IntIterator) : Iterator<PxInt> {
    override fun hasNext() = intIterator.hasNext()
    override fun next() = PxInt(intIterator.next())

    /** Returns the next value in the sequence without boxing. */
    fun nextPxInt(): PxInt = PxInt(intIterator.nextInt())
}
