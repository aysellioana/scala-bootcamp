package week3.chapter17

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
//ex1: Consider the expression
//for (n1 <- Future { Thread.sleep(1000) ; 2 }
// n2 <- Future { Thread.sleep(1000); 40 })
// println(n1 + n2)

//How is the expression translated to map and flatMap calls? Are the two futures
//executed concurrently or one after the other? In which thread does the call
//to println occur?

object Ex1 extends App {
    Future { Thread.sleep(1000); 2 }.flatMap { n1 =>
      Future { Thread.sleep(1000); 40 }.map { n2 =>
        println(n1 + n2)
      }
    }

}
