package drewhamilton.inlinedimens.iterators

import drewhamilton.inlinedimens.DpInt

/**
 * An iterator over a sequence of values of type [DpInt].
 */
inline class DpIntIterator(private val intIterator: IntIterator) : Iterator<DpInt> {
    override fun hasNext() = intIterator.hasNext()
    override fun next() = DpInt(intIterator.next())

    /** Returns the next value in the sequence without boxing. */
    fun nextDpInt(): DpInt = DpInt(intIterator.nextInt())
}