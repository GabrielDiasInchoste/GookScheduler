package com.br.gook.scheduler.impl

import com.br.gook.impl.CancelRepositoryImpl
import com.br.gook.repository.CancelRepository
import com.br.gook.repository.SchedulerRepository
import com.br.gook.scheduler.BuilderTest
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class CancelRepositoryImplTest {

    private val cancelRepository: CancelRepository = mockk()
    private val schedulerRepository: SchedulerRepository = mockk()

    private val builderTest = BuilderTest()

    private val cancelRepositoryImpl = CancelRepositoryImpl(cancelRepository, schedulerRepository)

    @BeforeEach
    fun init() {
        clearMocks(cancelRepository, schedulerRepository)
    }

    @Test
    fun `should save cancel successfully`() {
        every { cancelRepository.findById(any()) } returns Optional.empty()
        every { schedulerRepository.save(any()) } returns builderTest.schedulerEntity

        val response = shouldNotThrowAny { cancelRepositoryImpl.saveCancel(builderTest.schedulerOutputPort) }

        response shouldBe builderTest.schedulerOutputPort
    }

    @Test
    fun `should find cancel successfully and not throw exception`() {
        every { cancelRepository.findById(any()) } returns Optional.of(builderTest.cancelEntity)

        val response = shouldNotThrowAny { cancelRepositoryImpl.findCancelByIdOrThrow(builderTest.cancelId) }

        response shouldBe builderTest.cancelOutputPort
    }

    @Test
    fun `should throw exception with find cancel successfully`() {
        every { cancelRepository.findById(any()) } returns Optional.empty()

        val response =
            shouldThrowExactly<Exception> { cancelRepositoryImpl.findCancelByIdOrThrow(builderTest.cancelId) }

        response shouldBe Exception("CancelRepositoryImpl.findCancelByIdOrThrow - Error to find Cancel - cancelId: 1")
    }

    @Test
    fun `should update cancel successfully`() {
        every { cancelRepository.save(any()) } returns builderTest.cancelEntity

        val response = shouldNotThrowAny { cancelRepositoryImpl.updateCancel(builderTest.cancelOutputPort) }

        response shouldBe builderTest.cancelOutputPort
    }
}