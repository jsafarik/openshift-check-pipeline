def pipeline = {
	node("RHEL") {
		println("Hello world")
		node("RHEL") {
			println("Checking that delegate is still set correctly when methods from Build are nested")
		}
	}
}

if (binding.hasVariable('args') && args[0] == "local") {
	def mock = this.getClass().classLoader.loadClass('LocalBuild')?.getDeclaredConstructor()?.newInstance()
	pipeline.delegate = mock
}

pipeline.call()
