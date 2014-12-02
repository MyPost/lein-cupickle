# lein-cupickle

![A Pickle in a Cubicle](http://i.imgur.com/Ost19IX.png)

lein-cupickle is a Leiningen plugin that uses the [Cupickle](https://github.com/MyPost/cupickle)
library to run a set of cucumber features against a set of step definitions.

Stuck in your cubicle writing cucumber tests and clojure step-definitions?

Try lein-cupickle!


## Usage

Run `lein cupickle`.

Cupickle is configured in your project under the `:cupickle` key.

For information about the options available to lein-cupickle, refer
the the Cupickle library.

The two main config items you may be interested in are:

* :feature-path (defaults to "features")
* :step-path    (defaults to :feature-path)

These can be supplied as simple bare-word pairs on the shell:

> lein cupickle step-path special-features


### Project Setup

Use this for project-level plugins:

Put `[au.com.auspost/lein-cupickle "0.1.0"]` into the `:plugins` vector of your project.clj.

Put `[au.com.auspost/cupickle "0.1.0"]` into the `:dependencies`
vector of your project.clj if you are going to trigger cucumber test-runs from
within your code. This is not required if you only plan to trigger testing with
lein-cupickle.

Put `(:require [cupickle.steps :as cps])` into your namespace that is going to define steps.


### Example Feature

An example feature `unlock-grooved-cable.feature`:

		Feature: Unlock grooved cable
			@pre-unlock-cable
			Scenario: Unlocked grooved cable unlocked
				Given a grooved cable that is unlocked
				And the state of the cable is
				"""
				Dangerous
				"""
				When the pilot trys to unlock the grooved cable
				Then an error is raised
				"
				Grooved cable already unlocked!
				"
				And response :no-change is returned

			Scenario: Locked grooved cable unlocked
				Given a grooved cable that is locked
				When the pilot trys to unlock the grooved cable
				Then the state of the cable becomes
				"""
				Unlocked
				"""
				And a response :unlocked is returned

### Example step definition

An example step definition `grooved-cable-steps`:

		; The namespace should match the file-path with the step-path prefix removed
		(ns grooved-cable-steps
			(:require [cupickle.steps :refer :all]))

		; This is how you define a custom function without using the cupickle.steps macros
		(defn
			^{:cupickle-pattern #"Special case pattern .*"}
			foo-step [& x]
			(prn "Inside step-definition foo-step " x)
			(assert (re-matches #".*auth.*" (first x))))

		; Macros are available for the regular cucumber steps
		(Given #"a grooved cable that is (locked|unlocked)" [state]
					(assert (= state "Dangerous")))

		(Then #"the state.*" [& whatever]
					(prn "Inside Then step " whatever))


## License

Copyright © 2014 Australia Post

Distributed under the Apache License v2.0

## TODO

* Consider switching back from bultitude to tools.namespace
* Make sure that cupickle loads required dependencies
