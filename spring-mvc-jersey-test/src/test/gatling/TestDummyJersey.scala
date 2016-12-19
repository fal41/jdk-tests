import io.gatling.core.Predef._
import io.gatling.core.session.Session
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.util.Random

class TestDummyJersey extends Simulation {

  val httpConf = http
          .baseURLs("http://localhost:8080")
          .acceptLanguageHeader("en-US,en;q=0.5")
          .acceptEncodingHeader("gzip, deflate")
          .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("TestDummyJersey")
    .during(120 seconds) {
      exec(
        http("request_1")
          .get("/spring-mvc-jersey-test-0.0.1-SNAPSHOT/hello")
          .check(status.is(200))
      )
        .pause(0.1 seconds)
    }

  setUp(
    scn.inject(rampUsers(100) over(2 seconds))
  ).protocols(httpConf)
}
