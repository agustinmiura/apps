package ar.com.miura.unitetesting.business

import ar.com.miura.unitetesting.service.DataService
import ar.com.miura.unitetesting.service.IDataService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Business implementation
 */
class Business(@Autowired private val dataService: IDataService) {

    fun calculateSum(data: List<Int>):Int {
        var sum = 0
        for(eachInt in data) {
            sum+=eachInt
        }
        return sum
    }

    fun calculateUsingDataService():Int {
        var sum = 0
        var integers:List<Int> = dataService.getData()
        for(eachInt in integers) {
            sum+=eachInt
        }
        return sum
    }
}