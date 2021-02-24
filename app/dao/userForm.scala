package dao

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._


case class userForm( username : String , password:String)
object userForm{
  implicit  val userFormReads : Reads[userForm] = (
    (JsPath \ "username").read[String](email) and
      (JsPath \ "password").read[String](minLength[String](6))
  )(userForm.apply _)
  implicit  val userFormWrites : Writes[userForm] = (
    (JsPath \ "username").write[String] and
      (JsPath \ "password").write[String]
    )(unlift(userForm.unapply))
}