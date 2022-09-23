package com.alex.fundamentosjunit

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class LocationESRule:TestRule {
    //La definición de reglas son como la definicion de requerimientos que debe cumplir antes de ser evaluado en el testing
    var assertions: Assertions? = null

    override fun apply(base: Statement, description: Description): Statement {
        return object:Statement(){
            override fun evaluate() {
                assertions = Assertions()
                assertions?.setLocation("ES")

                //Se mete en un try catch la evaluación de la prueba para liberar recursos
                try {
                    //ejecuta la declaración de la regla configurada
                    base.evaluate()
                } finally {
                    assertions = null
                }
            }

        }
    }

}