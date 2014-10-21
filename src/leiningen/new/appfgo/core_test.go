package core_test
import (
	"clojure.test"
	app "{{namespace}}"
)

test.deftest(aTest,
	test.testing("Greeting",
		test.is("Hello, World from Funcgo" == app.Greeting())
	)
)
