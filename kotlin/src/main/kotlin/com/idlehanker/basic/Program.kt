package com.idlehanker.basic

import java.nio.file.Path
import java.nio.file.Files
import java.nio.file.FileSystems
import java.io.IOException

import com.idlehanker.clazz.Person
import com.idlehanker.clazz.Person2

fun main(args: Array<String>) {

  println("Hello World!")
  /*Path path = FileSystems.getDefault().getPath("logs", "access.log");*/
  val path = FileSystems.getDefault().getPath(".","myLogs.txt")
  readFile(path)
  printLesssThanTwo()
  printlnUntilStop()
  implicitLabelUse()
  /**/
  println("###Person class")
  val person1 = Person("Alex","Smith", 29)
  val person2 = Person("Jane","Smith",null)

  println("${person1.firstName},${person1.lastName}, is ${person1.age} years old")
  println("${person2.firstName},${person2.lastName}, is ${person2.age?.toString() ?:"?"} years old")

  println("###Person2 class")
  val person3 = Person2("Donna","Jon",null)
  println("${person3.getName()}, is ${person3.getAge()?:"?"} years old.")

}

fun readFile(path: Path): Unit{
  println("###readFile content")
  val input = Files.newInputStream(path)
  try{
    var byte = input.read()
    while(byte != -1)
    {
      /*println(byte)*/
      var ch = byte.toChar()
      if (ch == '\r' || ch == '\n')
      println(ch)
      else
      print(ch)
      byte = input.read()
    }
    }catch(e: IOException){
      println("Error reading from file. error was ${e.message}")
      }finally{
        input.close()
      }
    }

    fun printLesssThanTwo(){
      println("###printLesssThanTwo value:")
      val list = listOf(1,2,3,4)
      list.forEach(fun(x){
        if (x < 2) println (x)
        else return
        })
        println("This line will still execute")
      }

      fun printlnUntilStop(){
        println("###printlnUntilStop")
        val list = listOf("a","b","stop","c")
        list.forEach stop@{
          if (it == "stop") return@stop
          else println(it)
        }
      }

      fun implicitLabelUse(){
        println("###implicitLabelUse")
        val list = listOf("e","f","g","stop","h")
        list.forEach {
          if (it == "stop") return@forEach
          else println(it)
        }
      }
