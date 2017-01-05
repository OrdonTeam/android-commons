package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap

class BasicMapImpl<Key, Value>(val source: Map<Key, Value>) : BasicMap<Key, Value?> {
    override fun get(key: Key): Value? = source[key]
}