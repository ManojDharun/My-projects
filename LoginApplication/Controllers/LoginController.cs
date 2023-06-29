using Microsoft.AspNetCore.Mvc;
using LoginApplication.Models;
using System.Collections.Generic;
namespace LoginApplication.Controllers
{
    public class LoginController : Controller
    {
        public IActionResult LoginDesign()
        {
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult validate(LoginViewModel model)
        {
            List<KeyValuePair<string,string>> list = new List<KeyValuePair<string,string>>();
            list.Add(new KeyValuePair<string, string>("manoj", "manoj@01"));
            list.Add(new KeyValuePair<string, string>("dharun", "dharun@04"));
            list.Add(new KeyValuePair<String, string>("admin", "password"));
            if (ModelState.IsValid)
            {
                if (list.Contains(new KeyValuePair<string, string>(model.UserName, model.Password)))
                {
                    return RedirectToAction("Dashboard", "Home");
                }
                else
                {
                    ModelState.AddModelError("", "Invalid username or password");
                }
            }
            return View("LoginDesign", model);
        }
    }
}
