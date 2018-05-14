class Stack[A] {
  //Internal array buffer. Kind of like java array list
  private val arrayBuffer = new scala.collection.mutable.ArrayBuffer[A]()
  //Stack position pointer
  private var stack_pointer = -1

  def push(a: A): Unit = {
    stack_pointer = stack_pointer + 1
    arrayBuffer.append(a)
  }

  def pop(): Option[A] = {
    if (stack_pointer == -1) {
      None
    } else {
      val poppedElement = arrayBuffer(stack_pointer)
      stack_pointer = stack_pointer - 1
      Some(poppedElement)
    }
  }

  def peek(): Option[A] = {
    if (stack_pointer != -1) {
      Some(arrayBuffer(stack_pointer))
    } else {
      None
    }
  }
}

object Stack {
  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]

    stack.push(10)
    stack.push(20)
    stack.push(30)

    println(stack.pop())
    println(stack.peek())
  }
}
