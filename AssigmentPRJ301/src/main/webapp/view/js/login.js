/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const personal = document.querySelector(".personal-form");
const business = document.querySelector(".business-form");
const form = document.querySelector("#form");
const change = document.querySelectorAll(".switch");

let current = 1;

function tab2() {
  form.style.marginLeft = "-100%";
  personal.style.background = "none";
  personal.style.color = "#000";
  business.style.background = "#000";
  business.style.color = "#fff";
  change[current - 1].classList.add("active");
}

function tab1() {
  form.style.marginLeft = "0";
  business.style.background = "none";
  business.style.color = "#000";
  personal.style.background = "#000";
  personal.style.color = "#fff";
  change[current - 1].classList.remove("active");
}

