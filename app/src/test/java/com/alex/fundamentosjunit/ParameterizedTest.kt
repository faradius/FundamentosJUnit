package com.alex.fundamentosjunit

import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

//Lo ideal es hacer diferentes tipos de archivos para realizar estas prubeas, aqui se hacen pruebas con parametros
//y analizar multiples datos en una misma prueba, aqui se hizo un ejemplo utilizando las reglas y sin ellas

@RunWith(value = Parameterized::class)
class ParameterizedTest(var currentValue:Boolean, var currentUser:User) {

   @get:Rule
    val locationESRule = LocationESRule()

    companion object{
        var assertions: Assertions? = null

        @BeforeClass @JvmStatic
        fun setupCommon(){
            assertions = Assertions()
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            assertions = null
        }


        @Parameterized.Parameters @JvmStatic
       /* fun getUserUS() = arrayOf(
            arrayOf(false, User("Pedro",12)),
            arrayOf(true, User("Clara",34)),
            arrayOf(true, User("Bot21",4, false)),
            arrayOf(false, User("Alex",18))
        )*/

        fun getUserES() = arrayOf(
            arrayOf(true, User("Pedro",19)),
            arrayOf(false, User("Clara",14)),
            arrayOf(true, User("Bot21",4, false)),
            arrayOf(true, User("Alex",18))
        )
    }

    @Test
    fun isAdultTest() {
        //assertEquals(currentValue, assertions?.isAdult(currentUser))
        assertEquals(currentValue, locationESRule.assertions?.isAdult(currentUser))
    }
}