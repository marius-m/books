package lt.markmerkk

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author mariusmerkevicius
 * @since 2016-11-03
 */
@RestController
class HelloController {

    @RequestMapping("/")
    fun index(): String {
        return "Hello world!"
    }
}