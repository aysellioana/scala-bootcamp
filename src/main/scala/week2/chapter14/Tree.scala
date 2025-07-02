package week2.chapter14
//ex7: Extend the tree in the preceding exercise so that each node can have an arbitrary number of children, and reimplement the leafSum function. The tree in
//Exercise 5 should be expressible as
//Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))

sealed abstract class Tree
case class Leaf2(value: Int) extends Tree
case class Node2(children: Tree*) extends Tree