package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMutableMap
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BasicMutableMapImplTest {
    
    @Test
    fun shouldCreateBasicMutableMapFromRegularMap() {
        val basicMutableMap = BasicMutableMapImpl<Int, String>(mutableMapOf())

        assert(basicMutableMap is BasicMutableMap<Int, String?>)
    }

    @Test
    fun shouldReturnCorrectValuesForGivenKeys() {
        val basicMutableMap = BasicMutableMapImpl(mutableMapOf(1 to "A", 2 to "B", -7 to "ABC"))

        assertEquals(basicMutableMap[1], "A")
        assertEquals(basicMutableMap[2], "B")
        assertEquals(basicMutableMap[-7], "ABC")
    }

    @Test
    fun shouldReturnNullForNonExistingValues() {
        val basicMutableMap = BasicMutableMapImpl(mutableMapOf(1 to "A", 2 to "B", -7 to "ABC"))

        assertNull(basicMutableMap[-1])
        assertNull(basicMutableMap[3])
        assertNull(basicMutableMap[4])
    }

    @Test
    fun shouldReturnValidValueAfterSourceChange() {
        val source = mutableMapOf(1 to "G", 2 to "O")
        val basicMutableMap = BasicMutableMapImpl(source)
        assertEquals(basicMutableMap[1], "G")
        assertEquals(basicMutableMap[2], "O")
        source[1] = "E"
        source[2] = "P"
        assertEquals(basicMutableMap[1], "E")
        assertEquals(basicMutableMap[2], "P")
    }

    @Test
    fun shouldReturnNullWhenSourceValueDeleted() {
        val source = mutableMapOf(1 to "G")
        val basicMutableMap = BasicMutableMapImpl(source)
        assertEquals(basicMutableMap[1], "G")
        source.remove(1)
        assertNull(basicMutableMap[1])
    }
}