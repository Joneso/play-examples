package controllers

import javax.inject.Inject
import javax.inject.Singleton
import play.api.mvc._
import play.api.libs.json.{JsError,  JsSuccess, Json}
import dao.userForm
import dao.userForm._

@Singleton
class ApplicationController @Inject()(cc: ControllerComponents) extends  AbstractController(cc) {
  def login = Action {
    Ok(views.html.login("login"))
  }
  def doLogin(username:String, password: String)  = Action
  {
    implicit  request  =>
    val userData = new userForm(username, password)
    println(s"test is ${userData.toString}")
    Ok(Json.toJson(userData))
  }
  def jsonTest = Action(parse.json) {
    implicit request =>
      val json = request.body
      json.validate[userForm].fold(
        valid = (res => Ok(Json.toJson(res))),
        invalid = (e => BadRequest(e.toString()))
      )
  }
}

