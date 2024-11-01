
package dynamicProgramming

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WeightedJobSchedulingSapientGeneratedTest {

    @Test
    fun testFindLastNonConflictingJob() {
        val jobs = listOf(
            Job(1, 3, 5),
            Job(2, 5, 6),
            Job(4, 6, 5),
            Job(6, 7, 4),
            Job(5, 8, 11),
            Job(7, 9, 2)
        )
        assertEquals(2, findLastNonConflictingJob(jobs, 4))
        assertEquals(-1, findLastNonConflictingJob(jobs, 0))
        assertEquals(3, findLastNonConflictingJob(jobs, 5))
    }

    @Test
    fun testFindMaxProfit() {
        val jobs = listOf(
            Job(1, 3, 5),
            Job(2, 5, 6),
            Job(4, 6, 5),
            Job(6, 7, 4),
            Job(5, 8, 11),
            Job(7, 9, 2)
        )
        assertEquals(17, findMaxProfit(jobs))
    }

    @Test
    fun testFindMaxProfitWithSingleJob() {
        val jobs = listOf(Job(1, 2, 5))
        assertEquals(5, findMaxProfit(jobs))
    }

    @Test
    fun testFindMaxProfitWithNoJobs() {
        val jobs = emptyList<Job>()
        assertEquals(0, findMaxProfit(jobs))
    }

    @ParameterizedTest
    @MethodSource("provideJobsForMaxProfit")
    fun testFindMaxProfitWithVariousInputs(jobs: List<Job>, expectedProfit: Int) {
        assertEquals(expectedProfit, findMaxProfit(jobs))
    }

    companion object {
        @JvmStatic
        fun provideJobsForMaxProfit(): Stream<Array<Any>> {
            return Stream.of(
                arrayOf(listOf(Job(1, 2, 50), Job(3, 5, 20), Job(6, 19, 100), Job(2, 100, 200)), 250),
                arrayOf(listOf(Job(1, 2, 5), Job(1, 5, 20), Job(3, 6, 10)), 20),
                arrayOf(listOf(Job(1, 3, 5), Job(2, 4, 6), Job(3, 5, 7)), 13)
            )
        }
    }

    @Test
    fun testJobClass() {
        val job = Job(1, 3, 5)
        assertEquals(1, job.start)
        assertEquals(3, job.finish)
        assertEquals(5, job.profit)
    }

    @Test
    fun testFindLastNonConflictingJobEdgeCases() {
        val jobs = listOf(
            Job(1, 2, 1),
            Job(2, 3, 2),
            Job(3, 4, 3)
        )
        assertEquals(-1, findLastNonConflictingJob(jobs, 0))
        assertEquals(0, findLastNonConflictingJob(jobs, 1))
        assertEquals(1, findLastNonConflictingJob(jobs, 2))
    }

    @Test
    fun testFindMaxProfitWithOverlappingJobs() {
        val jobs = listOf(
            Job(1, 4, 3),
            Job(2, 6, 5),
            Job(4, 7, 2),
            Job(5, 9, 4),
            Job(6, 8, 6)
        )
        assertEquals(8, findMaxProfit(jobs))
    }
}
