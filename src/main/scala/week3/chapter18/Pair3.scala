package week3.chapter18
//ex3:3. Given a class Pair[T, S], write a generic method swap that takes a pair as its
//argument and returns a new pair with the components swapped.

case class Pair3[T, S](first:T, second:S)
def swap[T,S](pair:Pair3[T,S]):Pair3[S,T]={
  Pair3(pair.second,pair.first)
}
