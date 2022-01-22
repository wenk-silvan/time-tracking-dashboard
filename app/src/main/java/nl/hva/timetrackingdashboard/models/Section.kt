package nl.hva.timetrackingdashboard.models

data class Section (
    val title: String,
    val timeframes: Timeframes? = Timeframes(),
)