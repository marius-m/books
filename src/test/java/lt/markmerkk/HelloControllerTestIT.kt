package lt.markmerkk

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Ignore
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.web.client.TestRestTemplate
import java.net.URL


/**
 * @author mariusmerkevicius
 * *
 * @since 2016-11-03
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
class HelloControllerTestIT {

    @LocalServerPort
    private var port: Int = 0

    lateinit private var base: URL

    @Autowired
    lateinit private var template: TestRestTemplate

    @Before
    @Throws(Exception::class)
    fun setUp() {
        this.base = URL("http://localhost:$port/")
    }

    @Test
    @Throws(Exception::class)
    fun getHello() {
        val response = template.getForEntity(base.toString(),
                String::class.java)
        assertThat(response.getBody(), equalTo("Hello world!"))
    }

}