import play.api.libs.json.Json

package  object dao {
  implicit val addressFormat = Json.format[userForm]
}
