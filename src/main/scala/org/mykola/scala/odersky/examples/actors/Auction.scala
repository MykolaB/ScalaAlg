package org.mykola.scala.odersky.examples.actors

import java.util.Date

import scala.actors.{TIMEOUT, Actor}

/**
 * Created by Mykola on 03.07.2015.
 */
class Auction(seller: Actor, minBid: Int, closing: Date) extends Actor {
  val timeToShutdown = 36000000
  val bidIncrement = 10

  def act(): Unit = {
    var maxBid = minBid - bidIncrement
    var maxBidder: Actor = null
    var running = true

    while (running) {
      receiveWithin((closing.getTime() - new Date().getTime())) {
        case Offer(bid, client) =>
          if (bid >= maxBid + bidIncrement) {
            if (maxBid >= minBid) maxBidder ! BeatenOffer(bid)
            maxBid = bid; maxBidder = client; client ! BestOffer
          }
          else {
            client ! BeatenOffer(maxBid)
          }
        case Inquire(client) =>
          client ! Status(maxBid, closing)
        case TIMEOUT =>
          if (maxBid >= minBid) {
            val reply = AuctionConcluded(seller, maxBidder)
            maxBidder ! reply; seller ! reply
          }
          else {
            seller ! AuctionFailed
          }
          receiveWithin(timeToShutdown) {
            case Offer(_, client) => client ! AuctionOver
            case TIMEOUT => running = false
          }

      }
    }
  }

}
