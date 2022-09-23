package com.alex.fundamentosjunit

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class AssertionsTest{
    @Test
    fun getArrayTest(){
        //Instanciamos la clase que queremos testear
        val assertions = Assertions()
        //Ponemos los valores que se esperan
        val array = arrayOf(21,117) //valor esperado
        //val array = arrayOf(21,11)
        //Verificamos que los valores del array que hicimos arriba coincidan con los que se obtienen del metodo getLuckyNumbers
        //si esto es igual pasa la prueba
        assertArrayEquals("mensaje personalizado de error en testing",array,assertions.getLuckyNumbers())
    }

    @Test
    fun getNameTest(){
        val assertions = Assertions()
        val name = "Alain"
        val otherName = "Max"
        assertEquals(name, assertions.getName())
        assertNotEquals(otherName, assertions.getName())
    }

    @Test
    fun checkHumanTest(){
        val assertions = Assertions()
        val bot = User("8bit",1, false)
        val juan = User("Juan", 18, true)
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    @Test
    fun checkNullUserTest(){
        val user = null
        assertNull(user)
        val assertions = Assertions()
        assertNull(assertions.checkHuman(user))
    }

    @Test
    fun checkNotNullUserTest(){
        val juan = User("Juan", 18, false)
        assertNotNull(juan)
    }

    @Test
    fun checkNotSameUsersTest(){
        val bot = User("8bit",1, false)
        val juan = User("Juan", 18, true)
        assertNotSame(bot,juan)
    }

    @Test
    fun checkSameUsersTest(){
        //Si comparamos bot y juan para ver si son iguales va a marcar error ya que aunque tenga los mismos datos se crearon dos objetos distintos con los mismos datos
        val bot = User("Juan", 18, true)
        val juan = User("Juan", 18, true)
        val copyJuan = juan
        assertSame(copyJuan,juan)
    }

    //Este es un ejemplo de una prueba para simular el tipo que tarda en responder el servidor
    @Test(timeout = 1000)
    fun getCitiesTest(){
        val cities = arrayOf("Mexico","Peru", "Argentina")
        //Thread.sleep(Random.nextLong(200,1100))
        Thread.sleep(Random.nextLong(950,1050))
        assertEquals(3, cities.size)
    }
}