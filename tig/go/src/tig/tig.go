package main

import "../tiglib"


func main() {
	r := tiglib.Init()

	//println(r.String())

	println(r.Commit("hi"))
	println(r.Commit("there"))
}
