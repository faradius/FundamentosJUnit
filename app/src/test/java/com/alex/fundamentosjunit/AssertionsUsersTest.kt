package com.alex.fundamentosjunit

import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass

import org.junit.Test

class AssertionsUsersTest {

    private lateinit var bot:User

    //Se hace esto para hacer pruebas que demanden muchos recursos y es mas que nada para liberar memoria
    //por lo tanto es necesario ponerlos en un BeforeClass y AfterClass para pruebas pesadas, pero tiene una serie de
    //requisitos que los metodos que contengas esas etiquetas debe esta dentro en un companion object ya que las
    //funciones deben de ser estaticas y las variables globales que estan siendo declaradas en cada metodo, para usarlas
    //es necesario ponerlo de igual manera en el companion object, por ultimo, en cada funcion que tenga el BeforeClass y AfterClass
    //se le debe añadir una etiqueta adicional que es @JvmStatic para indicar que es una funcion estatica
    companion object{
        private lateinit var juan:User
        @BeforeClass @JvmStatic
        fun setupCommon(){
            juan = User("Juan", 18, true)
            println("BeforeClass")
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            juan = User()
            println("AfterClass")
        }
    }

    //Esto se ejecuta antes de los test
    @Before
    fun setup(){
        bot = User("8bit",1, false)
        println("Before")
    }

    @After
    fun tearDown(){
        bot = User()
        println("After")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
        println("checkNoNull User")
    }

    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot,juan)
        println("checkNotSameUsers")
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan,juan)
        println("checkSameUsers")
    }
}