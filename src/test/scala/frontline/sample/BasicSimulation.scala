/*
 * Copyright 2011-2018 GatlingCorp (https://gatling.io)
 *
 * All rights reserved.
 */

package frontline.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseUrl("https://inclusionfinanciera.gob.sv/")

  val scn = scenario("scenario3")
    .exec(
      http("Home")
        .get("/")
    )
    .exec(
      http("CNIEF")
        .get("/cnief")
    )
    .exec(
      http("Inclusion")
        .get("/inclusion-financiera")
    )	
    .exec(
      http("Educacion Financiera")
        .get("/educacion-financiera")
    )
	.exec(
      http("Bitcoin")
        .get("/bitcoin-en-el-salvador")
    )
    .exec(
      http("Reportes Anuales")
        .get("/reportes-anuales")
    )	
    .exec(
      http("Publicaciones")
        .get("/publicaciones")
    )
    .exec(
      http("Contacto")
        .get("/contacto")
    )	
  setUp(
    scn.inject(constantConcurrentUsers(40000).during(300.seconds))
  ).protocols(httpConf)
}
