import com.google.gson.Gson
import scan.Alert
import scan.AlertKt
import scan.Scan
import scan.ScanKt

fun AlertKt.Dsl.url(host: String, path: String): AlertKt.Dsl {
    url = "https://$host$path"
    return this
}

fun ScanKt.Dsl.alerts(json: String): ScanKt.Dsl {
    alerts += Gson().fromJson(json, AlertsWrapper::class.java).alerts
    return this
}

fun Scan.alertsToJson(): String = Gson().toJson(AlertsWrapper(alertsList))

data class AlertsWrapper(val alerts: List<Alert>)
