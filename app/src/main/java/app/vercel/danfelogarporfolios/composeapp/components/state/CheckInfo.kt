package app.vercel.danfelogarporfolios.composeapp.components.state

data class CheckInfo(
    val title: String,
    var selected: Boolean  = false,
    var onCheckedChange: (Boolean) -> Unit)
