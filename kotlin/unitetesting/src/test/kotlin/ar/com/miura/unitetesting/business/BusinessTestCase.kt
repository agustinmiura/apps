package ar.com.miura.unitetesting.business

import ar.com.miura.unitetesting.service.IDataService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BusinessTestCase {

    @Mock
    lateinit var mockService:IDataService

    @Test
    fun shouldFindSum() {
        val numbers:List<Int> = listOf(1,2,3)
        val business = Business(DataServiceStub())
        val sum = business.calculateSum(numbers)
        assertEquals(sum, 6)
    }

    @Test
    fun shouldFindEmpty() {
        val numbers:List<Int> = listOf()
        val business = Business(EmptyDataServiceStub())
        val sum = business.calculateUsingDataService()
        assertEquals(sum, 0)
    }

    @Test
    fun shouldFindSumWithMocks() {
        Mockito.`when`(mockService.getData()).thenReturn(listOf(1,2,3))
        val business = Business(mockService)
        val sum = business.calculateUsingDataService()
        assertEquals(sum, 6)
    }

    @Test
    fun shouldFindSumEmptyListMocks() {
        Mockito.`when`(mockService.getData()).thenReturn(listOf())
        val business = Business(mockService)
        val sum = business.calculateUsingDataService()
        assertEquals(sum, 0)
    }

}

class DataServiceStub: IDataService {
    override fun getData(): List<Int> {
        return listOf(1,2,3)
    }
}

class EmptyDataServiceStub:IDataService {
    override fun getData(): List<Int> {
        return listOf(0)
    }
}
