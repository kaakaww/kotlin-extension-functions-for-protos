import scan.alert
import scan.scan
import scan.error

fun main() {

    val scan = scan {
        alerts += alert {
            requestMethod = "GET"

            // Alert Builder extension method
            url("app.test.company.com", "/api/v1/version")
        }

        errors += error {
            message = "Connection error"

            // Alert function/builder class
            url = url {
                host = "app.test.company.com"
                path = "/api/v2/user"
            }
        }
    }

    println(scan)

    // To/from JSON
    val json = scan.toJson()
    println(json)
    val jsonScan = fromJson(json)

    // Wrapper extension method
    val alertsJson = scan.alertsToJson()
    val newScan = scan {
        alerts(alertsJson)
    }
    println(newScan)
}
