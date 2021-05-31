package dev.drewhamilton.inlinedimens.iterators

import dev.drewhamilton.inlinedimens.SpInt

/**
 * An iterator over a sequence of values of type [SpInt].
 */
@JvmInline
value class SpIntIterator(private val intIterator: IntIterator) : Iterator<SpInt> {
    override fun hasNext() = intIterator.hasNext()
    override fun next() = SpInt(intIterator.next())

    /** Returns the next value in the sequence without boxing. */
    fun nextSpInt(): SpInt = SpInt(intIterator.nextInt())
}
