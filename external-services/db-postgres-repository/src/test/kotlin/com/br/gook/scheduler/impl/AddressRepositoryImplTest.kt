package com.br.gook.scheduler.impl

import com.br.gook.impl.AddressRepositoryImpl
import com.br.gook.repository.AddressRepository
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
class AddressRepositoryImplTest {

    private val addressRepository: AddressRepository = mockk()
    private val builderTest = BuilderTest()

    private val addressRepositoryImpl = AddressRepositoryImpl(addressRepository)

    @BeforeEach
    fun init() {
        clearMocks(addressRepository)
    }

    @Test
    fun `should save address successfully`() {
        every { addressRepository.findById(any()) } returns Optional.empty()
        every { addressRepository.save(any()) } returns builderTest.addressEntity

        val response = shouldNotThrowAny { addressRepositoryImpl.saveAddress(builderTest.addressOutputPort) }

        response shouldBe builderTest.addressOutputPort
    }

    @Test
    fun `should throw exception with save address successfully`() {
        every { addressRepository.findById(any()) } returns Optional.of(builderTest.addressEntity)

        val response =
            shouldThrowExactly<Exception> { addressRepositoryImpl.saveAddress(builderTest.addressOutputPort) }

        response shouldBe Exception("AddressRepositoryImpl.saveAddress - Address already saved with id - addressId: 1")
    }

    @Test
    fun `should find address successfully and not throw exception`() {
        every { addressRepository.findById(any()) } returns Optional.of(builderTest.addressEntity)

        val response = shouldNotThrowAny { addressRepositoryImpl.findAddressByIdOrThrow(builderTest.addressId) }

        response shouldBe builderTest.addressOutputPort
    }

    @Test
    fun `should throw exception with find address successfully`() {
        every { addressRepository.findById(any()) } returns Optional.empty()

        val response =
            shouldThrowExactly<Exception> { addressRepositoryImpl.findAddressByIdOrThrow(builderTest.addressId) }

        response shouldBe Exception("AddressRepositoryImpl.findAddressByIdOrThrow - Error to find Address - addressId: 1")
    }

    @Test
    fun `should update address successfully`() {
        every { addressRepository.save(any()) } returns builderTest.addressEntity

        val response = shouldNotThrowAny { addressRepositoryImpl.updateAddress(builderTest.addressOutputPort) }

        response shouldBe builderTest.addressOutputPort
    }

    @Test
    fun `should delete address successfully`() {
        every { addressRepository.delete(any()) } just Runs
        every { addressRepository.findById(any()) } returns Optional.of(builderTest.addressEntity)

        shouldNotThrowAny { addressRepositoryImpl.deleteAddress(builderTest.addressId) }
        verify(exactly = 1) { addressRepository.delete(any()) }
    }
}