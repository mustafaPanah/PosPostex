package ir.postex.pos.presentation.main

object MainViewContract {

    data class MainViewStates(
        val pointsCount: Double = 0.0
    )

    sealed class MainViewEvents {
    }
}