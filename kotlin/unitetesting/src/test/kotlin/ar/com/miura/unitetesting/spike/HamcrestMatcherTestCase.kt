package ar.com.miura.unitetesting.spike

import org.junit.jupiter.api.Test
import org.hamcrest.CoreMatchers.everyItem
import org.hamcrest.CoreMatchers.hasItems
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.endsWith
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.isEmptyString
import org.hamcrest.Matchers.lessThan
import org.hamcrest.Matchers.startsWith
import java.util.*

class HamcrestMatcherTestCase {

    @Test
    fun learning() {
        val values = Arrays.asList(12,15,45)
        assertThat(values, hasSize(3))
        assertThat(values, hasItems(12,45))
        assertThat(values, everyItem(greaterThan(10)))
        assertThat(values, everyItem(lessThan(100)))

        assertThat("", isEmptyString())
        assertThat("ABCDE", containsString("BCD"))
        assertThat("ABCDE", startsWith("ABC"))
        assertThat("ABCDE", endsWith("CDE"))
    }

}