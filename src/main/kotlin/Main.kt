import scan.alert
import scan.scan

fun main() {

    val scan = scan {
        alerts += alert {
            requestMethod = "GET"
            url("app.test.company.com", "/api/v1/version")
        }
    }

    val alertsJson = scan.alertsToJson()

    val newScan = scan {
        alerts(alertsJson)
    }

    println(newScan)
}
