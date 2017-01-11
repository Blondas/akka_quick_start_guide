package reactiveTweets

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}


object TransformingConsumingSimpleStreams extends App {
  import DataModel._
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  // source
  val tweets: Source[Tweet, NotUsed] = Source.repeat(sampleTweet).take(5)

  val authors: Source[Author, NotUsed] = tweets
    .filter(_.hashtag.contains(akkaTag))
    .map(_.author)

  authors.runWith(Sink.foreach(println))
//  authors.runForeach(println)
}
