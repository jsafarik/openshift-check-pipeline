class LocalBuild {
	def node(String name, Closure closure) {
		println("Should run on ${name}, but running on local machine")
		closure.call()
	}
}

def pip = new pipeline()

pip.main("local")
