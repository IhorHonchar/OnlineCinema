package com.honchar.onlinecinema.core.extensions

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?) {
    if (p1 != null && p2 != null) block.invoke(p1, p2)
}