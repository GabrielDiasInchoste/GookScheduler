package com.br.gook.scheduler.impl

import com.br.gook.impl.LocalRepositoryImpl
import com.br.gook.repository.LocalRepository
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
class LocalRepositoryImplTest {

    private val localRepository: LocalRepository = mockk()
    private val builderTest = BuilderTest()

    private val localRepositoryImpl = LocalRepositoryImpl(localRepository)

    @BeforeEach
    fun init() {
        clearMocks(localRepository)
    }

    @Test
    fun `should save local successfully`() {
        every { localRepository.findById(any()) } returns Optional.empty()
        every { localRepository.save(any()) } returns builderTest.localEntity

        val response = shouldNotThrowAny { localRepositoryImpl.saveLocal(builderTest.localOutputPort) }

        response shouldBe builderTest.localOutputPort
    }

    @Test
    fun `should throw exception with save local successfully`() {
        every { localRepository.findById(any()) } returns Optional.of(builderTest.localEntity)

        val response =
            shouldThrowExactly<Exception> { localRepositoryImpl.saveLocal(builderTest.localOutputPort) }

        response shouldBe Exception("LocalRepositoryImpl.saveLocal - Local already saved with id - localId: 1")
    }

    @Test
    fun `should find local successfully and not throw exception`() {
        every { localRepository.findById(any()) } returns Optional.of(builderTest.localEntity)

        val response = shouldNotThrowAny { localRepositoryImpl.findLocalByIdOrThrow(builderTest.localId) }

        response shouldBe builderTest.localOutputPort
    }

    @Test
    fun `should throw exception with find local successfully`() {
        every { localRepository.findById(any()) } returns Optional.empty()

        val response =
            shouldThrowExactly<Exception> { localRepositoryImpl.findLocalByIdOrThrow(builderTest.localId) }

        response shouldBe Exception("LocalRepositoryImpl.findLocalByIdOrThrow - Error to find Local - localId: 1")
    }

    @Test
    fun `should update local successfully`() {
        every { localRepository.save(any()) } returns builderTest.localEntity

        val response = shouldNotThrowAny { localRepositoryImpl.updateLocal(builderTest.localOutputPort) }

        response shouldBe builderTest.localOutputPort
    }

    @Test
    fun `should delete local successfully`() {
        every { localRepository.delete(any()) } just Runs
        every { localRepository.findById(any()) } returns Optional.of(builderTest.localEntity)

        shouldNotThrowAny { localRepositoryImpl.deleteLocal(builderTest.localId) }
        verify(exactly = 1) { localRepository.delete(any()) }
    }
}