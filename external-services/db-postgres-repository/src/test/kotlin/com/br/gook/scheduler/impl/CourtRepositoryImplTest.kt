package com.br.gook.scheduler.impl

import com.br.gook.impl.CourtRepositoryImpl
import com.br.gook.repository.CourtRepository
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
class CourtRepositoryImplTest {

    private val courtRepository: CourtRepository = mockk()
    private val builderTest = BuilderTest()

    private val courtRepositoryImpl = CourtRepositoryImpl(courtRepository)

    @BeforeEach
    fun init() {
        clearMocks(courtRepository)
    }

    @Test
    fun `should save court successfully`() {
        every { courtRepository.findById(any()) } returns Optional.empty()
        every { courtRepository.save(any()) } returns builderTest.courtEntity

        val response = shouldNotThrowAny { courtRepositoryImpl.saveCourt(builderTest.courtOutputPort) }

        response shouldBe builderTest.courtOutputPort
    }

    @Test
    fun `should throw exception with save court successfully`() {
        every { courtRepository.findById(any()) } returns Optional.of(builderTest.courtEntity)

        val response =
            shouldThrowExactly<Exception> { courtRepositoryImpl.saveCourt(builderTest.courtOutputPort) }

        response shouldBe Exception("CourtRepositoryImpl.saveCourt - Court already saved with id - courtId: 1")
    }

    @Test
    fun `should find court successfully and not throw exception`() {
        every { courtRepository.findById(any()) } returns Optional.of(builderTest.courtEntity)

        val response = shouldNotThrowAny { courtRepositoryImpl.findCourtByIdOrThrow(builderTest.courtId) }

        response shouldBe builderTest.courtOutputPort
    }

    @Test
    fun `should throw exception with find court successfully`() {
        every { courtRepository.findById(any()) } returns Optional.empty()

        val response =
            shouldThrowExactly<Exception> { courtRepositoryImpl.findCourtByIdOrThrow(builderTest.courtId) }

        response shouldBe Exception("CourtRepositoryImpl.findCourtByIdOrThrow - Error to find Court - courtId: 1")
    }

    @Test
    fun `should update court successfully`() {
        every { courtRepository.save(any()) } returns builderTest.courtEntity

        val response = shouldNotThrowAny { courtRepositoryImpl.updateCourt(builderTest.courtOutputPort) }

        response shouldBe builderTest.courtOutputPort
    }

    @Test
    fun `should delete court successfully`() {
        every { courtRepository.delete(any()) } just Runs
        every { courtRepository.findById(any()) } returns Optional.of(builderTest.courtEntity)

        shouldNotThrowAny { courtRepositoryImpl.deleteCourt(builderTest.courtId) }
        verify(exactly = 1) { courtRepository.delete(any()) }
    }
}