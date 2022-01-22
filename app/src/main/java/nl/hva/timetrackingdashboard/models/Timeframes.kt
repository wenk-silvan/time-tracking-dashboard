package nl.hva.timetrackingdashboard.models

import com.google.gson.annotations.SerializedName

data class Timeframes (
    @SerializedName("daily") var daily: Timeframe? = Timeframe(),
    @SerializedName("weekly") var weekly: Timeframe?  = Timeframe(),
    @SerializedName("monthly") var monthly: Timeframe? = Timeframe()
)