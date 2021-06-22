package ar.com.miura.unitetesting

import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Captor
import org.mockito.Mockito
import org.mockito.Mockito.atLeast
import org.mockito.Mockito.atMost
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class ListMockTestCase {

    private val list:MutableList<String> = Mockito.mock(MutableList::class.java) as MutableList<String>

    /**
     * Kotlin workaround for argument captor :
     * https://stackoverflow.com/questions/65931441/mockito-kotlin-test-throws-null-pointer-exception-when-trying-to-capture-pagea
     * TODO : improve
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T> capture(captor: ArgumentCaptor<T>): T = captor.capture()

    @Captor
    lateinit var stringCapture: ArgumentCaptor<String>

    @Test
    fun test() {
        Mockito.`when`(list.size).thenReturn(5)
        assertEquals(5, list.size)
    }

    @Test
    fun returnDifferentValues() {
        Mockito.`when`(list.size).thenReturn(5).thenReturn(10)
        assertEquals(5, list.size)
        assertEquals(10, list.size)
    }

    @Test
    fun returnWithParameters() {
        Mockito.`when`(list.get(0)).thenReturn("sampleString")
        assertEquals("sampleString", list.get(0))
    }

    @Test
    fun returnWithGenericParameter() {
        Mockito.`when`(list.get(anyInt())).thenReturn("sampleString")
        assertEquals("sampleString", list.get(0))
        assertEquals("sampleString", list.get(10))
    }

    @Test
    fun verifyBasics() {
        list.get(0)
        list.get(1)
        Mockito.verify(list).get(0)
        Mockito.verify(list, times(2)).get(anyInt())
        Mockito.verify(list, atLeast(2)).get(anyInt())
        Mockito.verify(list, atMost(2)).get(anyInt())
        Mockito.verify(list, never()).get(2)
    }

    @Test
    fun argumentCapturing() {
        val captor:ArgumentCaptor<String> = ArgumentCaptor.forClass(String::class.java)
        list.add("someString")
        Mockito.verify(list).add(capture(captor))
        assertEquals("someString", captor.value)
    }

    @Test
    fun multiArgCapture() {
        val captor:ArgumentCaptor<String> = ArgumentCaptor.forClass(String::class.java)

        list.add("someString1")
        list.add("someString2")

        Mockito.verify(list, times(2)).add(capture(captor))

        val strings = captor.allValues

        assertEquals("someString1", strings[0])
        assertEquals("someString2", strings[1])
    }

    @Test
    fun spying() {
        var arrayListMock:MutableList<String> = Mockito.spy(MutableList::class.java) as MutableList<String>
        arrayListMock.add("test")
        println(arrayListMock.get(0))
        println(arrayListMock.size)
        arrayListMock.add("Test1")
        arrayListMock.add("Test2")
        println(arrayListMock.size)
        Mockito.`when`(arrayListMock.size).thenReturn(5)
        println(arrayListMock.size)
        verify(arrayListMock).add("Test2")
    }

}