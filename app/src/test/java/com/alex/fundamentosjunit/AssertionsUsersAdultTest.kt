package com.alex.fundamentosjunit

import org.junit.*
import org.junit.Assert.*

class AssertionsUsersAdultTest {

    private lateinit var bot:User
    private lateinit var juan:User

    @get:Rule val locationESRule = LocationESRule()

    //Esto se ejecuta antes de los test, se usa para pruebas particulares o muy simples
    @Before
    fun setup(){
        bot = User("8bit",1, false)
        juan = User("Juan", 18, true)

    }

    @After
    fun tearDown(){
        bot = User()
        juan = User()

    }

    @Test
    fun isAdultTest() {
        /*val assertions = Assertions()
        assertions.setLocation("ES")
        assertTrue(assertions.isAdult(juan))
        assertTrue(assertions.isAdult(bot))*/
        //Resolver problemas de la herencia
        assertEquals(true, locationESRule.assertions?.isAdult(juan))
        //se cumple por que el bot no es humano y se considera un adulto aunque tenga un año
        assertEquals(true, locationESRule.assertions?.isAdult(bot))
    }
}