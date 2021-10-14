package com.br.gook.scheduler.impl

import com.br.gook.impl.SchedulerRepositoryImpl
import com.br.gook.repository.SchedulerRepository
import com.br.gook.scheduler.BuilderTest
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.mockk.*
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class SchedulerRepositoryImplTest {

    private val schedulerRepository: SchedulerRepository = mockk()
    private val builderTest = BuilderTest()

    private val schedulerRepositoryImpl = SchedulerRepositoryImpl(schedulerRepository)

    @BeforeEach
    fun init() {
        clearMocks(schedulerRepository)
    }

    @Test
    fun `should save scheduler successfully`() {
        every { schedulerRepository.findById(any()) } returns Optional.empty()
        every { schedulerRepository.save(any()) } returns builderTest.schedulerEntity

        val response = shouldNotThrowAny { schedulerRepositoryImpl.saveScheduler(builderTest.schedulerOutputPort) }

        response shouldBe builderTest.schedulerOutputPort
    }

    @Test
    fun `should throw exception with save scheduler successfully`() {
        every { schedulerRepository.findById(any()) } returns Optional.of(builderTest.schedulerEntity)

        val response =
            shouldThrowExactly<Exception> { schedulerRepositoryImpl.saveScheduler(builderTest.schedulerOutputPort) }

        response shouldBe Exception("SchedulerRepositoryImpl.saveScheduler - Scheduler already saved with id - schedulerId: 1")
    }

    @Test
    fun `should find scheduler successfully and not throw exception`() {
        every { schedulerRepository.findById(any()) } returns Optional.of(builderTest.schedulerEntity)

        val response = shouldNotThrowAny { schedulerRepositoryImpl.findSchedulerByIdOrThrow(builderTest.schedulerId) }

        response shouldBe builderTest.schedulerOutputPort
    }

    @Test
    fun `should throw exception with find scheduler successfully`() {
        every { schedulerRepository.findById(any()) } returns Optional.empty()

        val response =
            shouldThrowExactly<Exception> { schedulerRepositoryImpl.findSchedulerByIdOrThrow(builderTest.schedulerId) }

        response shouldBe Exception("SchedulerRepositoryImpl.findSchedulerByIdOrThrow - Error to find Scheduler - schedulerId: 1")
    }

    @Test
    fun `should update scheduler successfully`() {
        every { schedulerRepository.save(any()) } returns builderTest.schedulerEntity

        val response = shouldNotThrowAny { schedulerRepositoryImpl.updateScheduler(builderTest.schedulerOutputPort) }

        response shouldBe builderTest.schedulerOutputPort
    }
}