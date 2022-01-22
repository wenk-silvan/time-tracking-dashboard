package nl.hva.timetrackingdashboard.models

data class Section (
    val title: String,
    val timeframeDaily: Timeframe,
    val timeframeWeekly: Timeframe,
    val timeframeMonthly: Timeframe
)