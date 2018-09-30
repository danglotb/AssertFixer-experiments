package org.nve.persistence.dao

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.test.assertTrue


@RunWith(PowerMockRunner::class)
@PrepareForTest(

)

class CreditTransactionsEntityTest {

    @Test
    fun creditTransactionsEntityEqualsTest() {

        var objectOne = CreditTransactionsEntity()
        var objectTwo = objectOne

        assertTrue(objectOne.equals(objectTwo))

    }

    @Test
    fun creditTransactionsEntityHashCodeTest() {

        var objectOne = CreditTransactionsEntity()
        objectOne.id = 1
        objectOne.amount = 3.5

        assertThat(objectOne.hashCode(), !equalTo(0))

    }
}