package xyz.nextalone.nagram

enum class TabStyle(val value: Int) {
    DEFAULT(0),
    PURE(1),
    PILLS(2),
}

enum class SummarizeTextButtonStatus(val value: Int) {
    DEFAULT(0),
    DISABLE(1),
    ALWAYS(2),
}

enum class MainTabsStyle(val value: Int) {
    DEFAULT(0),
    TEXT_FREE(1),
    DISABLE(2),
    CLASSIC(3),
    MIUIX(4);

    companion object {
        @JvmStatic
        fun isFlat(value: Int): Boolean = value == CLASSIC.value || value == MIUIX.value
    }
}

enum class SwitchStyle(val value: Int) {
    TELEGRAM(0),
    MODERN(1)
}
